/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.Stack;

/**
 * This is the runtime stack for the program
 * @author BrandonRossi
 */
public class RuntimeStack
{
    Stack<RuntimeActivationRecord> runTimeStack;

    public RuntimeStack()
    {
        runTimeStack = new Stack<>();
    }

    public RuntimeActivationRecord addActivationRecord(RuntimeActivationRecord record)
    {
        return runTimeStack.push(record);
    }
}
