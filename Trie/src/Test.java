/**
 * @author Vijaeac Cristian-Octavian 325CB
 */

import trie.TrieElement;
import test.*;

public class Test {
	
	/**
	 * Metoda Main ce permite executarea programului prin citirea cuvintelor,a comenzilor si a
	 * parametrilor dintr-un fisier si totodata scrierea rezultatelor finale intr-un nou fisier.
	 * @see Command
	 * @see AddCommand
	 * @see CountCommand
	 * @see ListCommand
	 * @see RemoveCommand
	 * @see TestWriter
	 * @see TestReader
	 * @param args argumentele din linia de comanda(neutilizate in implementarea acestei teme)
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args){
		
		int i=0;
		
		Trie trie1=new Trie();
		Trie trie2=new Trie();
		TrieElement[] t=new TrieElement[50];
		
	
		TestReader input=new TestReader("C:\\Users\\CristianV\\Desktop\\input\\test9.in");
		TestWriter output=new TestWriter("C:\\Users\\CristianV\\Desktop\\rezultat.txt");
		
		String[] words=input.getWords();
		Command[] getFirstCommand=input.getFirstCommands();
		Command[] getSecondCommand=input.getSecondCommands();
		
		
		
		for(i=0;i<words.length;i++){
			trie1.add(new Element1(words[i]));
			trie2.add(new Element2(words[i]));
		}
		
		for(i=0;i<getFirstCommand.length;i++){
			if(getFirstCommand[i].getType()==0){
				trie1.add(new Element1(getFirstCommand[i].getWord()));
			}
			if(getFirstCommand[i].getType()==1){
				trie1.remove(new Element1(getFirstCommand[i].getWord()));
			}
			if(getFirstCommand[i].getType()==2){
				output.printCount(trie1.count(new Element1(getFirstCommand[i].getWord())));
			}
			if(getFirstCommand[i].getType()==3){
				t=trie1.getSortedElements(new Element1(getFirstCommand[i].getWord()));
				output.printSortedWords(t);
			}	
		}
		
		for(i=0;i<getSecondCommand.length;i++){
			if(getSecondCommand[i].getType()==0){
				trie2.add(new Element2(getSecondCommand[i].getWord()));
			}
			if(getSecondCommand[i].getType()==1){
				trie2.remove(new Element2(getSecondCommand[i].getWord()));
			}
			if(getSecondCommand[i].getType()==2){
				output.printCount(trie2.count(new Element2(getSecondCommand[i].getWord())));
			}
			if(getSecondCommand[i].getType()==3){
				t=trie2.getSortedElements(new Element2(getSecondCommand[i].getWord()));
				output.printSortedWords(t);
		}
	}
	output.close();
	}
	
}



