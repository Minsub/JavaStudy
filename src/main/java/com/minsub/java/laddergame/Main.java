package com.minsub.java.laddergame;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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
    public void testLadder() {
        List<List<Boolean>> ladder = generatorLadder(5, 5);
        print(ladder);
        System.out.println("doit. select: " + 0 + ", result: " + doit(ladder, 0));
        System.out.println("doit. select: " + 1 + ", result: " + doit(ladder, 1));
        System.out.println("doit. select: " + 2 + ", result: " + doit(ladder, 2));
        System.out.println("doit. select: " + 3 + ", result: " + doit(ladder, 3));
        System.out.println("doit. select: " + 4 + ", result: " + doit(ladder, 4));
    }
    
    private void print(List<List<Boolean>> ladder) {
        int playerCount = ladder.get(0).size();
        System.out.print("  ");
        for (int i=0;i<=playerCount;i++) {
            System.out.print(i + "    ");
        }
        System.out.println();
        ladder.forEach(line -> {
            System.out.print("  ");
            line.forEach(e -> {
                System.out.print("|" + (e ? "----" : "    "));
            });
            System.out.println("|  ");
        });
        System.out.print("  ");
        for (int i=0;i<=playerCount;i++) {
            System.out.print(i + "    ");
        }
        System.out.println();
    }
    
    private List<List<Boolean>> generatorLadder(int width, int playerCount) {
        final Random random = new Random();
        return IntStream.range(0, width).mapToObj(i -> {
            List<Boolean> line = Lists.newArrayList();
            boolean pre = false;
            for (int j=0; j<playerCount-1;j++) {
                boolean target = pre ? false : random.nextBoolean();
                line.add(target);
                pre = target;
            }
            return line;
        }).collect(Collectors.toList());
    }
    
    private List<List<Boolean>> generatorLadder2() {
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
