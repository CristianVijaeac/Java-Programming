/**
 * @author Vijaeac Cristian-Octavian 325CB
 *
 *Clasa care construieste un arbore de tip Trie si care adauga,sterge un element
 *primit ca parametru cu ajutorul unor metode,totodata,intoarce numarul de aparitii
 *ale unui cuvant(trimis ca parametru) in arbore si,pt un prefix dat,cauta in arbore
 *toate cuvintele care incep cu acel prefix.
 *
 */

import java.util.ArrayList;
import trie.AbstractTrie;
import trie.TrieElement;

public class Trie implements AbstractTrie{
	
	private char[] alfabet=new char[68] ;
	private Node root;

	/**
	 * Constructor care creeaza radacina arborelui si totodata alfabetul pe care
	 * se va baza programul nostru.
	 */
	public Trie(){
		this.root=new Node();
		
		this.alfabet[0]='!';
		this.alfabet[1]='(';
		this.alfabet[2]=')';
		this.alfabet[3]='-';
		
		for(int i=4;i<14;i++){
			this.alfabet[i]=(char) (i+44);
		}
		
		this.alfabet[14]='?';
		
		for(int i=15;i<41;i++){
			this.alfabet[i]=(char) (i+50);
		}
		
		this.alfabet[41]='_';
		
		for(int i=42;i<68;i++){
			this.alfabet[i]=(char) (i+55);
		}
	}
	
	
	/**
	 * Metoda ce adauga un element de TrieElement in arborele nostru in functie de
	 * tipul acestuia(Element1 sau Element2),depizand exclusiv de functia toCharArray
	 * @param element elementul ce trebuie introdus in arbore
	 */
	public void add(TrieElement element){
		
		char[] w=element.toCharArray();
		
		int i,j;
		Node aux=root;
	
		for(i=0;i<w.length;i++){
			
			for(j=0;j<68;j++){
				if (alfabet[j]==w[i]) break;
			}
			
			if(aux.children[j]==null){
				aux.children[j]=new Node();
				aux=aux.children[j];
			}else{
				aux=aux.children[j];
			}
			
			if(i+1==w.length){
				if(aux.getElement()!=null){
	
					if(aux.getElement().toString().compareTo(element.toString())>0){
						aux.setNo_Words(aux.getNo_Words()+1);
						aux.setElement(element);
					}else{
						aux.setNo_Words(aux.getNo_Words()+1);
					}
					
				}else{
					aux.setNo_Words(aux.getNo_Words()+1);
					aux.setElement(element);
				}
			}	
		}
	}
	
	/**
	 * Metoda care pentru un cuvant primit ca input sub forma de TrieElement intoarce
	 * numarul de aparitii in arborel ale acestuia
	 * @param element elementul din care preluam cuvantul ca input pt cautare.
	 * @return numarul de aparitii ale cuvantului,primit ca input,in arbore.
	 */
	public int count(TrieElement element){
		
		char[] w=element.toCharArray();
		int i=0,j=0;
		Node aux=root;
		
		for(i=0;i<w.length;i++){
			
			for(j=0;j<69;j++){
				if (alfabet[j]==w[i]) break;
			}
				
			if(aux.children[j]==null){
				return 0;
			}else{
				aux=aux.children[j];
			}
			
			if(i+1==w.length){
				return aux.getNo_Words();
			}
		}
		return 0;	
	}
	
	/**
	 * Metoda ce sterge cuvantul primit ca parametru sub forma de TrieElement din 
	 * arborele nostru.
	 * @param element elementul care contine cuvantul primit ca input pentru stergere
	 */
	public void remove(TrieElement element){
			Node aux=root;
			int i=0,j=0;
			char[] w=element.toCharArray();
		
			for(i=0;i<w.length;i++){
			
				for(j=0;j<69;j++){
					if (alfabet[j]==w[i]) break;
				}
				
				if(aux.children[j]==null){
						return ;
				}else{
						aux=aux.children[j];
				}
				if (i+1==w.length){	
					if(aux.getNo_Words()==1){
						aux.setNo_Words(0);
						aux.setElement(null);
						return;
					}else{
						if(aux.getNo_Words()>1){
							aux.setNo_Words(aux.getNo_Words()-1);
							return;
						}
						else return;
					}	
				}
			}
	}
		
		/**
		 * Metoda recursiva pentru parcurgerea in preordine a arborelui(stanga-dreapta-radacina)
		 * astfel incat sa putem extrage toate cuvintele care incep cu un prefix dat ca parametru
		 * functiei.
		 * @param temp_list lista in care vom memora elementele de tip TrieElement pe care
		 * le gasim in arbore(am ales un ArrayList datorita faptului ca nu putem stii de la inceput
		 * cate cuvinte vom gasi).
		 * @param elem	nodul de unde dorim sa incepem parcurgerea arborelui.
		 * @see ArrayList
		 */
	public void SDR(ArrayList<TrieElement> temp_list,Node elem){
		
		if(elem.getNo_Words()>=1){
			temp_list.add(elem.getElement());
		}	
		
		for(int j=0;j<elem.children.length;j++){
			if (elem.children[j]!=null){
				SDR(temp_list,elem.children[j]);
			}
		}
	}
	
	/**
	 * Metoda care,pentru un prefix primi ca parametru sub forma de TrieElement,cauta
	 * in tot arborele cuvintele care incep cu acesta si,datorita modului de constructie
	 * al arborelui vor fi returnate in ordine.
	 * @param prefix elementul care contine prefixul dupa care facem cautarea in arbore.
	 * @return TrieElement[] intoarce un vector de element TrieElement care contin toate
	 * cuvintele gasite.
	 * @see ArrayList
	 */
	public TrieElement[] getSortedElements(TrieElement prefix){
		
		ArrayList<TrieElement> temp_list=new ArrayList<TrieElement>();
		
		int i=0,j=0;
		Node aux=root;
		char[] w=prefix.toCharArray();
	
		while(i<w.length){
			for(j=0;j<69;j++){
				if (alfabet[j]==w[i]) break;
			}
	
			if(aux.children[j]==null){
				return null;
			}else{
				aux=aux.children[j];
				i++;
			}
		}	
	
		SDR(temp_list,aux);
	
		return temp_list.toArray(new TrieElement[temp_list.size()]);
	}
	
	
}
	