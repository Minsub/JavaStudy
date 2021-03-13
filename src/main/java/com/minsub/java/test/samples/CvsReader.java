package com.minsub.java.test.samples;

import org.junit.Test;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/*


*/
public class CvsReader {
    
    @Test
    public void run() {
        List<List<String>> data = getData();
        Map<String, Integer> result = new HashMap<>();
        data.stream()
                .flatMap(d -> Arrays.stream(d.get(1).split(":")))
                .forEach(h -> result.merge(h, 1, (a, b) -> a+b));
        result.keySet().forEach(key -> {
            System.out.println("key: " + key + ", v: " + result.get(key));
        });
    }

    @Test
    public void run2() {
        List<List<String>> data = getData();
        int sum = data.stream()
                .map(d -> countingWord(d.get(2), "좋아"))
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum: " + sum);
    }

    public int countingWord(String source, String keyword) {
        int idx = source.indexOf(keyword);
        if (idx == -1) {
            return 0;
        } else {
            return 1 + countingWord(source.substring(idx + keyword.length()), keyword);
        }
    }

    public List<List<String>> getData() {
        List<String> list = new ArrayList<>();
        list.add("김프로, 축구:농구:야구, 구기종목 좋아요");
        list.add("정프로, 개발:당구:족구, 개발하는데 뛰긴 싫어");
        list.add("앙몬드, 피아노, 죠르디가 좋아요 좋아좋아너무좋아");
        list.add("죠르디, 스포츠댄스:개발, 개발하는 죠르디");
        return list.stream().map(data -> Arrays.asList(data.split(", "))).collect(Collectors.toList());
    }
}
