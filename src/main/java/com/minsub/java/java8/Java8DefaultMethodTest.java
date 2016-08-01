package com.minsub.java.java8;

import org.junit.Test;

/**
 * Created by Minsub Ji on 2016-08-01.
 */
public class Java8DefaultMethodTest {

    @Test
    public void testDefaultMethod() {
        Class1 c1 = new Class1();
        c1.method1();
        c1.method2();

        Class2 c2 = new Class2();
        c2.method1();
        c2.method2();

        ClassMultipleImpl c3 = new ClassMultipleImpl();
        c3.method2();
    }
}


// Default Method는 Interface에서 구현체로 선언이 가능하다.
interface Inter1 {
    public void method1();
    default public void method2() {
        System.out.println("Inter1.method2()");
    }
}

// Default method는 implements한 class에서 override하지 않아도 된다.
class Class1 implements  Inter1{
    @Override
    public void method1() {
        System.out.println("Class1.method1()");
    }
}

// Default method를 override한 경우 우선순위는 override한 method를 우선한다.
class Class2 implements  Inter1{
    @Override
    public void method1() {
        System.out.println("Class2.method1()");
    }
    @Override
    public void method2() {
        System.out.println("Class2.method2()");
    }
}


interface Inter2 {
    default public void method2() {
        System.out.println("Inter2.method2()");
    }
}

// 동일한 Default Method를 interface를 상속받을 경우 무조건 overide해야함.
// 그래고 다중상속의 구별을 위해 Interface명을 사용할 수 있음
class ClassMultipleImpl implements Inter1, Inter2{
    @Override
    public void method1() {
        System.out.println("Class2.method1()");
    }

    @Override
    public void method2() {
        Inter1.super.method2();
        Inter2.super.method2();
    }
}