package com.minsub.java.test.kakao;

/**
 * Created by jiminsub on 2017. 5. 14..
 */
public class Test3 {

    public static int[] frequency(String s) {
        int[] arrResult = new int[26];
        char c;
        int nJump, nCount, nNumber;

        for (int i=0; i < s.length(); ) {
            c = s.charAt(i);

            // extract number
            if ((c > '2') || (i >= s.length() - 2) || (s.charAt(i+2) != '#')) { // 1 digit
                nNumber = Character.getNumericValue(c);
                nJump = 1;
            } else { // 2 digit
                nNumber = Character.getNumericValue(c) * 10 + Character.getNumericValue(s.charAt(i+1));
                nJump = 3;
            }

            // extract count
            int nJumpedIdx = i + nJump;
            if ((nJumpedIdx >= s.length()) || s.charAt(nJumpedIdx) != '(') {  // count 1
                nCount = 1;
            } else { // count n
                StringBuilder sb = new StringBuilder();
                int nCountIdx = 0;
                while (s.charAt(nJumpedIdx + 1 + nCountIdx) != ')') {
                    sb.append(s.charAt(nJumpedIdx + 1 + nCountIdx));
                    nCountIdx++;
                }

                nCount = Integer.valueOf(sb.toString());
                nJump += (2 + nCountIdx);
            }

            arrResult[nNumber - 1] += nCount;

            i += nJump;
        }

        return arrResult;
    }


    public static void main(String[] args) {
        Test3 t = new Test3();

        String a = "1226#24#";
        a = "1(10)23(3)";

        int[] b = t.frequency(a);

        for (int v: b) {
            System.out.print(v + " ");
        }
    }

}
