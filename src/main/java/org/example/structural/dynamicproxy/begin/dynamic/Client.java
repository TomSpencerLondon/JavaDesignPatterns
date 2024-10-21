package org.example.structural.dynamicproxy.begin.dynamic;

import javafx.geometry.Point2D;
import org.example.structural.dynamicproxy.begin.Image;


public class Client {

	public static void main(String[] args) {
		Image image = ImageFactory.getImage();
		image.setLocation(new Point2D(-10, 10));
	}
}
