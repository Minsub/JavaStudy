package com.minsub.java.laddergame;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("111");
        new Line(5, () -> true);
        IntStream.rangeClosed(6, 10).forEach(i -> System.out.println(i));
        IntStream.range(6, 10).forEach(i -> System.out.println(i));
    
        Random random = new Random();
        boolean isProb = random.nextInt(5) >= 3;
    }
    
    @Test
    public void print() {
        List<List<Boolean>> ladder = generatorLadder();
        ladder.forEach(line -> {
            System.out.print("  ");
            line.forEach(e -> {
                System.out.print("|" + (e ? "----" : "    "));
            });
            System.out.println("|  ");
        });
    
        System.out.println("doit. select: " + 0 + ", result: " + doit(ladder, 0));
        System.out.println("doit. select: " + 1 + ", result: " + doit(ladder, 1));
        System.out.println("doit. select: " + 2 + ", result: " + doit(ladder, 2));
        System.out.println("doit. select: " + 3 + ", result: " + doit(ladder, 3));
        System.out.println("doit. select: " + 4 + ", result: " + doit(ladder, 4));
    }
    
    private List<List<Boolean>> generatorLadder() {
        List<List<Boolean>> ladder = Lists.newArrayList();
        ladder.add(Lists.newArrayList(true, false, false, true));
        ladder.add(Lists.newArrayList(false, true, false, false));
        ladder.add(Lists.newArrayList(false, true, false, true));
        ladder.add(Lists.newArrayList(true, false, true, false));
        ladder.add(Lists.newArrayList(false, true, false, true));
        return ladder;
    }
    
    private int doit(List<List<Boolean>> ladder, int start) {
        int pos = start;
        for (List<Boolean> line: ladder) {
            pos = move(pos, line);
        }
        return pos;
    }
    
    private int move(int pos, List<Boolean> line) {
        if (pos < line.size() && line.get(pos)) {
            return pos + 1;
        } else if (pos > 0 && line.get(pos - 1)) {
            return pos - 1;
        }
        return pos;
    }
}
