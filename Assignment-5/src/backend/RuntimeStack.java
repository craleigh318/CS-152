package backend;

import java.util.Stack;

/**
 * This is the runtime stack for the program
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class RuntimeStack {

    Stack<RuntimeActivationRecord> runTimeStack;

    public RuntimeStack() {
        runTimeStack = new Stack<>();
    }

    public RuntimeActivationRecord addActivationRecord(RuntimeActivationRecord record) {
        return runTimeStack.push(record);
    }
}
