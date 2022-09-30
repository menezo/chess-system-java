package chess;

public enum Color {
	BLACK,
	WHITE;	
	public String toString() {
		switch(this) {
		case BLACK :
			return "BLACK";
		case WHITE :
			return "WHITE";
		}
		return null;
	}
}
