package backend;

import java.util.HashMap;

/**
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class RuntimeActivationRecord {

    private RuntimeActivationRecord previousRecord;
    private HashMap<Object, Object> localMemory;

    public RuntimeActivationRecord() {
        localMemory = new HashMap<>();
        previousRecord = null;
    }

    /**
     * Adds the variable to local memory.
     *
     * @param key the variable name
     * @param value the value of the variable
     * @return the previous value, if applicable
     */
    public Object addVariable(Object key, Object value) {
        return localMemory.put(key, value);
    }

    /**
     * Removes the variable from local memory.
     *
     * @param key the variable name
     * @return the value of the removed variable
     */
    public Object removeVariable(Object key) {
        return localMemory.remove(key);
    }

    public void setPreviousActivationRecord (RuntimeActivationRecord record)
    {
        this.previousRecord = record;
    }

    public RuntimeActivationRecord getPreviousRunTimeActivationRecord()
    {
        return this.previousRecord;
    }
}
