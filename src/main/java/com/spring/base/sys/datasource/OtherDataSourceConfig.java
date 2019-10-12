package com.spring.base.sys.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/26 9:03
 */
@MapperScan("com.spring.base.dao.other")
@Configuration
public class OtherDataSourceConfig {


    /*@ConfigurationProperties(prefix = "spring.datasource.other")
    @Bean
    public DataSource otherDataSource(){
        return new DruidDataSource();
    }*/
    /*@Bean("otherSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(otherDataSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("otherDataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(otherDataSource());
        return dataSourceTransactionManager;
    }*/
}
