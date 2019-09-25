package com.spring.base;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/23 15:10
 */
public class ConcurrentHashMapTets {
    @Test
    public void fun1() {


        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "b");

        System.out.println(4 >> 1);

        System.out.println(4 << 1);
    }
}
