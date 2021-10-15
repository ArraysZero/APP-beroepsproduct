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

    private IHANLinkedList<HashMap<String, Literal>> variableValues;

    public Evaluator() {
        variableValues = new HANLinkedList<>();
    }

    @Override
    public void apply(AST ast) {
        variableValues = new HANLinkedList<>();

        transformNode(ast.root);
    }

    private void transformNode (ASTNode node){

        if (node instanceof VariableAssignment){
            Expression expression = ((VariableAssignment) node).expression;
            expression = transformExpression(expression);
            variableValues.getFirst().put(((VariableAssignment) node).name.name, (Literal) expression);
        }

        if (node instanceof Expression){
            transformExpression((Expression) node);
        }

        if (node instanceof IfClause){
            transformIfClause((IfClause) node);
        }

        if(node.getChildren().size() > 0){
            variableValues.addFirst(new HashMap<>());
            for (int i = 0; i < node.getChildren().size(); i++){
                transformNode(node.getChildren().get(i));
            }
            variableValues.removeFirst();
        }
    }

    private Literal transformExpression (Expression expression){
        if (expression instanceof Operation){
            return transformOperation((Operation) expression);
        }

        if (expression instanceof VariableReference){
            return transformVarReference((VariableReference) expression);
        }

        return (Literal) expression;
    }

    private Literal transformOperation (Operation operation){
        Literal left, right;

        left = transformExpression(operation.lhs);
        right = transformExpression(operation.rhs);

        Literal touse;

        if (left instanceof ScalarLiteral){
            touse = right;
        } else {
            touse = left;
        }


        if (operation instanceof AddOperation){
            return newLiteral(touse, getLiteralValue(left) + getLiteralValue(right));
        } else if (operation instanceof DivideOperation){
            return newLiteral(touse, getLiteralValue(left) / getLiteralValue(right));
        } else if (operation instanceof MultiplyOperation){
            return newLiteral(touse, getLiteralValue(left) * getLiteralValue(right));
        } else if (operation instanceof SubtractOperation){
            return newLiteral(touse, getLiteralValue(left) - getLiteralValue(right));
        }

        return null;
    }

    private Literal newLiteral(Literal literal, int value) {
        if (literal instanceof PixelLiteral) {
            return new PixelLiteral(value);
        } else if (literal instanceof ScalarLiteral) {
            return new ScalarLiteral(value);
        } else if (literal instanceof PercentageLiteral) {
            return new PercentageLiteral(value);
        }

        return null;
    }

    private int getLiteralValue(Literal literal){
        if (literal instanceof PixelLiteral) {
            return ((PixelLiteral) literal).value;
        } else if (literal instanceof ScalarLiteral) {
            return ((ScalarLiteral) literal).value;
        } else if (literal instanceof PercentageLiteral) {
            return ((PercentageLiteral) literal).value;
        }

        return 0;
    }

    private Literal transformVarReference(VariableReference reference){
        for (int i = 0; i < variableValues.getSize(); i++){
            if (variableValues.get(i).get(reference.name) != null){
                return variableValues.get(i).get(reference.name);
            }
        }

        return null;
    }

    private void transformIfClause (IfClause clause){
        BoolLiteral bool = (BoolLiteral) transformExpression(clause.conditionalExpression);

        if (bool.value){ //if true
            if (clause.elseClause != null){
                clause.elseClause.body = new ArrayList<>();
            }
            clause.elseClause = null;
        } else {
            if (clause.elseClause != null){
                clause.body = clause.elseClause.body;
                clause.elseClause.body = new ArrayList<>();
            } else {
                clause.body = new ArrayList<>();
                return;
            }
        }

        for (int i = 0; i < clause.body.size(); i++){
            transformNode(clause.body.get(i));
        }
    }
}
