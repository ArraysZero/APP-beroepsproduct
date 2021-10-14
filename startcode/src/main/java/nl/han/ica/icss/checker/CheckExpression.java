package nl.han.ica.icss.checker;

public class CheckExpression {
	private final CheckOperation checkOperation;
	private final CheckVariable checkVariable;

	public CheckExpression(CheckOperation checkOperation) {
		this.checkOperation = checkOperation;
		this.checkVariable = new CheckVariable(this);
	}
}
