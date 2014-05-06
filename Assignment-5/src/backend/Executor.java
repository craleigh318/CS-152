package backend;

import frontend.Token;
import intermediate.IntermediateCode;
import intermediate.SchemeList;
import intermediate.SchemeListItem;
import intermediate.SymbolTable;

/**
 * Executes a Scheme program from its source code.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class Executor
{

    private IntermediateCode rootList;
    private SymbolTable symbolTable;
    private RuntimeDisplay runDisplay;

    public Executor (IntermediateCode list, SymbolTable symTable)
    {
        rootList = list;
        symbolTable = symTable;
        runDisplay = new RuntimeDisplay();
    }

    public void runInter ()
    {
        for (SchemeList s : rootList.getLists())
        {
            runInter(s, 1);
        }
    }

    private void runInter (SchemeList list, int scopeLevel)
    {
        try
        {
            SchemeListItem temp = list.car();
            if (temp instanceof Token)
            {
                Token temp2 = (Token) temp;
                SchemeListItem key = list.cdr().car();
                SchemeListItem value = list.cdr().cdr().car();
                if (temp2.getType().equals(Token.Type.SCOPE_KEYWORD))
                {
                    RuntimeActivationRecord actRec = new RuntimeActivationRecord();
                    actRec.addVariable(key, value);
                    runDisplay.addRecord(scopeLevel, actRec);
                }
            }
            else if (temp instanceof SchemeList)
            {
                SchemeList temp2 = (SchemeList) temp;
                runInter(temp2, scopeLevel +1);
            }
            SchemeList cdr = list.cdr();
            if (cdr != null) {
                runInter(cdr, scopeLevel +1);
            }
        }
        catch (ClassCastException e)
        {

        }

    }

}
