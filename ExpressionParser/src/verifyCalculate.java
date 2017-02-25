/**
 * @author Vijaeac Cristian-Octavian 325CB
 * Clasa care,inainte de a calcula o expresie o verifica:decide ce tip este(atribuire sau nu),daca intalneste
 * vreo eroare din cele 2 existente,iar daca nu se intampla niciunul din aceste lucruri,trece la rezolvarea
 * efectiva a expresiei utilizand clasa @see OperationsOnTree .
 */



import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class verifyCalculate {

	private Integer result;
	private boolean ok=false;
	private OperationsOnTree op=new OperationsOnTree();
	
	/**
	 * Constructor care calculeaza valoarea unei expresii si care,inainte de a trece la aceasta
 * etapa,verifica daca expresia este "calculabila":se verifica mai intai daca expresia intalneste una din cele
 * 2 erori,iar daca nu,se verifica daca este atribuire sau expresie de calculat.Se calculeaza expresia si,daca este nevoie,
 * se actualizeaza listele de variabile si valori ale acestora.
	 * @param out2 fisierul in care se scrie localizarea erorii(daca exista) sau OK daca nu exista eroare
	 * @param out3 fisierul in care se scrie rezultatul sau,daca nu poate fi calculat,eroare
	 * @param aux radacina arborelui de parsare
	 * @param line_no linia curenta din fisier
	 * @param variabile lista de variabile existente in fisier
	 * @param valori lista de valori asociate variabilelor
	 * @param expr_prel lista de operatori/operanzi ai expresiei
	 * @throws IOException
	 */
	public verifyCalculate(BufferedWriter out2,BufferedWriter out3,Node aux,int line_no,ArrayList<String> variabile,ArrayList<Integer> valori,ArrayList<String> expr_prel) throws IOException{
		if(op.verifyExpression1(out2, aux, line_no)){	
			if(op.verifyExpression2(out2, line_no, variabile, expr_prel)){	
				out2.write("Ok!\n");
				ok=true;
			}
		}
			
		if(ok==false) out3.write("error\n");
		else{
			if(op.v.isAttribution(aux)){
				for(int z=0;z<expr_prel.size();z++){
					out3.write(expr_prel.get(z));
				}
			out3.write("\n");
			}else {
				this.result=op.solveExpression(aux, variabile, valori);
				out3.write(aux.moveLeft().getSymbol()+aux.getSymbol()+result.toString());
				out3.write("\n");
				int p=0;
				for( p=0;p<variabile.size();p++){
					if(aux.moveLeft().getSymbol().equals(variabile.get(p))) break;
				}
				if (p==variabile.size()) variabile.add(aux.moveLeft().getSymbol());
					
				valori.add(p, result);
					
				
				}

		}
	
	}
	
	
}
