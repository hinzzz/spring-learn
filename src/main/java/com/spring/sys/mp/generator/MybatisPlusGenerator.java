package com.spring.sys.mp.generator;
 
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MybatisPlusGenerator {
	private static MybatisPlusGenerator single = null;
	
	private MybatisPlusGenerator() {
		super();
	}
	
	private static MybatisPlusGenerator getSingle() {
		if(single == null) {
			single =new MybatisPlusGenerator();
		}
		return single;
	}
	
	public void autoGeneration() {
		 GlobalConfig config = new GlobalConfig();
	        String dbUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
	        DataSourceConfig dataSourceConfig = new DataSourceConfig();
	        dataSourceConfig.setDbType(DbType.MYSQL)
	                .setUrl(dbUrl)
	                .setUsername("root")
	                .setPassword("123456")
	                .setDriverName("com.mysql.cj.jdbc.Driver");

	        StrategyConfig strategyConfig = new StrategyConfig();
	        strategyConfig
	                .setCapitalMode(true)
	                .setEntityLombokModel(false)
	                .setDbColumnUnderline(true)
	                .setNaming(NamingStrategy.underline_to_camel);
	        config.setActiveRecord(false)
	                .setEnableCache(false)
	                .setAuthor("hinzzz")
	                //指定输出文件夹位置
	                .setOutputDir("D:\\hinzzz\\spring-learn\\src\\main\\java")
	                .setFileOverride(true)
	                .setServiceName("%sService");
	        new AutoGenerator().setGlobalConfig(config)
	                .setDataSource(dataSourceConfig)
	                .setStrategy(strategyConfig)
	                .setPackageInfo(
	                        new PackageConfig()
	                                .setParent("com.spring.base")
	                                .setController("controller")
	                                .setEntity("model")
									.setMapper("dao")
									.setXml("dao.xml")
	                ).execute();
	}
	/**
	 * 自定义生成文件
	 */
	private static InjectionConfig customerConfig() {
		InjectionConfig config = new InjectionConfig() {
			@Override
			public void initMap() {

			}
		};

		List<FileOutConfig> files = new ArrayList<FileOutConfig>();
		files.add(new FileOutConfig("controller.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				String expand = "com.spring.base";
				String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getControllerName());
				return entityFile;
			}
		});
		config.setFileOutConfigList(files);
		return config;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MybatisPlusGenerator generator = MybatisPlusGenerator.getSingle();
		generator.autoGeneration();
	}
 
}