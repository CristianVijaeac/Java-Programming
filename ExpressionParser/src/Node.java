/**
 * @author Vijaeac Cristian-Octavian 325CB
 * Clasa care construieste/modifica un nod pentru arborele de parsare.
 */



public class Node {
	
	private Node left_child;
	private Node right_child;
	private Node parent;
	private String symbol;

	/**
	 * Constructorul care initializeaza "by default" un nod.
	 */

	public Node(){
		this.symbol="";
		this.left_child=null;
		this.right_child=null;
	
	}
	
	/**
	 * Constructor care initializeaza un nod in care stocam informatia primita ca parametru
	 * @param sym informatia ce urmeaza a fi stocata in nod
	 */
	public Node(String sym){
		this.symbol=sym;
		this.left_child=null;
		this.right_child=null;
	
	}
	
	/**
	 * Metoda cu care putem accesa fiul stang al nodului curent.
	 * @return fiul stang al nodului curent
	 */
	
	public Node moveLeft() {
		return left_child;
	}

	/**
	 * Metoda cu care putem accesa fiul drept al nodului curent.
	 * @return fiul drept al nodului curent
	 */
	public Node moveRight() {
		return right_child;
	}
	
	/**
	 * Metoda cu care putem accesa nodul parinte al nodului curent.
	 * @return nodul parinte al nodului curent
	 */
	public Node moveParent(){
		return parent;
	}

	
	/**
	 * Metoda ce intoarce informatia existenta in nod.
	 * @return informatia stocata in nod
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/**
	 * Metoda pe baza careia setam copilul stang al nodului curent.
	 */

	public void setLeft_child(Node left_child) {
		this.left_child = left_child;
	}

	
	/**
	 * Metoda pe baza careia setam copilul drept al nodului curent.
	 */
	public void setRight_child(Node right_child) {
		this.right_child = right_child;
	}
	
	/**
	 * Metoda pe baza careia setam nodul parinte al nodului curent.
	 */
	public void setParent(Node parent) {
		this.parent= parent;
	}

	/**
	 * Metoda pe baza careia setam informatia in nodul curent.
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}
