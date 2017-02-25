/**
 * @author Vijaeac Cristian-Octavian 325CB
 *
 *Clasa care construieste un nod format din numarul de aparitii ale unui cuvant,
 *vectorul de copii al nodului si un element de tip TrieElement care memoreaza cuvantul
 *dupa care se face adaugarea nodului.
 */

import trie.TrieElement;

public class Node {
	
	private int no_Words;
	Node[] children=new Node[68];
	private TrieElement element;
	
	/**
	 * Constructor care creeaza un nod in arbore initializand campurile cu valori 
	 * elementare(null,0).
	 */
	public Node(){
		this.element=null;
		this.no_Words=0;
	}
	
	/**
	 * Constructor care creeaza un nod in arbore initializand campul element continand
	 * o structura de tip TrieElement cu o valoare data ca parametru
	 * @param elem	elementul ce va fi memorat in nod
	 */
	public Node(TrieElement elem){
		this.element=elem;
		this.no_Words=0;
	}
	
	/**
	 * Metoda ce intoarce un TrieElement pentru viitoare prelucrari
	 * @return	o structura de tip TrieElement
	 */
	public TrieElement getElement() {
		return element;
	}

	/**
	 * Metoda ce schimba o structura de tip TrieElement cu o alta primita ca parametru
	 * @param elem structura ce va inlocuii elementul deja existent in nod
	 */
	public void setElement(TrieElement elem) {
		this.element=elem;
	}

	/**
	 * Metoda ce intoarce numarul de aparitii ale unui cuvant memorat intr-un nod.
	 * @return numarul de aparitii ale unui cuvant.
	 */
	public int getNo_Words() {
		return no_Words;
	}

	/**
	 * Metoda ce modifica numarul de aparitii ale unui cuvant memorat intr-un nod.
	 * @param no_Words cuvantul ce va inlocuii String-ul memorat deja in nod
	 */
	public void setNo_Words(int no_Words) {
		this.no_Words = no_Words;
	}


}
