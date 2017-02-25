/**
 * @author Vijaeac Cristian-Octavian 325CB
 * Clasa care contine operatiile pe care le putem face asupra expresiilor:
 * 	-preluam nivelul maxim al arborelui de parsare al expresiei
 * 	-afisam expresia (utilizand arborele) conform documentatiei temei
 * 	-verificam existenta erorilor in cadrul expresiei
 * 	-rezolvam expresia
 */


import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;



public class OperationsOnTree extends ParseTree{
	
		Verifications v=new Verifications();

		/**
		 * Metoda care gaseste numarul maxim de nivele al unui arbore.
		 * @param aux radacina arborelui
		 * @param depth adancimea(nivelul) curent al arborelui
		 * @return inaltimea arborelui
		 */
		
		public int getLevel(Node aux, int depth){
			int leftDepth = depth, rightDepth = depth;
	     
			if(aux.moveLeft() != null){
				leftDepth = getLevel(aux.moveLeft(), depth+1);
			}
			if(aux.moveRight() != null){
				rightDepth = getLevel(aux.moveRight(), depth+1);
			}
	     
			return leftDepth > rightDepth ? leftDepth : rightDepth;
		}

		
		/**
		 * Metoda care parcurge arborele nivel cu nivel si il afiseaza,nivel cu nivel
		 * (afisarea realizandu-se ca in cerinta temei+paranteze pentru pastrarea unei
		 * egalitati aproximative intre expresia initiala si rezultatul parcurgeii arborelui)
		 * @param out1 fisierul de scriere a rezultatului
		 * @param current nodul curent pe care il analizam
		 * @param start_level nivelul de unde pornim analiza
		 * @throws IOException
		 */
		
		public void printParseExpression(BufferedWriter out1,Node current,int start_level) throws IOException{
		
			Node aux=current;
		
			if (aux==null) return;
		
			if (start_level>=0){
				if(v.isLeaf(aux) || start_level==0){
					if(v.isOperation(aux.getSymbol())){
						out1.write("E");
						return;
					}
					if(aux.moveParent().getSymbol().equals("+")||aux.moveParent().getSymbol().equals("-")||aux.moveParent().getSymbol().equals("=")){
						out1.write("T");
						return;
					}
				
					if(aux.moveParent().getSymbol().equals("*")){
						out1.write("F");
						return;
					}
					if(aux.moveParent().getSymbol().equals(">")||aux.moveParent().getSymbol().equals("?")||aux.moveParent().getSymbol().equals(":")){
						out1.write("N");
						return;
					}
				}else{
					out1.write("(");
					printParseExpression(out1,aux.moveLeft(),start_level-1);
					out1.write(aux.getSymbol());
					printParseExpression(out1,aux.moveRight(),start_level-1);
					out1.write(")");
				}
		
		}
		}
	
		/**
		 * Metoda care verifica daca expresia este plauzibila(corect).Mai exact,aceasta
		 * verifica daca la stanga egalului se afla o variabila si nu un numar/expresie.
		 * @param out2 fisierul in care afisam daca s-a gasit eroarea si locul unde se afla
		 * sau daca expresia este corecta
		 * @param aux radacina arborelui
		 * @param line linia pe care ne aflam in fisier
		 * @return true/false-exista eroare/nu exista eroare
		 * @throws IOException
		 */
		public boolean verifyExpression1(BufferedWriter out2,Node aux,int line) throws IOException{
		
			if (!v.isVariable(aux.moveLeft().getSymbol())) {
				out2.write("membrul stang nu este o variabila la linia "+line+" coloana 1\n");
				return false;
			}
		
			return true;
		}
		
		/**
		 * Metoda care verifica daca toate variabilele din expresia noastra exista,mai precis
		 * daca acestora li se asociaza un numar undeva,pe o linie,in fisier(analiza se incepe
		 * din dreapta egalului,deoarece la stanga avem sigur o variabila a carui rezultat trebuie
		 * aflat mai tarziu(verificarea existentei unei variabile si nu a unui numar se face in 
		 * clasa "Main",folosindu-ne de metoda @see verifyExpression2).
		 * @param out2 out2 fisierul in care afisam daca s-a gasit eroarea si locul unde se afla
		 * sau daca expresia este corecta
		 * @param line linie pe care ne aflam in fisier
		 * @param variabile lista de variabile existente si asociate cu un numar din expresie
		 * @param expr_prel lista ce contine operanzii/operatorii expresiei
		 * @return true/false expresie gresita/expresie corecta
		 * @throws IOException
		 */
		public boolean verifyExpression2(BufferedWriter out2,int line,ArrayList<String> variabile,ArrayList<String> expr_prel) throws IOException{	
			int i=0;
			boolean OK=false;
			for(i=2;i<expr_prel.size();i++){
				if(v.isVariable(expr_prel.get(i))){
					for(int j=0;j<variabile.size();j++){
						if (variabile.get(j).equals(expr_prel.get(i))) {OK=true;break;}
						else OK=false;
					}
					if(OK==false){
						out2.write("val nedeclarata la linia "+line+" coloana "+(i+1)+"\n");
						return false;
					}
				}
			}
			
			return true;
		}
	

		/**
		 * Metoda ce inlocuieste fiecare variabila gasita in arborele cu corespondetul
		 * ei numeric(vom avea numai numere in arbore).
		 * @param aux nodul de unde incepem prelucrarea
		 * @param valori lista de valori asociate fiecarei variabile	
		 * @param variabile lista de variabile existente in expresie
		 */
		public void replaceVariables (Node aux,ArrayList<Integer> valori,ArrayList<String> variabile){ 
			if (aux.moveLeft() != null){
				replaceVariables (aux.moveLeft(),valori,variabile);
			}
			if(v.isVariable(aux.getSymbol())){
				for(int i=0;i<variabile.size();i++){
					if(aux.getSymbol().equals(variabile.get(i))){
	    		//	System.out.println(aux.getSymbol());
						aux.setSymbol(valori.get(i).toString());
						break;
					}
				}
			}
			if (aux.moveRight() != null){
				replaceVariables (aux.moveRight(),valori,variabile);
			}
		}
	

	
		/**
		 * Metoda ce evalueaza expresia,intorcand rezultatul acesteia.
		 * @param nodul curent pe care il evaluam
		 * @param variabile lista de variabile existente in expresie
		 * @param valori lista de valori asociate fiecarei variabile
		 * @return intreg reprezentand rezultatul evaluarii expresiei
		 */
		public int solveExpression(Node aux,ArrayList<String> variabile,ArrayList<Integer> valori){
		
			aux=aux.moveRight();
			replaceVariables(aux,valori,variabile);
		
			return doMath(aux);
		
		}
	
	
		/**
		 * Metoda ce executa operatiile aritmetica gasite in nodurile arborelui si astfel,
		 * metoda ce calculeaza propriu-zis valoarea expresiei.
		 * @param aux nodul curent asupra caruia se face analiza
		 * @return rezultatul analizei expresiei(valoarea acesteia)
		 */
		public int doMath(Node aux){
		
			if(v.isLeaf(aux)) return Integer.parseInt(aux.getSymbol());
			
			else if(aux.getSymbol().equals("+")) {
				return doMath(aux.moveLeft())+doMath(aux.moveRight());
			}
			else if(aux.getSymbol().equals("-")) {
				return doMath(aux.moveLeft())-doMath(aux.moveRight());
			}
			else if(aux.getSymbol().equals("*")) {
				return doMath(aux.moveLeft())*doMath(aux.moveRight());
			}
		
			else if(aux.getSymbol().equals(">")) {
				return doMath(aux.moveLeft())>doMath(aux.moveRight())?1:0;
			}
		
			else if(aux.getSymbol().equals("?")) {
				return doMath(aux.moveLeft())==1?doMath(aux.moveRight()):0;
			}
	
			else if(aux.getSymbol().equals(":")) {
				int temp = doMath(aux.moveLeft());
				return temp==0?doMath(aux.moveRight()):temp;
			}
			return 0;
		}
	
	
}


