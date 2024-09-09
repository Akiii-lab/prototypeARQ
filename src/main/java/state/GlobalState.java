package state;

import java.util.HashMap;

public class GlobalState {
    public static HashMap<String, String> state = new HashMap<>();

    public static void setState(String key, String value) {
        state.put(key, value);
    }

    public static String getState(String key) {
        return state.get(key);
    }
}
