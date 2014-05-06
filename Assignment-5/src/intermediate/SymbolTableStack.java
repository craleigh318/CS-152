/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import frontend.SymbolMapList;
import frontend.Token;
import java.util.Stack;

/**
 *
 * @author BrandonRossi
 */
public class SymbolTableStack
{

    private Stack<SymbolTable> symbolTableStack;
    private Stack<SchemeListForSymbolTableStack> schemeListStack;

    class SchemeListForSymbolTableStack
    {

        SchemeList list;
        boolean newScope;

        public SchemeListForSymbolTableStack (SchemeList list, boolean newScope)
        {
            this.list = list;
            this.newScope = newScope;
        }
    }

    public SymbolTableStack ()
    {
        symbolTableStack = new Stack<>();
        schemeListStack = new Stack<>();
        SymbolTable globalTable = new SymbolTable();
        globalTable.addAllEmelents(SymbolMapList.setUpKeywordMap());
        globalTable.addAllEmelents(SymbolMapList.setUpProcedureSymbolMap());
        globalTable.addAllEmelents(SymbolMapList.setUpSpecialSymbolMap());
        symbolTableStack.push(globalTable);
    }

    /**
     * Adds a token to the current innermost list.
     *
     * @param token the token to add
     */
    public void addToken (Token token)
    {
        schemeListStack.peek().list.add(token);
    }

    /**
     * Adds a Scheme list.
     */
    public void startList ()
    {
        startList(false);
    }

    /**
     * Adds a Scheme list.
     *
     * @param newScope whether to have the list be a scope
     */
    public void startList (boolean newScope)
    {
        if (newScope)
        {
            symbolTableStack.push(new SymbolTable(symbolTableStack.peek().getSymbolMap()));
        }
        schemeListStack.push(new SchemeListForSymbolTableStack(new SchemeList(symbolTableStack.peek()), newScope));
    }

    /**
     * Ends a Scheme list.
     *
     * @return the list that ended
     */
    public SchemeList endList ()
    {
        if (schemeListStack.size() > 1)
        {
            SchemeListForSymbolTableStack outerList = schemeListStack.pop();
            if (outerList.newScope)
            {
                symbolTableStack.pop();
            }
            return outerList.list;
        }
        else
        {
            return null;
        }
    }

    /**
     *
     * @return this object's stack of symbol tables
     */
    public Stack<SymbolTable> getSymbolTableStack ()
    {
        return symbolTableStack;
    }

    /**
     * Adds a token element to this object's topmost symbol table
     *
     * @param name the token name
     * @param type the token type
     * @return
     */
    public Object addToTopLevelsymbolTable (String name, Token.Type type)
    {
        return symbolTableStack.peek().addElement(name, type);
    }

    /**
     *
     * @return the entire "root" SchemeList of this symbol table stack
     */
    public SchemeList getRootSchemeList ()
    {
        return schemeListStack.get(0).list;
    }
}
