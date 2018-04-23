package Projekt1;

public class Ship 
{
	private int x;
	private int y;
	private char direction;
	private String name;
	
	public Ship(int x, int y, char direction, String name) 
	{
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.name = name;
	}
	
	public Ship(int x, int y, char direction) 
	{
		this(x, y, direction, "Nieznany");
	}
	
	//Getters-setters
	public int getX() {return this.x;}
	public void setX(int x) 
	{
		this.x = x;
	}
	public int getY() {return this.y;}
	public void setY(int y) 
	{
		this.y = y;
	}
	public char getDirection() {return this.direction;}
	public void setDirection(char direction) {this.direction = direction;}
	public String getName() {return this.name;}
}
