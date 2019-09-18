package com.spring.base.util;

import java.lang.reflect.Field;
import java.sql.Timestamp;

/**
 * 反射工具类,获取到sql语句属性名和属性值,包括子类和继承的BaseEntiry父类
 */
public class ReflectionUtils {

    //封装当前类和父类的所有属性,拼接属性sql
    public static String fatherAndSonField(Object obj) {
        if (obj == null) {
            return null;
        }
        //获取class文件
        Class classInfo = obj.getClass();
        //获取当前类的属性sql
        Field[] sonFields = classInfo.getDeclaredFields();
        String s1 = getField(sonFields);
        Field[] fatherFields = classInfo.getSuperclass().getDeclaredFields();
        String s2 = getField(fatherFields);
        return s1 + "," + s2;
    }

    //获取当前类和父类的属性值
    public static String fatherAndSonFieldValue(Object obj) {
        if (obj == null) {
            return null;
        }
        //获取class文件
        Class classInfo = obj.getClass();
        //获取当前类的属性sql
        Field[] sonFields = classInfo.getDeclaredFields();
        String s1 = getFieldValue(obj, sonFields);
        Field[] fatherFields = classInfo.getSuperclass().getDeclaredFields();
        String s2 = getFieldValue(obj, fatherFields);
        return s1 + "," + s2;
    }

	//反射获取属性名
    public static String getField(Field[] declaredFields) {
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < declaredFields.length; ++i) {
            sf.append(declaredFields[i].getName());
            if (i < declaredFields.length - 1) {
                sf.append(",");
            }
        }
        return sf.toString();
    }

	//反射获取属性值
    public static String getFieldValue(Object obj, Field[] declaredFields) {
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < declaredFields.length; ++i) {
            //获取属性值
            try {
                //运行操作私有属性
                declaredFields[i].setAccessible(true);

                Field field = declaredFields[i];
                Object value = field.get(obj);

                //标识类型是否为String类型
                boolean flag = false;
                if (value != null && (value instanceof String||value instanceof Timestamp)) {
                    flag = true;
                }
                if (flag) {
                    sf.append("'" + value + "'");
                } else {
                    sf.append(value);
                }
                if (i < declaredFields.length - 1) {
                    sf.append(",");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sf.toString();
    }
}
