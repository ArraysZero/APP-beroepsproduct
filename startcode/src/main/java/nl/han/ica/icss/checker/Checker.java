package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;

import java.util.HashMap;


public class Checker {

    private IHANLinkedList<HashMap<String, Expression>> variableTypes = new HANLinkedList<>();

    public void check(AST ast) {
        checkNode(ast.root);
    }

    private void checkNode(ASTNode node){
        if(node instanceof Declaration){
            checkDeclaration((Declaration) node);
        } else if (node instanceof Operation){
            checkOperation((Operation) node);
        } else if (node instanceof IfClause){
            checkIfClause((IfClause) node);
        } else if (node instanceof VariableAssignment){
            variableTypes.getFirst().put(((VariableAssignment) node).name.name, ((VariableAssignment) node).expression);
        } else if (node instanceof VariableReference){
            checkScope((VariableReference) node);
        }

        if(node.getChildren().size() > 0){
            variableTypes.addFirst(new HashMap<>());
            for (int i = 0; i < node.getChildren().size(); i++){
                checkNode(node.getChildren().get(i));
            }

            variableTypes.removeFirst();
        }
    }

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

    private Literal checkVarType(VariableReference reference){
        Expression expression = null;

        for (int i = 0; i < variableTypes.getSize(); i++){
            if (variableTypes.get(i).get(reference.name) != null){
                expression = variableTypes.get(i).get(reference.name);
            }
        }

        if (expression instanceof Literal){
            return (Literal) expression;
        } else if (expression instanceof Operation){
            if (((Operation) expression).lhs instanceof Literal){
                return (Literal) ((Operation) expression).lhs;
            } else if (((Operation) expression).rhs instanceof Literal){
                return (Literal) ((Operation) expression).rhs;
            }
        }

        return null;
    }

    private void checkDeclaration(Declaration declaration){
        Expression value;
        if (declaration.expression instanceof VariableReference){
            value = checkVarType((VariableReference) declaration.expression);
        } else {
            value = declaration.expression;
        }

        switch (declaration.property.name){
            case "color":
                if(!(value instanceof ColorLiteral)){
                    declaration.setError("color value can only be color literal");
                }
                break;
            case "background-color":
                if(!(value instanceof ColorLiteral)){
                    declaration.setError("background-color value can only be color literal");
                }
                break;
            case "width":
                //operation is also allowed because thats what u get from an operation
                if (!(value instanceof PixelLiteral || value instanceof PercentageLiteral || value instanceof Operation)){
                    declaration.setError("width must have pixel or percentagevalue");
                }
                break;
            case "height":
                //operation is also allowed because thats what u get from an operation
                if (!(value instanceof PixelLiteral || value instanceof PercentageLiteral || value instanceof Operation)){
                    declaration.setError("height must have pixel or percentagevalue");
                }
                break;
            default:
                declaration.setError("unknown property name");
                break;
        }


    }

    private Literal checkOperation(Operation operation){
        Expression left = operation.lhs;
        Expression right = operation.rhs;

        if (left instanceof VariableReference){
            Literal value = checkVarType((VariableReference) left);
        }

        if (right instanceof VariableReference){
            Literal value = checkVarType((VariableReference) right);
        }

        if (left instanceof BoolLiteral || right instanceof BoolLiteral){
            operation.setError("operation cant contain boolean");
        } else if (left instanceof ColorLiteral || right instanceof ColorLiteral){
            operation.setError("operation cant contain color");
        } else {
            if (left instanceof Operation){
                left = checkOperation((Operation) left);
            }

            if (right instanceof Operation) {
                right = checkOperation((Operation) left);
            }
        }

        if (left instanceof PixelLiteral || left instanceof PercentageLiteral){
            return (Literal) left;
        } else {
            return (Literal) right;
        }
    }

    private void checkIfClause(IfClause clause){
        if (!(clause.conditionalExpression instanceof BoolLiteral || clause.conditionalExpression instanceof VariableReference)){
            clause.setError("conditional expression is not boolean");
        }
    }

}
