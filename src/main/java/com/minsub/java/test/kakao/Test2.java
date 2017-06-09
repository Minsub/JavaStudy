package com.minsub.java.test.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jiminsub on 2017. 5. 14..
 */
public class Test2 {

    public static int[] cardinalitySort(int[] nums) {
        // make pair list (number, cardinalityCount)
        List<Integer[]> listDecBinCount = new ArrayList<Integer[]>();
        Integer[] item;
        for (int i=0; i < nums.length; i++) {
            item = new Integer[2];
            item[0] = nums[i];
            item[1] = getCardinalityCount2(item[0]);
            listDecBinCount.add(item);
        }

        // sort
        Collections.sort(listDecBinCount, (o1, o2) -> o1[1] - o2[1] == 0 ? o1[0] - o2[0] : o1[1] - o2[1] );

        // create result
        int[] arrResult = new int[nums.length];
        for (int i=0; i < listDecBinCount.size(); i++) {
            arrResult[i] = listDecBinCount.get(i)[0];
        }

        return arrResult;
    }

    public static int getCardinalityCount(int n) {
        int nCnt = 0;
        String strBinary = Integer.toBinaryString(n);
        for (char c: strBinary.toCharArray()) {
            if (c == '1') {
                nCnt++;
            }
        }
        return nCnt;
    }

    // new
    public static int getCardinalityCount2(int n) {
        int cnt = 0;
        while(n > 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        return cnt;
    }


    public static void main(String[] args) {
        Test2 t = new Test2();

        int[] a = {31, 15, 7 ,3 , 2};

        int[] b = t.cardinalitySort(a);

        for (int v: b) {
            System.out.println(v);
        }
    }

}
