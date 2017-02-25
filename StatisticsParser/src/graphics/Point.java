package graphics;

import visualiser.Color;


public final class Point {
	// TODO(5.1): Implementati clasa Point cu ajutorul Fluent Builder Pattern.
	private int x;
	private int y;
	private Color color;
	
	private Point(){
		
	}
	
	public static Builder builder(){
		return new Point.Builder();
	}
	
	public static class Builder{
	
		private Point p=new Point();

		public Builder(){
		}
		
		public Builder xCoord(int x){
			p.x=x;
			return this;
		}
		
		public Builder yCoord(int y){
			p.y=y;
			return this;
		}
		
		public Builder color(Color col){
			p.color=col;
			return this;
		}
		
		public Point build(){
			return p;
		}
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
