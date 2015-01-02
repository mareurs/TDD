package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    private Utils() {
    }

    public static List<Object> list(Object... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

}
