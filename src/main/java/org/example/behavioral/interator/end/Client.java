package org.example.behavioral.interator.end;

public class Client {

	public static void main(String[] args) {
		Iterator<ThemeColor> iter = ThemeColor.getIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
