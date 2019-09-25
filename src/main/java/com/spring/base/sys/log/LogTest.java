package com.spring.base.sys.log;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/18 9:24
 */
public class LogTest {
    private static Map<Integer, BaseOperLog> logs = new HashMap<>();

    public static void put(BaseOperLog baseOperLog) {
        int key = logs.size() + 1;
        logs.put(key, baseOperLog);
    }


    public static Map<Integer, BaseOperLog> getLogs() {
        return logs;
    }
}
