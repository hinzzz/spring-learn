package com.spring.base.sys.mp.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

@MapperScan(basePackages = {"com.spring.base.dao.user","com.spring.base.sys.security.mapper"})
@Configuration
//扫描dao或者是Mapper接口
public class MybatisPlusConfig {
    /***
     * plus 的性能优化
     * @return
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        /*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*/
        performanceInterceptor.setMaxTime(1000);
        /*<!--SQL是否格式化 默认false-->*/
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * @Description : mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}