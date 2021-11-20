package nl.han.ica.icss.parser;

public class SyntaxError{
	public String description;

	public SyntaxError(String description) {
		this.description = description;
	}
	public String toString() {
		return "ERROR: " + description;
	}
}
