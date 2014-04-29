package backend;

import java.util.HashMap;

/**
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class RuntimeActivationRecord
{
    HashMap<String, String> localMemory;

    public RuntimeActivationRecord()
    {
        localMemory = new HashMap<>();
    }
}
