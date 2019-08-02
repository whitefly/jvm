package 内存溢出;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class C2_4_4DirectMemoryOverFlow {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
