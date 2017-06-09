package com.minsub.java.test.sinsege;

public class Packages {
    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        int result = 0;

        int lagrgePacked = items - (availableLargePackages * 5);
        if (lagrgePacked >= 0) {
            result = availableLargePackages;
            items = lagrgePacked;
        } else {
            int notUsedLargeCnt = lagrgePacked / -5 + 1;
            result = availableLargePackages - notUsedLargeCnt;
            items = items - ((availableLargePackages-notUsedLargeCnt) * 5);
        }

        if (items > availableSmallPackages) {
            return -1;
        }

        return result + items;
    }

    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(16, 2, 10));
    }
}