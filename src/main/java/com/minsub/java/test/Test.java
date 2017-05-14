package com.minsub.java.test;

/**
 * Created by jiminsub on 2017. 5. 14..
 */
public class Test {

    public void sharp(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=n; i > 0; i--) {
            for (int j=1; j <= n; j++) {
                if (j >= i) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }

    public int summation(int[] numbers) {
        int result = 0;
        for (int i=1; i <= numbers[0]; i++) {
            result += numbers[i];
            System.out.println(numbers[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Test t = new Test();
        //t.sharp(6);

        int[] arrInt = {5,1,2,3,4,5};
        System.out.println(arrInt + " => " + t.summation(arrInt));
    }
}
