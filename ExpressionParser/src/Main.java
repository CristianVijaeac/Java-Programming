/**
 * @author Vijaeac Cristian-Octavian 325CB
 * Clasa care contine metoda "main" cu ajutorul careia executam programul.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;





public class Main {

	/**
	 * Metoda care realizeaza citirea/scrierea din/in fisier si apeleaza metodele din clasele
	 * necesare rezolvarii acestei teme,executand operatiile necesare.
	 * @param args argumentele din linia de comanda(in cazul nostru,fisierul de intrare)
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		String f_intrare=args[0];
		BufferedReader in = new BufferedReader(new FileReader(f_intrare));
		BufferedWriter out1 = new BufferedWriter(new FileWriter(f_intrare.concat("_pt")));
		BufferedWriter out2 = new BufferedWriter(new FileWriter(f_intrare.concat("_sa")));
		BufferedWriter out3 = new BufferedWriter(new FileWriter(f_intrare.concat("_ee")));
		
		String expr_init;
		int line_no=0;
		ArrayList<String> variabile=new ArrayList<String>();
		ArrayList<Integer> valori=new ArrayList<Integer>();
		
		expr_init=in.readLine();
		
		while(expr_init!=null){

			line_no++;
			
			ArrayList<String> expr_prel=new createExpression(expr_init).getExpr();
			
			Stack<String> expression=new InfixToPrefix(expr_prel).getStack();
			
			ParseTree tree=new ParseTree(expression);
			OperationsOnTree op=new OperationsOnTree();

			int max_level=op.getLevel(tree.root,0);
			
			for(int i=0;i<=max_level;i++){
				op.printParseExpression(out1,tree.root,i);
				out1.write("\n");
			}	
			
			Node aux=tree.root;
			
			variabile=new variablesToValues(variabile,valori,aux,out2,line_no,expr_prel).getVariabile();
			valori=new variablesToValues(variabile,valori,aux,out2,line_no,expr_prel).getValori();
			
			new verifyCalculate(out2,out3,aux,line_no,variabile,valori,expr_prel);
			
			expr_init=in.readLine();
		}
		
	in.close();
	out1.close();
	out2.close();
	out3.close();
	}
}
