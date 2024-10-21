package org.example.structural.staticproxy.begin;


public class Client {

	public static void main(String[] args) {
		Image image = ImageFactory.getImage("A1.bmp");

		image.setLocation(new Point2D(10, 10));

		System.out.println("Image location : " + image.getLocation());
		System.out.println("rendering image now...");
		image.render();
	}

}
