package misc;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Hashes {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        HashMap<Integer, String> m = new HashMap<>();
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            m.put(i + 1, "");
        }
        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(m);
        System.out.println(table == null ? 0 : table.length);
        System.out.println((int)Short.MIN_VALUE * -2);

        int capacity = (int)Short.MAX_VALUE;
        for (int i = 0; i < capacity * 3 / 4; i++) {
            System.out.println(i + " into index: " + (hash(i) & (capacity - 1)));
        }
    }

    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
