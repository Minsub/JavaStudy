package com.minsub.java.test.sinsege.samples;


public class UserInput {
    public static class TextInput {
        private StringBuilder sb = new StringBuilder();
        public void add(char c) {
            sb.append(c);
        }
        public String getValue() {
            return sb.toString();
        }
    }

    public static class NumericInput extends TextInput {
        public void add(char c) {
            if (c >= '0' && c <= '9') {
                super.add(c);
            }
        }

    }

    public static void main(String[] args) {
      UserInput.TextInput input = new UserInput.NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
