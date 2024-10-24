package org.example.behavioral.interator.begin;

//This enum represents the aggregate from iterator pattern
public enum ThemeColor {

	RED,
	ORANGE,
	BLACK,
	WHITE;

	static Iterator<ThemeColor> getIterator() {
		return new ThemeColorIterator();
	}

	private static class ThemeColorIterator implements Iterator<ThemeColor> {
		private int position;

		public boolean hasNext() {
			return position < ThemeColor.values().length;
		}

		public ThemeColor next() {
			return ThemeColor.values()[position++];
		}
	}

}

