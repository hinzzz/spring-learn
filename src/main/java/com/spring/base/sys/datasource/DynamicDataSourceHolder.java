package com.spring.base.sys.datasource;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/18 15:45
 */
public class DynamicDataSourceHolder {
    private final static ThreadLocal<String> holder = new ThreadLocal<>();

    public static void put(String dataSource) {
        holder.set(dataSource);
    }

    public static String get() {
        return holder.get();
    }

    public static void clear() {
        holder.remove();
    }
}
