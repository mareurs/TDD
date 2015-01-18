package util;

import java.util.*;

public class Utils {

    private Utils() {
    }

    public static <T> List<T> list(T... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

}
