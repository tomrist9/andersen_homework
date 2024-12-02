package org.example.annotations;

import java.lang.reflect.Field;

public class NullChecker {
    public static void checkForNullWarnings(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NullableWarning.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(obj) == null) {
                        System.out.println("Variable [" + field.getName() + "] is null in [" + obj.getClass().getSimpleName() + "]!");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
