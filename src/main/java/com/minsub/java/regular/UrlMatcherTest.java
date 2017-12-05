package com.minsub.java.regular;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gray.ji on 2017. 9. 14..
 */
public class UrlMatcherTest {
    
    public final static String URL_PATTERN = "^http(s{0,1})://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%]*";
    public final static String URL_PATTERN2 = "((http|ftp|https):\\/\\/w{3}[\\d]*\\.|(http|ftp|https):\\/\\/|w{3}[\\d]*\\.)([\\w\\d\\._\\-#\\(\\)\\[\\]\\\\,;:]+@[\\w\\d\\._\\-#\\(\\)\\[\\]\\\\,;:])?([a-z0-9가-힣]+\\.)*[a-z가-힣\\-0-9]+\\.([a-z]{2,3})?[a-z]{2,6}(:[0-9]+)?(\\/[\\/a-z0-9가-힣\\._\\-,]+)*[a-z0-9가-힣\\-_\\.%]+(\\?[a-z0-9가-힣=%&amp;\\.\\-,#]+)?|[a-z0-9]+:\\/\\/\\S+/gim;";
    public final static String[] test_case = {
            "https://www.daum.net",
            "ㅇㅎㅇhttp://www.daum.net?qwe=qwe%123=123 입니다 유알엘은 http://www.daum.net 입니다",
            "http://daum.net",
            "www.daum.net",
            "https://www.daum.net",
            "ftp://www.daum.net",
            "http://gyrfalcon.tistory.com/entry/Spring-boot-1-프로젝트-시작하기-Gradle",
            "http://gyrfalcon.tistory.com/entry/sptring-프로젝트-123",
            "HTTP://WWW.DAUM.NET",
            "http://gyrfalcon.tistory.com/entry/Spring-boot-1-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Gradle"
            
    };
    
    @Test
    public void test1() throws Exception {
    
        
        
        Pattern urlPattern = Pattern.compile(URL_PATTERN2);
        
                
        for (int i=0; i < test_case.length; i++) {
            Matcher matcher = urlPattern.matcher(test_case[i].toLowerCase());
            while (matcher.find()) {
                System.out.println(i + " : " + matcher.group() + "   => " + test_case[i].substring(matcher.start(), matcher.end()));
            }
    
        }
    }
}
