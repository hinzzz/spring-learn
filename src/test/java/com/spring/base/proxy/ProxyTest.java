package com.spring.base.proxy;

import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ：quanhz
 * @date ：Created in 2019/10/8 10:46
 */
public class ProxyTest {

    @Test
    public void fun1()throws Exception{
        Game game = new LOL();
        InvocationHandler proxy = new LOLProxy(game);
        Game lol = (Game) Proxy.newProxyInstance(game.getClass().getClassLoader(),game.getClass().getInterfaces(),proxy);
        System.out.println(lol.getClass());
        lol.play("hinzzz");


        byte[] bts = ProxyGenerator.generateProxyClass("$Proxy4", game.getClass().getInterfaces());
        FileOutputStream fos = new FileOutputStream(new File("D:\\$Proxy4.class"));
        fos.write(bts);
        fos.flush();
        fos.close();

    }
}
