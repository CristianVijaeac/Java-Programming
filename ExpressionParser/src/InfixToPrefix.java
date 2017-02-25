/**
 * @author Vijaeac Cristian-Octavian 325CB
 * Aceasta clasa aplica algoritmul de transformare a unei expresii din forma "infix",in
 * forma "postfix",intrucat,folosind aceasta forma a expresia vom putea creea arborele
 * de partitionare mult mai usor.
 * @url http://csis.pace.edu/~wolf/CS122/infix-postfix.htm
 */



import java.util.ArrayList;
import java.util.Stack;

public class InfixToPrefix {

	private Stack<String> mainStack;
	private Stack<String> opStack;
	
	/**
	 * Constructorul primeste ca parametru lista de operatori/operanzi si transforma
	 * expresia formata de aceasta lista intr-o expresia sub forma "postfix".Folosind
	 * 2 stive(una in care se retin operatorii si alta in care se retin operanzii) si un
	 * set de reguli,constructorul va modifica stiva principala(mainStack) astfel incat
	 * la finalul executiei constructorului vom avea expresia modificat chiar in aceasta
	 * stiva. 
	 * @param expr expresia ce urmeaza a fi modificata
	 */
	public InfixToPrefix(ArrayList<String> expr){
		
		mainStack=new Stack<String>();
		opStack=new Stack<String>();
		
		int i=0;
		int OK=0;
		int k=0;	//variabila
		int j=0;
		String[] operations={"*","-","+",">","?",":","="};
		
		while(i<expr.size()){
			OK=0;
			for(j=0;j<operations.length;j++){
				if(expr.get(i).equals(operations[j])|| expr.get(i).equals("(") || expr.get(i).equals(")"))  {OK=0; break;}
				else OK=1;
			}
			if(OK==1) {mainStack.push(expr.get(i));i++;continue;}
			else{
				if(opStack.empty() || opStack.peek().equals("(")){
					opStack.push(expr.get(i));
					i++;continue;
				}

				if(expr.get(i).equals("(")) {opStack.push(expr.get(i));i++;continue;}
				if(expr.get(i).equals(")")) {
					
					while(!opStack.peek().equals("(")){
						
						mainStack.push(opStack.pop());
					}
					opStack.pop();
					i++;continue;
				}
				
				if(!expr.get(i).equals("(") && !expr.get(i).equals(")")){
					
					for(k=0;k<operations.length;k++){
						if(operations[k].equals(opStack.peek())) break;
					}
					if(j<k){
						opStack.push(expr.get(i));
					}else if(j>=k){
						while(j>=k && !opStack.empty()){
							if (opStack.peek().equals("(")) break;
							mainStack.push(opStack.pop());
							for(int z=0;z<operations.length;z++){
								if (!opStack.empty() && opStack.peek().equals(operations[z])) {k=z;break;}
							}
						}
							
							opStack.push(expr.get(i));
					}
				}
						
			}
			
			i++;
			
		
		}
			while(!opStack.empty()){
				mainStack.push(opStack.pop());
		}
	
	
	}
	
	/**
	 * Metoda ce returneaza stiva care contine expresia modificata.
	 * @return stiva expresiei "postfix"
	 */
	
	public Stack<String> getStack(){
		return mainStack;
	}
	
}
