package com.spring.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：quanhz
 * @date ：Created in 2019/10/8 10:40
 */
public class LOLProxy implements InvocationHandler {

    private Game game;

    public LOLProxy(Game game) {
        this.game = game;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------------begin-------------");
        Object invoke = method.invoke(game, args);
        System.out.println("--------------end-------------");
        return null;
    }
}
