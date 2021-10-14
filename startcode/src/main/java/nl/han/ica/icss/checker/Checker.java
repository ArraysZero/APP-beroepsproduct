package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.DivideOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.types.ExpressionType;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Checker {

    private IHANLinkedList<HashMap<String, Expression>> variableTypes = new HANLinkedList<>();

    public void check(AST ast) {
        checkNode(ast.root, 0);
    }

    private void checkNode(ASTNode node, int depth){
        //System.out.println("check node");
        if(node instanceof Declaration){
            //System.out.println("declaration");
            checkDeclaration((Declaration) node);
        } else if (node instanceof Operation){
            //System.out.println("operation");
            checkOperation((Operation) node);
        } else if (node instanceof IfClause){
            //System.out.println("if clause");
            checkIfClause((IfClause) node);
        } else if (node instanceof VariableAssignment){
            variableTypes.getFirst().put(((VariableAssignment) node).name.name, ((VariableAssignment) node).expression);
        } else if (node instanceof VariableReference){
            checkScope((VariableReference) node);
        }

        if(node.getChildren().size() > 0){
            variableTypes.addFirst(new HashMap<>());
            depth++;
            for (int i = 0; i < node.getChildren().size(); i++){
                checkNode(node.getChildren().get(i), depth);
            }

            variableTypes.removeFirst();
        }
    }



    //TODO: check scope -> VariableExistence
    private void checkScope(VariableReference reference){
        boolean exists = false;

        for (int i = 0; i < variableTypes.getSize(); i++){
            if (variableTypes.get(i).get(reference.name) != null){
                exists = true;
            }
        }

        if (!exists){
            reference.setError("variable out of scope");
        }
    }

    private void checkDeclaration(Declaration declaration){
        if (declaration.expression instanceof VariableReference || declaration.expression instanceof Operation){
            return;
        }

        switch (declaration.property.name){
            case "color":
                System.out.println("check de color");
                if(!(declaration.expression instanceof ColorLiteral)){
                    declaration.setError("color value can only be color literal");
                }
                break;
            case "background-color":
                if(!(declaration.expression instanceof ColorLiteral)){
                    declaration.setError("background-color value can only be color literal");
                }
                break;
            case "width":
                if (!(declaration.expression instanceof PixelLiteral || declaration.expression instanceof PercentageLiteral)){
                    declaration.setError("width must have pixel or percentagevalue");
                }
                break;
            case "height":
                if (!(declaration.expression instanceof PixelLiteral || declaration.expression instanceof PercentageLiteral)){
                    declaration.setError("height must have pixel or percentagevalue");
                }
                break;
            default:
                declaration.setError("unknown property name");
                break;
        }


    }

    //TODO: rekenen met cijfers -> CheckOperation
    private void checkOperation(Operation operation){
        Expression left = operation.lhs;
        Expression right = operation.rhs;

        if (left instanceof Operation){
            checkOperation((Operation) left);
        }
        if (right instanceof Operation){
            checkOperation((Operation) right);
        }

        if (left instanceof ColorLiteral || left instanceof BoolLiteral || right instanceof ColorLiteral || right instanceof BoolLiteral){
            operation.setError("boolean and color literals are not allowed in operations");
        }

        if (operation instanceof DivideOperation || operation instanceof MultiplyOperation){
            if (left instanceof ScalarLiteral || right instanceof ScalarLiteral){
                operation.setError("multiplacation and division cant be dont with scalar literal");
            }
        }
    }

    //TODO: als conditie is boolean -> CheckCondition
    private void checkIfClause(IfClause clause){
        if (!(clause.conditionalExpression instanceof BoolLiteral || clause.conditionalExpression instanceof VariableReference)){
            clause.setError("conditional expression is not boolean");
        }
    }

}
