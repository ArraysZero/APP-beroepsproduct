package nl.han.ica.icss.checker;

public class SemanticError {
	public String description;

	public SemanticError(String description) {
		this.description = description;
	}
	public String toString() {
		return "ERROR: " + description;
	}
}
