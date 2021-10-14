package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.ColorLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;



public class Checker {

    private IHANLinkedList<HashMap<String, ExpressionType>> variableTypes;

    public void check(AST ast) {
         variableTypes = new HANLinkedList<>();


    }

    //TODO: check scope -> VariableExistence

    //TODO: check juiste waarde toegekend aan property -> CheckTypes
    private void checkDeclaration(Declaration declaration){
        switch (declaration.property.name){
            case "color":
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

    //TODO: als conditie is boolean -> CheckCondition

}
