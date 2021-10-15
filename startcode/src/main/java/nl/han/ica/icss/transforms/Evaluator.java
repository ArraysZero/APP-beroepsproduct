package nl.han.ica.icss.transforms;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.BoolLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.DivideOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Evaluator implements Transform {

    private IHANLinkedList<HashMap<String, Expression>> variableValues;

    public Evaluator() {
        variableValues = new HANLinkedList<>();
    }

    @Override
    public void apply(AST ast) {
        variableValues = new HANLinkedList<>();

        transformSheet(ast.root);
    }

    private void transformSheet(Stylesheet sheet){
        variableValues.addFirst(new HashMap<>());
        ArrayList<ASTNode> toRemove = new ArrayList<>();
        for (int i = 0; i < sheet.getChildren().size(); i++){
            if(sheet.getChildren().get(i) instanceof VariableAssignment){
                variableValues.getFirst().put(((VariableAssignment) sheet.getChildren().get(i)).name.name, ((VariableAssignment) sheet.getChildren().get(i)).expression);
                toRemove.add(sheet.getChildren().get(i));
            }

            if (sheet.getChildren().get(i) instanceof Stylerule){
                transformStyleRule((Stylerule) sheet.getChildren().get(i));
            }
        }

        for (int i = 0; i < toRemove.size(); i++){
            sheet.removeChild(toRemove.get(i));
        }

        variableValues.removeFirst();
    }

    private void transformStyleRule (Stylerule rule){
        ArrayList<ASTNode> transformedNodes = new ArrayList<>();
        variableValues.addFirst(new HashMap<>());

        for (int i = 0; i < rule.getChildren().size(); i++){
            if (rule.getChildren().get(i) instanceof Declaration){
                transformedNodes.add(transformDeclaration((Declaration) rule.getChildren().get(i)));
            }
        }

        rule.body = transformedNodes;
        variableValues.removeFirst();
    }

    private Declaration transformDeclaration (Declaration declaration){
        Expression expression = transformExpression(declaration.expression);
        declaration.expression = expression;

        return declaration;
    }

    private Literal transformExpression(Expression expression){
        if (expression instanceof Operation){
            return transformOperation((Operation) expression);
        }

        if (expression instanceof VariableReference){
            return transformVarReference((VariableReference) expression);
        }

        if (expression instanceof Literal){
            return (Literal) expression;
        }

        return null;
    }

    private Literal transformOperation(Operation operation){
        Expression left = operation.lhs;
        Expression right = operation.rhs;

        int leftValue = 0;
        int rightValue = 0;

        if (left instanceof Operation){
            left = transformOperation((Operation) left);
        } else if (left instanceof VariableReference){
            left = transformVarReference((VariableReference) left);
        }

        if (left instanceof PixelLiteral){
            leftValue = ((PixelLiteral) left).value;
        } else if (left instanceof PercentageLiteral){
            leftValue = ((PercentageLiteral) left).value;
        } else if (left instanceof ScalarLiteral){
            leftValue = ((ScalarLiteral) left).value;
        }

        if (right instanceof Operation){
            right = transformOperation((Operation) right);
        } else if (right instanceof VariableReference){
            right = transformVarReference((VariableReference) right);
        }

        if (right instanceof PixelLiteral){
            rightValue = ((PixelLiteral) right).value;
        } else if (right instanceof PercentageLiteral){
            rightValue = ((PercentageLiteral) right).value;
        } else if (right instanceof ScalarLiteral){
            rightValue = ((ScalarLiteral) right).value;
        }

        if (operation instanceof AddOperation){
            return operation((Literal) left, leftValue + rightValue);
        } else if (operation instanceof DivideOperation){
            return operation((Literal) left, leftValue / rightValue);
        } else if (operation instanceof MultiplyOperation){
            return operation((Literal) left, leftValue * rightValue);
        } else if (operation instanceof SubtractOperation){
            return operation((Literal) left, leftValue - rightValue);
        } else {
            return null;
        }
    }

    private Literal operation (Literal literal, int value){
        if (literal instanceof PercentageLiteral){
            return new PixelLiteral(value);
        } else if (literal instanceof PixelLiteral){
            return new PixelLiteral(value);
        } else if (literal instanceof ScalarLiteral){
            return new ScalarLiteral(value);
        } else {
            return null;
        }
    }

    private Literal transformVarReference (VariableReference reference){
        for (int i = 0; i < variableValues.getSize(); i++){
            if (variableValues.get(i).get(reference.name) != null){
                return transformExpression(variableValues.get(i).get(reference.name));
            }
        }

        return null;
    }
}
