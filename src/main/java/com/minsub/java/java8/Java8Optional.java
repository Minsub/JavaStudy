package com.minsub.java.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class Java8Optional {
    private EmptyClass nullableObject;
    private EmptyClass nullableInner;
    private EmptyClass fullObject;
   
    @Before
    public void setUp() throws Exception {
        nullableObject = null;
        nullableInner = new EmptyClass();
        nullableInner.inner = null;
        fullObject = new EmptyClass();
        fullObject.inner = new EmptyClass();
        fullObject.inner.name = "fullClass.inner.name='TEST1'";
    }

    @Test
    public void test1() throws Exception {
        System.out.println("nullableObject: " + isNull(nullableObject));
        System.out.println("nullableInner: " + isNull(nullableInner));
        System.out.println("fullObject: " + isNull(fullObject));
    
    
        Optional<String> opt = Optional.ofNullable(nullableInner).filter(o -> o.inner != null).map(o -> o.inner.name);
    
        System.out.println(opt.orElse("empty"));
    }
    
    private boolean isNull(EmptyClass obj) {
//        return Optional.ofNullable(obj).map(o -> o.inner).map(o -> o.name).isPresent();
        return Optional.ofNullable(obj).filter(o -> o.inner != null).map(o -> o.inner.name).isPresent();
    }
    
    public static class EmptyClass {
        public EmptyClass inner;
        public String name;
    }
}
