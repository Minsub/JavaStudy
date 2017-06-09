package com.minsub.java.test.sinsege;



public class PermissionNotation {
    public static int symbolicToOctal(String permString) {
        int result = 0;
        for (int i=0; i < 9; i+=3) {
            result = (result * 10) + singleSymbolicToOctal(permString.substring(i, i + 3));
        }
        return result;
    }

    public static int singleSymbolicToOctal(String permString) {
        int result = 0;
        for (int i=0; i < 3; i++) {
            char c = permString.charAt(i);
            switch (c) {
                case 'r':
                    result += 4;
                    break;
                case 'w':
                    result += 2;
                    break;
                case 'x':
                    result += 1;
                    break;
                case '-':
                    result += 0;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Should write 752
        System.out.println(PermissionNotation.symbolicToOctal("rwxr-x-w-"));
    }
}