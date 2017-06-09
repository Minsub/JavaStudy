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

    public static class NumericInput extends com.minsub.java.test.sinsege.sample.UserInput.TextInput {
        public void add(char c) {
            if (c >= '0' && c <= '9') {
                super.add(c);
            }
        }

    }

    public static void main(String[] args) {
        com.minsub.java.test.sinsege.sample.UserInput.TextInput input = new com.minsub.java.test.sinsege.sample.UserInput.NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
