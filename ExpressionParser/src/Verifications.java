/**
 * @author Vijaeac Cristian-Octavian 325CB
 * Clasa care contine verificari efectuate asupra expresiilor sau a unor elemente din expresie sau chiar din arborele de parsare.
 */


public class Verifications {
	
	/**
	 * Metoda care verifica daca o expresie este,de fapt,o atribuire.
	 * @param aux radacina arborelui
	 * @return true/false
	 */
	
	public boolean isAttribution(Node aux){
		//System.out.println(aux.moveLeft().getSymbol());
		if(isVariable(aux.moveLeft().getSymbol()) && aux.getSymbol().equals("=") && isLeaf(aux.moveRight())){
			return true;
		}else return false;
	}

	/**
	 * Metoda care verifica daca un element al unei expresii/arbore este o variabila.
	 * @param var elementul asupra caruia facem verificarea.
	 * @return true/false
	 */
	public boolean isVariable(String var){
	
		char[] x=var.toCharArray();
		boolean OK=false;
		
		if(isNumber(var)) return false;
	
		for(int i=0;i<x.length;i++){
			if(x[i]=='+' || x[i]=='-') continue;
			if ((x[i]>='a' && x[i]<='z')|| (x[i]>='A' && x[i]<='Z') || (x[i]>='0' && x[i]<='9')) OK=true;
			else OK=false;
		}
	
		return OK;
	}

	/**
	 * Metoda care verifica daca un element al unei expresii/arbore este un numar.
	 * @param var elementul asupra caruia facem verificarea
	 * @return true/false
	 */
	public boolean isNumber(String var){
		char[] x=var.toCharArray();
		boolean OK=false;
	
		for(int i=0;i<x.length;i++){
			if(x[i]=='+' || x[i]=='-') continue;
			if ((x[i]>='0' && x[i]<='9')) OK=true;
			else {OK=false; break;}
		}
		return OK;				
	}

	/**
	 * Metoda care verifica daca un element al unei expresii/arbore este un operator.
	 * @param x elementul asupra caruia facem verificarea
	 * @return true/false
	 */
	public boolean isOperation(String x){
	
		if (x.equals("+") ||x.equals("-") ||x.equals("*") || 
			x.equals("?") || x.equals(">")|| 
			x.equals(":")||x.equals("=")){
		return true;
		}else return false;
	}

	/**
	 * Metoda care verifica daca un nod din arbore este o frunza(nu are copii).
	 * @param n nodul asupra caruia facem verificarea
	 * @return true/false
	 */
	public boolean isLeaf(Node n){
		if (n.moveLeft()==null && n.moveRight()==null) return true;
		else return false;
	}

}
