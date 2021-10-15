package nl.han.ica.icss.generator;


import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {

	private StringBuilder builder;

	public Generator() {
		builder = new StringBuilder();
	}

	public String generate(AST ast) {
		generateNode(ast.root);
        return builder.toString();
	}

	private void generateNode(ASTNode astNode) {
		for (int i = 0; i < astNode.getChildren().size(); i++) {
			if (astNode.getChildren().get(i) instanceof Stylerule) {
				this.generateSelector(astNode.getChildren().get(i));

				this.generateDeclaration(astNode.getChildren().get(i));

				this.builder.append("}\n\n");
			}
		}

		// Remove one \n character.
		if (this.builder.length() > 1) {
			this.builder.delete(this.builder.length() - 1, this.builder.length());
		}
	}

	private void generateSelector(ASTNode astNode) {
		Stylerule stylerule = (Stylerule) astNode;

		List<String> selectors = stylerule.selectors.stream()
				.map(ASTNode::toString)
				.collect(Collectors.toList());

		String str = String.join(", ", selectors);
		this.builder.append(str);

		this.builder.append(" {\n");
	}

	private void generateDeclaration(ASTNode astNode) {
		for (ASTNode node : astNode.getChildren()) {
			if (node instanceof Declaration) {
				Declaration declaration = (Declaration) node;
				this.builder.append("  ")
						.append(declaration.property.name)
						.append(": ")
						.append(this.expressionToString(declaration.expression))
						.append(";\n");
			}
		}
	}

	private String expressionToString(Expression expression) {
		if (expression instanceof PercentageLiteral) {
			return ((PercentageLiteral) expression).value + "%";
		}
		if (expression instanceof PixelLiteral) {
			return ((PixelLiteral) expression).value + "px";
		}
		if (expression instanceof ColorLiteral) {
			return ((ColorLiteral) expression).value + "";
		}

		return "";
	}
}
