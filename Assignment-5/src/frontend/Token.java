package frontend;

import intermediate.SchemeList;
import intermediate.SchemeListItem;

/**
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class Token implements SchemeListItem {

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
