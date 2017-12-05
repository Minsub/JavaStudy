package com.minsub.java.kakao.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.junit.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

/**
 * Created by gray.ji on 2017. 10. 31..
 */
public class RestSample {
    
    
    
    
    @Test
    public void test() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String authKey = "";
//            String url = "http://rocket-api.devel.kakao.com/talk/profiles/56229/contact";
//            String url = "http://beta-pf-papi.kakao.com/internal/talk/profiles/profile_id?uuid=jiminsub";
            String url = "http://beta-pf-papi.kakao.com/internal/talk/profiles/255108396";
            
            RequestEntity<Void> req = RequestEntity.get(new URI(url))
//                    .header("Authorization", "Bearer " + authKey)
                    .header("contentType","application/json")
                    .build();
            ResponseEntity<Map> response = restTemplate.exchange(req, Map.class);
//            ResponseEntity<Integer> response = restTemplate.exchange(req, Integer.class);
            
            System.out.println(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
