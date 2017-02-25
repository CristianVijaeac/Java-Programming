/**
 *  @author Vijaeac Cristian-Octavian 325CB
 *  	
 *  Clasa care construieste un element de tip TrieElement ce va definii structura
 *	arborelui trie cu ajutorul metodei toCharArray;
 */

import java.util.ArrayList;
import trie.TrieElement;

	public class Element2 implements TrieElement{

	private String word;
	
	/**
	 * Metoda care initializeaza un element de tip TrieElement cu un sir null.
	 */
	public Element2(){
		this.word="";
	}
	
	/**
	 * 	Metoda care initializeaza un element de tip TrieElement cu un sir primit ca parametru.
	 * @param word parametru de tip String reprezentand cuvantul memorat in acest TrieElement
	 */
	public Element2(String word){
		this.word=word;
	}
	
	/**
	 * Functia dupa care construim trie-ul,prelucrand sirul de caracter aflat in TrieElement
	 * in functie de cerinta noastra(aceasta ignora toate caracterele alfa-numerice alese
	 * de noi folosind un ArrayList) si returnand un vector de char-uri care formeaza
	 * cuvantul.
	 * @return vect_word vector de caractere ce compune cuvantul modificat.
	 * @see ArrayList
	 */
	public char[] toCharArray(){
		int i=0;
		ArrayList<Character> vect_word=new ArrayList<Character>();
		
		for(i=0;i<this.word.length();i++){	
			vect_word.add(this.word.charAt(i));	
		}
		
		int k=vect_word.size();
		
		for(i=0;i<k;i++){
			if(vect_word.get(i)=='(' || vect_word.get(i)==')' || vect_word.get(i)=='-' || vect_word.get(i)=='_'){
				vect_word.remove(i);
				k=k-1;
				i=i-1;
			}
		}
			
		char[] tmp = new char[vect_word.size()];
	    
		for (i = 0; i < tmp.length; i++) {
	        tmp[i]=vect_word.get(i);            
	    }	    
	    return tmp;
	}
	
	/**
	 * Metoda ce va intoarce campul de tip String din aceasta clasa.
	 * @return word cuvantul ce va fi intors.
	 */
	public String toString(){
		return this.word;
	}

}




