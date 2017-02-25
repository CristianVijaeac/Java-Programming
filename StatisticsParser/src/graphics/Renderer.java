package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;


public final class Renderer extends JFrame {
	// TODO(5.2): Implementati clasa Renderer cu ajutorul Fluent Builder pattern.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Point> points=new ArrayList<Point>();
	private int circleSize;
	private HashMap<visualiser.Color,java.awt.Color> mapColorCode;
	
	private Renderer(){
		
	}
	
	public static Builder builder(){
		return new Renderer.Builder();
	}
	
	public static class Builder{
	
		private Renderer r=new Renderer();

		public Builder(){
		}
		
		public Builder points(List<Point> points){
			r.points=points;
			return this;
		}
		
		public Builder circleSize(int circleSize){
			r.circleSize=circleSize;
			return this;
		}
		
		public Builder mapColorCode(HashMap<visualiser.Color,java.awt.Color> mapColorCode){
			r.mapColorCode=mapColorCode;
			return this;
		}
		
		public Builder withDefaultCloseOperation(int operation) {
			r.setDefaultCloseOperation(operation);
			return this;
		}

		public Builder withTitle(String title) {
			r.setTitle(title);
			return this;
		}
		public Renderer build(){
			return r;
		}

		
		
	}
	
	
	public void draw() {
		setSize(1500,300);
		setVisible(true);
	}
	
	public void addPoint(int x, int y, visualiser.Color color) {
		// TODO(5.2): Adaugati listei curente de puncte ce trebuiesc desenate, un nou punct cu
		// dimensiunea si culoarea primite ca parametrii.
		
		points.add(new Point.Builder()
								.xCoord(x)
								.yCoord(y)
								.color(color)
								.build());
	}
	
	@Override
	public void paint(Graphics g) {
		Shape circle;
		Graphics2D ga = (Graphics2D)g;
		for (Point p : points) {
			circle = new Ellipse2D.Float(p.getX(), p.getY(), circleSize, circleSize);
		  	ga.draw(circle);
		  	ga.setPaint(getColor(p));
		  	ga.fill(circle);
		}
	}
	
	private Color getColor(Point p) {
		// TODO(5.2): Returnati culoarea (Color) din pachetul awt, aferenta punctului curent.
		// Hint: utilizati o mapare visualisation.Color -> awt.Color.
		return mapColorCode.get(p.getColor());
	}
}
