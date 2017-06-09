package com.minsub.java.test.kakao;

/**
 * Created by jiminsub on 2017. 5. 14..
 */
public class Test1 {

    public static int minimumMoves(int[] a, int[] m) {
        int nResult = 0;

        for (int i=0; i < a.length; i++) {
            nResult += getMinimumCount2(a[i], m[i]);
        }

        return nResult;
    }

    private static int getMinimumCount(int a, int m) {
        int nCnt = 0;
        String strA = String.valueOf(a);
        String strM = String.valueOf(m);

        int nA, nM;
        for (int i=0; i < strA.length(); i++) {
            nA = Character.getNumericValue(strA.charAt(i));
            nM = Character.getNumericValue(strM.charAt(i));

            while(nA != nM) {
                if (nA < nM) {
                    nA++;
                } else {
                    nA--;
                }
                nCnt++;
            }
        }
        return nCnt;
    }

    // new
    private static int getMinimumCount2(int a, int m) {
        int nCnt = 0;
        int nA, nM;
        while (a > 0) {
            nA = a % 10;
            nM = m % 10;

            nCnt += Math.abs(nA - nM);

            a = a / 10;
            m = m / 10;
        }

        return nCnt;
    }


    public static void main(String[] args) {
        Test1 t = new Test1();

        int[] a = {1234, 4321};
        int[] m = {2345, 3214};

        System.out.println(t.minimumMoves(a, m));
    }

}
