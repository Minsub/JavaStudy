package com.minsub.java.test;

import com.google.common.collect.Lists;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.junit.*;
import org.junit.Test;

import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by jiminsub on 2017. 5. 14..
 */
public class Test2 {


    public static void main(String[] args) {
        
        LinkedHashMap lmap = new LinkedHashMap<String, String>();
        
        lmap.put("a","a");
    
        System.out.println(lmap instanceof LinkedHashMap);
        System.out.println(lmap instanceof HashMap);
        System.out.println(lmap instanceof Map);
    
        String url = "http://k.kakaocdn.net/dn/bwWqwt/btqhaIbD8Fc/E5nkjaxKOfMOCfHReoTyX1/img_s.jpg";
        System.out.println(FilenameUtils.getExtension(url));
            
        
        String aa = "aaaa";
        ttt(aa);
        System.out.println(aa);
        
        
        Map<String, Integer> map = new HashMap<>();
        
        
        map.put("aaa", 555);
        map.put("bbb", 222);
        
        
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
    
    public static void ttt (String aa) {
        aa = aa.toUpperCase();
        System.out.println("tttt: " + aa);
    }
    
//    private static final String URL_PATTERN = "((http|ftp|https):\\/\\/w{3}[\\d]*\\.|(http|ftp|https):\\/\\/|w{3}[\\d]*\\.)([\\w\\d\\._\\-#\\(\\)\\[\\]\\\\,;:]+@[\\w\\d\\._\\-#\\(\\)\\[\\]\\\\,;:])?([a-z0-9가-힣]+\\.)*[a-z가-힣\\-0-9]+\\.([a-z]{2,3})?[a-z]{2,6}(:[0-9]+)?(\\/[\\/a-z0-9가-힣\\._\\-,]+)*[a-z0-9가-힣\\-_\\.%]+(\\?[a-z0-9가-힣=%&amp;\\.\\-,#]+)?|[a-z0-9]+:\\/\\/\\S+/gim;";
    private static final String URL_PATTERN = "/^(http|https?|ftps?|sftp):\\/\\/([a-z0-9-]+\\.)+[a-z0-9]{2,4}.*$/";
    
    @Test
    public void tt() {
        int[] a = {1,1,2,2,3};
        System.out.println(solution(a));
    }
    
    public int solution(int[] input) {
        Set<Integer> firestSet = new HashSet<>();
        Set<Integer> allValues = new HashSet<>();
        for (int i=0; i < input.length; i++) {
            if (allValues.contains(input[i])) {
                firestSet.remove(input[i]);
            } else {
                firestSet.add(input[i]);
            }
            allValues.add(input[i]);
        }
        return firestSet.iterator().next();
    }
    
    public static Set<String> extractUrls(String text) {
        Set<String> urls = new HashSet<>();
        
        Pattern urlPattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = urlPattern.matcher(text.toLowerCase());
        for (int i=0; i < matcher.groupCount(); i++) {
            if (matcher.find(i)) {
                System.out.println(i + ": " + matcher.group(i));    
            }
        }
        
        return urls;
    }
    
    @Test
    public void stream() {
        List list1 = Lists.newArrayList(1,2,3);
        List list2 = Lists.newArrayList(3,2,1);
    
        System.out.println(list1.equals(list2));
    }
    
    @Test
    public void stream2() {
        boolean is = Lists.newArrayList(1,2,3,4,5).stream().anyMatch(i -> i >= 2 && i <= 4 );
        System.out.println(is);
    }
    
    public static class Item implements Comparable<Item> {
        public int aa;
        
        public Item(int aa) {
            this.aa = aa;
        }
    
        @Override
        public String toString() {
            return String.valueOf(aa);
        }
    
    
        @Override
        public int compareTo(Item o) {
            return this.aa - o.aa;
        }
    }
    
    private String getLocalTime(final Date dateTime){
//        final FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss.SSSZ", TimeZone.getTimeZone("Asia/Seoul"));
        final FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm ss.SSS", TimeZone.getTimeZone("Asia/Seoul"));
        return dateFormat.format( dateTime );
    }
    
    
    
    @Test
    public void url() throws Exception {
        String path = "http://www.daum.net/test/test/";
    
    
        URL url = new URL(path);
    
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        
    }
    
    @Test
    public void stringutils() {
        String s = "123.123412312";
        s = "123.23";
        System.out.println(StringUtils.isNumeric(s));
        
        
    }
    
    @Test
    public void aaaaaa() {
        int n = 10;
        System.out.println(solution(n));
        System.out.println(fibo(n + 1));
    }
    
    public int solution(int n) {
        int answer = 0;
        int a = 2; int b= 3;
        if(n<4) return n;
        for(int i =4; i<=n; i++){
            answer = (a+b)%1000000007;
            a = b;
            b = answer ;
        }
        return answer;
    }
    
    public int fibo(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibo(n - 2) + fibo(n - 1);
        }
    }
}

