package frontend;

import intermediate.IntermediateCode;
import intermediate.SymbolTableStack;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Parses a Scheme source file.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class SchemeParser
{

    private IntermediateCode interCode;
    private SchemeScanner scanner;
    private SymbolTableStack symbolTableStack;

    /**
     *
     * @param intCode     intermediate code to which to compile
     * @param source      Scheme source file from which to read
     * @param symbolStack a stack to store the Scheme program's symbol tables
     * @throws FileNotFoundException
     */
    public SchemeParser (IntermediateCode intCode, File source, SymbolTableStack symbolStack) throws FileNotFoundException
    {
        interCode = intCode;
        scanner = new SchemeScanner(source);
        symbolTableStack = symbolStack;

    }

    /**
     *
     * @param intCode     intermediate code to which to compile
     * @param source      Scheme source string from which to read
     * @param symbolStack a stack to store the Scheme program's symbol tables
     */
    public SchemeParser (IntermediateCode intCode, String source, SymbolTableStack symbolStack)
    {
        interCode = intCode;
        scanner = new SchemeScanner(source);
        symbolTableStack = symbolStack;
    }

    /**
     * Parses the Scheme source.
     */
    public void parse ()
    {
        Token currentToken = scanner.nextToken();
        Token.Type currentTokenType = currentToken.getType();
        String currentTokenName = currentToken.getName();

        while (!currentTokenType.equals(Token.Type.END_OF_INPUT))
        {
            boolean isNewScope = false;
            //if(currentTokenType == "SCOPE_KEYWORD"){}
            /*
             * Need to have a way to add a new symbolTable to the stack when a
             * scope keyword is seen
             * the next token after a scope Keyword and all tokens thereafter up
             * the end of the program or the next scope keyword is
             * to be added to the symboltable at that level
             *
             * NEED TO ADD A RECORD OF THE SYMBOLTABLE REFERENCE TO THE ROOT
             * NODE OF THE TREE THAT IT WILL POINT TO
             * AND A RECORD OF THE ROOT NODE TO THE SYMBOLTABLE
             * (REFERENCE APRIL 7 LECTURE LAST SLIDE)
             */
            if (currentTokenName.equalsIgnoreCase("DEFINE")
                    || currentTokenName.equalsIgnoreCase("LAMBDA")
                    || currentTokenName.equalsIgnoreCase("LET")
                    || currentTokenName.equalsIgnoreCase("LETREC")
                    || currentTokenName.equalsIgnoreCase("LET*"))
            {
                isNewScope = true;
            }

            if (currentTokenName.equals("("))
            {
                symbolTableStack.startList();
            }
            else if (currentTokenName.equals(")"))
            {
                symbolTableStack.endList();
            }
            else if (!(currentTokenType.equals(Token.Type.ERROR) || currentTokenType.equals(Token.Type.SPECIAL_SYMBOL)))
            {
                symbolTableStack.addToken(currentToken);
                if (currentTokenType.equals(Token.Type.IDENTIFIER))
                {

                    symbolTableStack.addToTopLevelsymbolTable(currentTokenName, currentTokenType);
                }

            }
            currentToken = scanner.nextToken();
            currentTokenType = currentToken.getType();
            currentTokenName = currentToken.getName();
        }
    }

    /**
     * For more then 1 procedure in a file check that the closing Parentheses
     * are equal to the opening Parentheses
     *
     * @param leftPeren
     * @param rightPeren
     * @return
     */
    private boolean check_End_Of_Procedure (int leftPeren, int rightPeren)
    {
        return leftPeren == rightPeren;
    }
}
