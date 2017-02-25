/**
 * @author Vijaeac Cristian-Octavian 325CB
 *Clasa care construieste/modifica/completeaza lista ce contine variabilele existente in fisierul de intrare
 *si lista valorilor acestor variabile.
 **In cadrul acestei clase se decide si daca o expresie este atribuire,daca variabila exista deja in lista,
 *daca o variabila nu are nici o valoare,daca unei variabile i-a fost modificata valoarea(caz in care se modifica)
*si valoarea din arbore),etc.Totodata,clasa face cele 2 verificari pentru cele 2 tipuri de erori.
*/



import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class variablesToValues {
	
	private ArrayList<String> variabile=new ArrayList<String>();
	private ArrayList<Integer> valori=new ArrayList<Integer>();
	private OperationsOnTree op=new OperationsOnTree();

	/**
	 * Constructor care construieste/modifica/actualizeaza cele 2 liste:de variabile si de 
	 * valori asociate variabilelor si care verifica prezenta celor 2 posibilele erori.
	 * @param variabile lista de variabile asa cum exista ea pana in momentul intrarii in metoda
	 * @param valori lista de variabile asa cum exista ea pana in momentul intrarii in metoda
	 * @param aux nodul din arbore necesar unor verificari
	 * @param out2 fisierul in care scriem erorile,in cazul in care exista
	 * @param line_no numarul liniei pe care ne afla in fisier
	 * @param expr_prel	lista care contine operatorii/operanzii din expresie
	 * @throws NumberFormatException 
	 * @throws IOException
	 */
	public variablesToValues(ArrayList<String> variabile,ArrayList<Integer> valori,Node aux,BufferedWriter out2,int line_no,ArrayList<String> expr_prel) throws NumberFormatException, IOException{

		this.variabile=variabile;
		this.valori=valori;
		
		int h=0;
	if(op.v.isAttribution(aux)){
		if(op.v.isNumber(aux.moveRight().getSymbol())){
			if(op.verifyExpression1(out2, aux,line_no)){
				for(h=0;h<variabile.size();h++){
					if(variabile.get(h).equals(aux.moveLeft().getSymbol())) {
						valori.add(h,Integer.parseInt(aux.moveRight().getSymbol()));
						break;
					}
				}
			if (h==variabile.size()) {variabile.add(aux.moveLeft().getSymbol());
			valori.add(Integer.parseInt(aux.moveRight().getSymbol()));
			}
		}
		}else if(op.v.isVariable(aux.moveRight().getSymbol()) && (op.verifyExpression2(out2, line_no, variabile, expr_prel))){
			
			for(h=0;h<variabile.size();h++){
				if(variabile.get(h).equals(aux.moveRight().getSymbol())) break;
			}
			variabile.add(aux.moveLeft().getSymbol());
			valori.add(valori.get(h));
			aux.moveRight().setSymbol(valori.get(h).toString());
			expr_prel.remove(2);
			expr_prel.add(2,valori.get(h).toString());
			
		}
			
		}
	}
		
	/**
	 * Metoda ce intoarce lista de variabile.
	 * @return lista de variabile
	 */
	public ArrayList<String> getVariabile(){
		return variabile;
	}
	
	/**
	 * Metoda ce intoarce lista de valori ale variabilelor
	 * @return lista de valori
	 */
	public ArrayList<Integer> getValori(){
		return valori;
	}

}
