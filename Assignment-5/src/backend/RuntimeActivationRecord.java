/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.HashMap;

/**
 *
 * @author BrandonRossi
 */
public class RuntimeActivationRecord
{
    HashMap<String, String> localMemory;

    public RuntimeActivationRecord()
    {
        localMemory = new HashMap<>();
    }
}
