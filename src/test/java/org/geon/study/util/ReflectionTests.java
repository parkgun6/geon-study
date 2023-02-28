package org.geon.study.util;

import org.geon.study.board.model.Board;
import org.geon.study.common.util.ReflectionUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTests {

    ReflectionUtil reflectionUtil = new ReflectionUtil();

    @Test
    public void getMethods() throws Exception {
        Class cls = Class.forName("org.geon.study.board.model.Board");

        Method[] declaredMethodsList = cls.getClass().getDeclaredMethods();
        Method[] publicMethodsList = cls.getMethods();

        int dmCount = cls.getDeclaredMethods().length;
        int pmCount = cls.getMethods().length;

        System.out.println(dmCount);
        System.out.println(pmCount);

        for (Method method : publicMethodsList) {
            System.out.println(method.getName());
        }
    }

    @Test
    public void getMethodTest2() {
        System.out.println(reflectionUtil.invokeMethod("model.Board","getBno"));
    }

    @Test
    public void invokeGetterTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class classObject = reflectionUtil.getClassByName("model.Board");
        System.out.println(classObject);

        Method methodObject = reflectionUtil.getInstanceToMethod(classObject, "getBno");
        System.out.println(methodObject);

        Object instance = classObject.getDeclaredConstructor().newInstance();
        System.out.println(instance);

        Object invokeGetter = methodObject.invoke(instance);
        System.out.println(invokeGetter);

//        Object invokeGetter2 = methodObject.invoke(board);
//        System.out.println(invokeGetter2);
    }

    @Test
    public void returnTypeCheckTest() throws ClassNotFoundException, NoSuchMethodException {
        Class getClass = reflectionUtil.getClassByName("model.Board");

        Method getBnoMethod = reflectionUtil.getInstanceToMethod(getClass, "getBno");

        String returnType = getBnoMethod.getReturnType().toString();

        System.out.println(returnType.equals("class java.lang.Long"));

        Board board = new Board();

        Method getRoleMethod = reflectionUtil.getInstanceToMethod(getClass, "getRole");

        String returnType2 = getRoleMethod.getReturnType().toString();

        System.out.println(returnType2);
    }

    @Test
    public void setTest() {

    }
}
