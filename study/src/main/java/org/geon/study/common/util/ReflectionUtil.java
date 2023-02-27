package org.geon.study.common.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {

    public static Method getInstanceToMethod(Class classObject, String instanceName) throws NoSuchMethodException {
        return classObject.getDeclaredMethod(instanceName);
    }

    public static Class<?> getClassByName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

    public static Object invokeGetter(Class classObject, Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        // IllegalAccessException 예외는 메서드나 필드에 접근 권한이 없을 때 발생하므로,
        // 메서드가 public일 경우 발생하지 않는다.
        // 따라서 invokeGetter() 메서드에서는 IllegalAccessException 예외를 던질 필요가 없다.
        Object instance = classObject.getDeclaredConstructor().newInstance();
        return method.invoke(instance);
    }

    public static Object invokeMethod(String className, String methodName) {
        try {
            Class cls = Class.forName(className);
            return cls.getDeclaredMethod(methodName);
//            Method[] methods = cls.getMethods();
//
//            for (Method method : methods) {
//                if (method.getName().equals(methodName)) {
//                    Object obj = cls.getDeclaredConstructor().newInstance();
//                    return method.invoke(obj);
//                }
//            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
