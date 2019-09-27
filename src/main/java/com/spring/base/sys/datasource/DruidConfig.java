package com.spring.base.sys.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@MapperScan("com.spring.base.dao.base.xml")
@Configuration
public class DruidConfig {


    @ConfigurationProperties(prefix = "spring.datasource.master")
    @Bean(name = "master")
    public DataSource druidMaster() {
        return new DruidDataSource();
    }

    @ConfigurationProperties(prefix = "spring.datasource.slave")
    @Bean(name = "slave")
    public DataSource druidSlave() {
        return new DruidDataSource();
    }

    @ConfigurationProperties(prefix = "spring.datasource.other")
    @Bean("otherDataSource")
    public DataSource otherDataSource(){
        return new DruidDataSource();
    }
    @Bean
    public DynamicDataSource dynamicDataSource() {
        System.out.println("\"aaa\" = " + "aaa");
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DBTypeEnum.MASTER.getValue(), druidMaster());
        targetDataSource.put(DBTypeEnum.SLAVE.getValue(), druidSlave());
        targetDataSource.put(DBTypeEnum.OTHER.getValue(), otherDataSource());
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(druidMaster());
        return dataSource;
    }


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory()
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource());
        return bean.getObject();
    }

    /******配置事务管理********/
    @Bean(name = "masterTransactionManager")
    public DataSourceTransactionManager masterTransactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }

    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager slaveTransactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }

    @Bean(name = "otherTransactionManager")
    public DataSourceTransactionManager otherTransactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource() );
    }


    //配置Druid的监控
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();

        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        initParams.put("allow", "");//默认就是允许所有访问
        initParams.put("deny", "127.0.0.1");
        bean.setInitParameters(initParams);
        return bean;
    }


    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
