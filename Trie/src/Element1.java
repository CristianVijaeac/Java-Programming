/**
 * 
 * 
 * @author Vijaeac Cristian-Octavian 325C
 * 
 *	Clasa care construieste un element de tip TrieElement ce va definii structura
 *	arborelui trie cu ajutorul metodei toCharArray;
 * 
 * 
 */

import trie.TrieElement;

public class Element1 implements TrieElement{
	
	private String word;
	
	/**
	 * Constructorul care initializeaza un element de tip TrieElement cu un sir null.
	 */
	public Element1(){
		this.word="";
	}
	
	/**
	 * 	Metoda care initializeaza un element de tip TrieElement cu un sir primit ca parametru.
	 * @param word parametru de tip String reprezentand cuvantul memorat in acest TrieElement
	 */
	public Element1(String word){
		this.word=word;
	}
	
	/**
	 * Functia dupa care construim trie-ul,prelucrand sirul de caracter aflat in TrieElement
	 * in functie de cerinta noastra(aceasta transforma toate literele mari in litere mici).
	 * @return vect_word - vector de caractere ce compune cuvantul modificat.
	 */
	public char[] toCharArray(){
		String tmp;
		
		tmp=this.word.toLowerCase();
	
		char[] vect_word=tmp.toCharArray();
	
		return vect_word;
	}
	
	/**
	 * Metoda ce va intoarce campul de tip String din aceasta clasa.
	 * @return word -cuvantul ce va fi intors.
	 */
	public String toString(){
		return this.word;
	}
		
}

