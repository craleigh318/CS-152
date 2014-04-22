/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intermediate;

import frontend.SymbolMapList;
import java.util.Stack;

/**
 *
 * @author BrandonRossi
 */
public class SymbolTableStack
{
    private Stack<SymbolTable> symbolTableStack;
    public SymbolTableStack()
    {
        symbolTableStack = new Stack<>();
        SymbolTable globalTable = new SymbolTable();
        globalTable.addAllEmelents(SymbolMapList.setUpKeywordMap());
        globalTable.addAllEmelents(SymbolMapList.setUpProcedureSymbolMap());
        globalTable.addAllEmelents(SymbolMapList.setUpSpecialSymbolMap());
        symbolTableStack.push(globalTable);
    }
}