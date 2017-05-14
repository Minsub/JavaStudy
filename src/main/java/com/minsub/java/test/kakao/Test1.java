package com.minsub.java.test.kakao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jiminsub on 2017. 5. 14..
 */
public class Test1 {

    public static int minimumMoves(int[] a, int[] m) {
        int nResult = 0;

        for (int i=0; i < a.length; i++) {
            nResult += getMinimumCount(a[i], m[i]);
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


    public static void main(String[] args) {
        Test1 t = new Test1();

        int[] a = {1234, 4321};
        int[] m = {2345, 3214};

        System.out.println(t.minimumMoves(a, m));
    }

    public static void main2(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }


        int _m_size = 0;
        _m_size = Integer.parseInt(in.nextLine().trim());
        int[] _m = new int[_m_size];
        int _m_item;
        for(int _m_i = 0; _m_i < _m_size; _m_i++) {
            _m_item = Integer.parseInt(in.nextLine().trim());
            _m[_m_i] = _m_item;
        }

        res = minimumMoves(_a, _m);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
