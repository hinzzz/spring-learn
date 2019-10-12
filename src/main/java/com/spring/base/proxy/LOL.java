package com.spring.base.proxy;

/**
 * @author ：quanhz
 * @date ：Created in 2019/10/8 9:27
 */
public class LOL implements Game{
    @Override
    public void play(String name) {
        System.out.println("LOL...............");
    }
}
