package com.minsub.java.test.programers;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasyCase {
    
    @Test
    public void joystick() {
        String s = "JAN";
//        String s = "AAA";
        
        int answer = 0;
        for (int i=0; i < s.length(); i++) {
            int t = (int)s.charAt(i) - 65;
            answer += t > 13 ? 26 - t : t;
        }
        answer += s.length() - (s.length() > 1 && s.charAt(1) == 'A' ? 2 : 1);
        
        
        String tt = "BAAA1111AAA1";
        Matcher m = Pattern.compile("([A]{2,})").matcher(tt);
        if (m.find()) {
            System.out.println(m.groupCount());
            System.out.println(m.group());
        }
        
        
        
    }
}
