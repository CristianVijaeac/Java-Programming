/**
 * @author Vijaeac Cristian-Octavian 325CB
 *Clasa care construieste arborele de parsare.
 */

import java.util.Stack;

public class ParseTree {

	Node root;
	Verifications v=new Verifications();
	
	/**
	 * Constructor ce initializeaza "by default" radacina arboreui.
	 */
	public ParseTree(){
		this.root=new Node("");
	}

	/**
	 * Constructor ce initializeaza arborele pornind de la stiva expresiei sub forma "postfix".
	 * @param expr stiva ce contine expresia in forma "postfix"
	 */
	public ParseTree(Stack<String> expr){	
	
			this.root=new Node(expr.pop());
			Node aux=root;

		
			while(!expr.empty()){
				if (v.isOperation(expr.peek())){
					if(v.isLeaf(aux)){
						//System.out.println(expr.peek());
						aux.setRight_child(new Node(expr.pop()));
						aux.moveRight().setParent(aux);
						aux=aux.moveRight();
						//System.out.println(aux.moveParent().getSymbol());
					continue;
					}
					if(aux.moveLeft()!=null && aux.moveRight()==null){
						aux.setRight_child(new Node(expr.pop()));
						aux.moveRight().setParent(aux);
						aux=aux.moveRight();
						continue;
					}
					if(aux.moveRight()!=null && aux.moveLeft()==null){
						aux.setLeft_child(new Node(expr.pop()));
						aux.moveLeft().setParent(aux);
						aux=aux.moveLeft();
						continue;
					}
				}else{
					
					if(v.isLeaf(aux)){
					//	System.out.println(expr.peek());
						aux.setRight_child(new Node(expr.pop()));
						aux.moveRight().setParent(aux);
						if(aux.moveLeft()!=null && aux.moveRight()!=null)	
							while(!aux.getSymbol().equals("=") && aux.moveLeft()!=null && aux.moveRight()!=null)
								aux=aux.moveParent();
					continue;
					}
					if(aux.moveLeft()!=null && aux.moveRight()==null){
						System.out.println(expr.peek());
						aux.setRight_child(new Node(expr.pop()));
						aux.moveRight().setParent(aux);
						if(aux.moveLeft()!=null && aux.moveRight()!=null)	
							while(!aux.getSymbol().equals("=") && aux.moveLeft()!=null && aux.moveRight()!=null) {
								aux=aux.moveParent();}
					continue;
					}
					if(aux.moveRight()!=null && aux.moveLeft()==null){
						aux.setLeft_child(new Node(expr.pop()));
						aux.moveLeft().setParent(aux);
						if(aux.moveLeft()!=null && aux.moveRight()!=null)	
							while(!aux.getSymbol().equals("=") && aux.moveLeft()!=null && aux.moveRight()!=null)
								
								aux=aux.moveParent();
								
					continue;
					}
					
				}
			
				
			}	
					
			
	}
		
	}
	
	



		
