/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author BrandonRossi
 */
public class Token
{
    private String name;
    private String type;

    public enum Type
    {
        IDENTIFIER, KEYWORD, NUMBER, SPECIAL_SYMBOL, PROCEDURE, END_OF_INPUT, ERROR
    }

    public Token(String name, Token.Type type)
    {
        this.name = name;

        switch (type)
        {
            case IDENTIFIER:
                this.type = "IDENTIFIER";
                break;
            case KEYWORD:
                this.type = "KEYWORD";
                break;
            case NUMBER:
                this.type = "NUMBER";
                break;
            case SPECIAL_SYMBOL:
                this.type = "SPECIAL_SYMBOL";
                break;
            case PROCEDURE:
                this.type = "PROCEDURE";
                break;
            case END_OF_INPUT:
                this.type = "END_OF_INPUT";
                break;
            case ERROR:
                this.type = "ERROR";
                break;

        }

    }

    public String getName()
    {
        return this.name;
        //System.out.println("Token String " + this.name);
    }

    public String getType()
    {
        return this.type;
        //System.out.println("Token Type " + this.type);
    }
}
