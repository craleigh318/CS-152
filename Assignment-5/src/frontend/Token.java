package frontend;

import intermediate.SchemeList;
import intermediate.SchemeListItem;

/**
 * Contains a Scheme token's name with its type.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class Token implements SchemeListItem {

    private String name;
    private Type type;

    /**
     * A list of the different types of token in Scheme.
     */
    public static enum Type {

        IDENTIFIER, KEYWORD, SCOPE_KEYWORD ,NUMBER, SPECIAL_SYMBOL, PROCEDURE, END_OF_INPUT, ERROR
    }

    /**
     *
     * @param name the name of the token
     * @param type the type of token
     */
    public Token(String name, Token.Type type) {
        this.name = name;
        this.type = type;
    }

    /**
     *
     * @return the token's name
     */
    public String getName() {
        return this.name;
        //System.out.println("Token String " + this.name);
    }

    /**
     *
     * @return the token's type
     */
    public Type getType() {
        return type;
        //System.out.println("Token Type " + this.type);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public SchemeListItem car() {
        return null;
    }

    @Override
    public SchemeList cdr() {
        return null;
    }
}
