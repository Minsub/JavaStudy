package com.minsub.java.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream은 스트림 생성, 중개 , 종단 으로 구성됨
 *
 *
 * Created by Minsub Ji on 2016-08-01.
 */
public class Java8StreamTest {
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

    @Test
    public void testTerminationStream() throws Exception {
        System.out.println("START testTerminationStream()-------------------------------");
        // forEach: 단순 for loop이다.

        // count
        long count = Stream.of(1,2,3,3,3,4,5).count();
        System.out.println("## count()");
        System.out.println(count);

        // max, min
        System.out.println("## max()");
        Optional<Integer> max =Stream.of(1,2,3,3,3,4,5).max((a, b) -> a > b ? 1 : -1);
        if (max.isPresent()) {
            System.out.println(max.get());
        }

        // match(): allMathch, anyMatch, noneMatch
        System.out.println("## match()");
        boolean isAnyMatched = Stream.of(1,2,3,3,3,4,5).anyMatch(s -> s > 3);
        boolean isAllMatched = Stream.of(1,2,3,3,3,4,5).allMatch(s -> s > 3);
        System.out.println("anyMatched: " + isAnyMatched);
        System.out.println("isAllMatched: " + isAllMatched);

        // sum, min, max, average: IntStream, LongStream, DoubleStream에만 존재
        System.out.println("## sum(), min(), max(), average()");
        System.out.println("sum(): " + IntStream.rangeClosed(1,5).sum());
        System.out.println("min(): " + IntStream.rangeClosed(1,5).min().getAsInt());
        System.out.println("max(): " + IntStream.rangeClosed(1,5).max().getAsInt());
        System.out.println("average(): " + IntStream.rangeClosed(1,5).average().getAsDouble());


        // Reduce()
        System.out.println("## Reduce");
        Optional<Integer> optInt = Stream.of(1,2,3,3,3,4,5).distinct().reduce((a,b) -> a + b);
        System.out.println("sum: " + optInt.get());

        // Collertors.toList()
        System.out.println("## Collertors.toList");
        System.out.println(Stream.of(1,2,3,3,3,4,5).collect(Collectors.toList()));

        // Collertors.toSet()
        System.out.println("## Collertors.toSet");
        System.out.println(Stream.of(1,2,3,3,3,4,5).collect(Collectors.toSet()));

        // Collertors.toMap()
        System.out.println("## Collertors.toMap");
        System.out.println(Stream.of(1,2,3,3,3,4,5).distinct().collect(Collectors.toMap(s -> s , s -> s * 2)));

        // Collertors.groupingBy()
        System.out.println("## Collertors.groupingBy()");
        Map<Integer, List<Dish>> result = list.stream().collect(Collectors.groupingBy(d -> d.getCalories()));
        for (Integer i: result.keySet() ) {
            System.out.println(i + ": " + result.get(i));
        }

        // Collertors.partitioningBy()
        System.out.println("## Collertors.partitioningBy()");
        Map<Boolean, List<Dish>> result2 = list.stream().collect(Collectors.partitioningBy(d -> d.isPass()));
        for (Boolean i: result2.keySet() ) {
            System.out.println(i + ": " + result2.get(i));
        }

    }

    @Test
    public void testTransportStream() throws Exception {
        System.out.println("START testTransportStream()-------------------------------");
        // Sorted()
        System.out.println("## sorted(), sorted(Comparator<T>)");
        list.stream().sorted((d1,d2) -> d1.getName().compareTo(d2.getName())).forEach(d -> System.out.print("["+d + "], "));

        // distinct()
        System.out.println("\n## distinct()");
        Stream.of(1,2,3,3,3,4,5).distinct().forEach(s -> System.out.print(s + ", "));

        //TODO: filter

        //TODO: map
        System.out.println("\n## map()");
        List<String> list = listHash.stream().map(map -> (String)map.get("key")).distinct().collect(Collectors.toList());
        System.out.println("List: " + list);

        //TODO: flatMap


        //TODO: mapToInt

    }

    @Test
    public void testCreateStream() throws Exception {
        System.out.println("START testCreateStream()-------------------------------");

        // Collection.stream()
        List<Integer> listInteger = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream1 = listInteger.stream();

        // Files.lines(Path)
        // (BufferedReader.Lines()도 됨)
        Stream<String> stream2 = null;
        Path path = Paths.get("C:/README.md");
        if (Files.exists(path)) {
            stream2 = Files.lines(path);
        }

        //Arrays.stream(arr)
        Integer[] arrInteger = (Integer[])Arrays.asList(1,2,3,4,5).toArray();
        Stream<Integer> stream3 = Arrays.stream(arrInteger);

        // Random.doubles, ints, longs
        DoubleStream stream4 = new Random().doubles(5);

        // Stream.of(), IntStream.range(), LongStream.rangeClosed(), Stream.generate(), Stream.iterate()
        Stream<String> stream5 = Stream.of("t1", "t2", "t3");
        IntStream stream6 = IntStream.rangeClosed(1,5);
        Stream<String> stream7 = Stream.generate( ()-> "test").limit(5);
        Stream<Integer> stream8 = Stream.iterate(0, n -> n + 1).limit(5);

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
