package implementacion;

import java.util.HashMap;
import java.util.Map;

public class FabricaPrototype {
    private static Map<String,InterfacePrototype> prototypes = new HashMap<String, InterfacePrototype>();

    public static InterfacePrototype getPrototype(String prototypeName){
        return prototypes.get(prototypeName).deepClone();
    }

    public static void addPrototype(String prototypeName,InterfacePrototype prototype){
        prototypes.put(prototypeName, prototype);
    }
}
