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

    public void runInter() {
        runInter(1);
    }

    private void runInter (int scopeLevel)
    {
        try
        {
            for (SchemeList s : rootList.getLists())
            {
                SchemeListItem temp = s.car();
                Token temp2 = (Token) temp;
                SchemeListItem key = s.cdr().car();
                SchemeListItem value = s.cdr().cdr().car();
                if (temp2.getType().equals(Token.Type.SCOPE_KEYWORD))
                {
                    RuntimeActivationRecord actRec = new RuntimeActivationRecord();
                    actRec.addVariable(key, value);
                    runDisplay.addRecord(scopeLevel, actRec);
                }


            }
        }
        catch (ClassCastException e)
        {

        }

    }

}
