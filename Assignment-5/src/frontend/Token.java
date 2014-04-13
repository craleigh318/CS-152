/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class Token {

    private String name;
    private Type type;

    public static enum Type {

        IDENTIFIER, KEYWORD, NUMBER, SPECIAL_SYMBOL, PROCEDURE, END_OF_INPUT, ERROR
    }

    public Token(String name, Token.Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
        //System.out.println("Token String " + this.name);
    }

    public Type getType() {
        return type;
        //System.out.println("Token Type " + this.type);
    }
}
