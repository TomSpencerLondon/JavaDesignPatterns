package org.example.structural.staticproxy.begin;

public class ImageFactory {
	//We'll provide proxy to caller instead of real object

    public static Image getImage(String name) {
        return new ImageProxy(name);
    }
}
