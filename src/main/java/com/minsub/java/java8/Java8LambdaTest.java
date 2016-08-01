package com.minsub.java.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 *
 * Created by Minsub Ji on 2016-08-01.
 */
public class Java8LambdaTest {

    private List<Dish> list =null;
    private List<HashMap<String,Object>> listHash = null;

    @Before
    public void setUp() throws Exception {
        list = Arrays.asList(new Dish("Apple", 100, true)
                ,new Dish("Banana", 200, true)
                ,new Dish("Canopy", 50, false)
                ,new Dish("Dalgona", 400, false)
                ,new Dish("Element", 10, false)
                ,new Dish("Folk", 200, true)
                ,new Dish("Banana", 300, true)
                ,new Dish("Banana", 400, true)
                ,new Dish("Grape", 30, true));

        listHash = Arrays.asList(create("key", "111111")
                , create("key", "222222")
                , create("key", "333333")
                , create("key", "444444")
                , create("key", "555555"));
    }

    /**
     * JAVA8에서 함수형 언어처럼 METHOD를 REF값으로 사용할 수 있다.
     * :: 문법을 사용한다.
     */
    @Test
    public void testMethodRef() {
        System.out.println("START testMethodRef()");

        // MEthod Ref를 사용.
        // Class:: Static method (Class::New 도 됨)

        Collections.sort(list,  Java8LambdaTest::customCompare);
        System.out.println("1st Sort by ASC (use method reference)");
        System.out.println(list);

        // Object::Instance Method
        Java8LambdaTest test = new Java8LambdaTest();
        Collections.sort(list,  test::customCompare2);
        System.out.println("2nd Sort by DESC (use method reference)");
        System.out.println(list);
    }

    public static int customCompare(Dish o1, Dish o2) {
        return o1.getName().compareTo(o2.getName());
    }
    public int customCompare2(Dish o1, Dish o2) {
        return o2.getName().compareTo(o1.getName());
    }

    @Test
    public void testLambda1() {
        System.out.println("START testLambda1()");

        // Lambda를 사용하지 않는 comparator를 사용한 sort
        Collections.sort(list, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("1st sort by ASC (not use lambda)");
        System.out.println(list);

        // Lambda를 사용한 Sort
        Collections.sort(list, (o1, o2) -> o2.getName().compareTo(o1.getName()));
        System.out.println("2nd sort by DESC (use lambda)");
        System.out.println(list);
    }

    private HashMap<String, Object> create(String key, Object value) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(key, value);
        return map;
    }

    @Data
    @AllArgsConstructor
    static class Dish {
        private String name;
        private int calories;
        private boolean isPass;

        @Override
        public String toString() {
            return this.name  + ", " + this.calories + ", " + isPass;
        }
    }
}
