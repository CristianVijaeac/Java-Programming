/** 
 * @author Vijaeac Cristian-Octavian 325CB
 * 
 * Aceasta clasa primeste o expresie initiala,sub forma de string si o separa,in functie
 * de tipul elementelor gasite in aceasta(folosind clasa Verifications),in mai multe
 * substringuri bazate pe tipul elementelor,acestea fiind retinut-o intr-o lista
 * care va fi intoarsa de clasa.
 */




import java.util.ArrayList;

public  class createExpression {

	private String expr_init;
	
	/**
	 * Constructorul care initializeaza variabila in care stocam expresia initiala.
	 * @param expression expresia de prelucrat
	 */

	public createExpression(String expression){
	
		this.expr_init=expression;
		
	}
	
	/**
	 * Metoda care prelucreaza efectiv expresia primita ca parametru in constructor,
	 * efectuand prelucrari pentru impartirea acesteia in substringuri in functie de
	 * tipul elementelor.
	 * @return un vector de stringuri a carui fiecare element reprezinta un operator/operand.
	 */
	
	
	
	public String[] Expression(char[] expr_sep){
		String[] expr_fin= new String[expr_sep.length];
		int k=0;
		int i=0;
		
	while(i<expr_sep.length){
		if((expr_sep[i]>='A' && expr_sep[i]<='Z')||(expr_sep[i]>='a' && expr_sep[i]<='z')||(expr_sep[i]>='0' && expr_sep[i]<='9')){
			while((expr_sep[i]>='A' && expr_sep[i]<='Z')||(expr_sep[i]>='a' && expr_sep[i]<='z')||(expr_sep[i]>='0' && expr_sep[i]<='9')){
				if(expr_fin[k]==null){
					expr_fin[k]=String.valueOf(expr_sep[i]);
				}else{
					expr_fin[k]+=expr_sep[i];
				}
				i+=1;
				if (i==expr_sep.length) return expr_fin;
			}
		k++;
		}
		if(expr_sep[i-1]=='=' && (expr_sep[i]=='+' || expr_sep[i]=='-')){
			expr_fin[k]=String.valueOf(expr_sep[i]);
			i+=1;
			while(expr_sep[i]>='0' && expr_sep[i]<='9'){
					expr_fin[k]+=expr_sep[i];
					i++;
					if (i==expr_sep.length) return expr_fin;
					
			}
			
			k++;
		}
			
		if (expr_sep[i]=='+' || expr_sep[i]=='-' || expr_sep[i]=='*' || 
			expr_sep[i]=='=' || expr_sep[i]=='?' || expr_sep[i]=='>' || 
			expr_sep[i]==':' || expr_sep[i]==')' || expr_sep[i]=='('){
			
			expr_fin[k]=String.valueOf(expr_sep[i]);
			
			i+=1;
			if (i==expr_sep.length) return expr_fin;
			k++;
		}
	
	}
	return expr_fin;
	}
	
	/**
	 * Metoda care transforma vectorul de stringuri intr-o lista si returneaza aceasta lista.
	 * @return lista care contine substringurile.
	 */
	
public ArrayList<String> getExpr(){
		
		char[] expr_sep=new char[expr_init.length()];
		expr_sep=expr_init.toCharArray();
		
		String[] expr_fin= new String[expr_sep.length];
		ArrayList<String> expr_prel=new ArrayList<String>();
		
		expr_fin=Expression(expr_sep);

		for(int k=0;k<expr_fin.length;k++){
			if(expr_fin[k]!=null) expr_prel.add(expr_fin[k]);
		}
		
		return expr_prel;
	}
	
}
