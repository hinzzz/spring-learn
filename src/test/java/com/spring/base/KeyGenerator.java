package com.spring.base;

import java.util.Random;

public class KeyGenerator {
    int defaultKey = 1;
    private static KeyGenerator keyGenerator = null;
    public synchronized static KeyGenerator  getInstance(){
        if(keyGenerator==null){
            keyGenerator = new KeyGenerator();
        }
        return keyGenerator;
    }
    private KeyGenerator(){

    }


    public  int getNextKey(){
       int key =  getKey();

        return key;
    }

    private  int getKey() {
        return defaultKey ++;
    }
}
