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


        char[] ccc = new char[10];
        ccc[0] = 'a';
        ccc[1] = 'b';
        ccc[2] = 'c';

        System.out.println("test");
        System.out.println(ccc.toString());
        System.out.println(String.valueOf(ccc));


        String str = "12345";
        char[] arr = str.toCharArray();

        char tmp;
        for (int i=0; i < arr.length / 2; i++) {
            tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }

        System.out.println(String.valueOf(arr));
    }
}
