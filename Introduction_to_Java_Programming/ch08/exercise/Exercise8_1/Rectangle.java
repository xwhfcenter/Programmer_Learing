//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Rectangle.java
//  @ Date : 2014/4/28
//  @ Author : Copperfield
//
//

public class Rectangle {
	double width = 1;
	double height = 1;
	
	public Rectangle() {    
	}
	
	public Rectangle(double newWidth, double newHeight) {
	    width = newWidth;
	    height = newHeight;
	}
	
	public double getArea() {
	    return width * height;
	}
	
	public double getPerimeter() {
	    return 2 * (width + height);
	}
}
