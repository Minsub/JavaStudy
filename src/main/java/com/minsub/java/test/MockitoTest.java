package com.minsub.java.test;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by hmm1115222 on 2016-08-18.
 */
public class MockitoTest {

    @Mock
    private Person p2;

    @Test
    public void testAutoCreation() {
        // 객체 만들기
        Person p = mock(Person.class);
        // @Mock 어노테이션이용
        MockitoAnnotations.initMocks(this);
        Person p2 = this.p2;

        // 값지정
        when(p.getName()).thenReturn("Minsub");
        when(p.getAge()).thenReturn(33);
        when(p.getAddress()).thenReturn("Seoul");

        System.out.println("P from mock: " + p.getName());

    }
}
