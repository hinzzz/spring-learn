package com.spring.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestKeyGenerator {
    public static void main(String[] args) {

        final KeyGenerator instance = KeyGenerator.getInstance();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 2000; i1++) {
                        int nextKey = instance.getNextKey();
                        System.out.println(Thread.currentThread().getName()+"   key = " + nextKey);
                        if(!set.add(nextKey)){
                            System.out.println("***************************************************" + nextKey);
                        }
                    }
                }
            }.start();
        }
    }




}
