package state;

import java.util.HashMap;

public class GlobalState {
    public static HashMap<String, Object> state = new HashMap<>();

    public static void setState(String key, Object value) {
        state.put(key, value);
    }

    public static Object getState(String key) {
        return state.get(key);
    }
}
