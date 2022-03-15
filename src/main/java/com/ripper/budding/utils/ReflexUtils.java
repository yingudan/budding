package com.ripper.budding.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2022-01-12
 * @Description:com.ripper.budding.utils
 * @Version:1.0
 **/
public class ReflexUtils {


    public static final String serialVersionUID = "serialVersionUID";

    private ReflexUtils() {
        throw new IllegalStateException("ReflexUtils class");
    }

    /**
     * @depiction
     * @author：Yingd [RipperF@hotmail.com]
     * @date:2022-01-12
     */
    public static List<String> getObjectFields(Object var) {
        List<String> result = new ArrayList<>(16);
        Class<?> varClass = var.getClass();
        Field[] declaredFields = varClass.getDeclaredFields();
        List<Field> fields = Arrays.asList(declaredFields);
        fields.forEach(field -> {
            if (serialVersionUID.equals(field.getName())) {
                return;
            }
            try {
                field.setAccessible(true);
                Object obj = field.get(var);
                if (obj != null) {
                    result.add(String.valueOf(obj));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return result;
    }


}
