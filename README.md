# spring-learn
### 2019-09
##### 1、@ControllerAdvice和ExceptionHandler对异常的处理	2019-09-17
##### 2、@Transactional对异常的回滚情况	2019-09-17
##### 3、@RequestBody一般用于处理非 Content-Type: application/x-www-form-urlencoded编码格式的数据，比如：application/json、application/xml等类型的数据。	2019-09-17
##### 4、利用aop加自定义注解在controller层添加日志操作 测试地址http://localhost:9999/sso/log (a minute ago)   	2019-09-17

##### 5、整合aop 自定义注解 springboot自动配置类 yml配置文件 阿里Druid数据源 实现多数据源的切换  	2019-09-18

##### 6、修改yml配置文件 统一级的属性必须左对齐 	 2019-09-19

##### 7、整合slf4j+logback日志框架 测试session 关闭浏览器是否失效 失效      	2019-09-20

##### 8、org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'defaultValidator' defined in class path resource [org/springframework/boot/autoconfigure/validation/ValidationAutoConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.validation.beanvalidation.LocalValidatorFactoryBean]: Factory method 'defaultValidator' threw exception; nested exception is java.lang.NoClassDefFoundError: javax/el/ELManager
tomcat 版本升级到8解决

##### 9、tomcat升级到9控制台出现中文乱码D:\hinzzz\apache-tomcat-9.0.26\conf\logging.properties 
注释掉这行即可java.util.logging.ConsoleHandler.encoding = UTF-8
##### 10、远程连接阿里云mysql报2059错误 ALTER USER 'root'@'%' IDENTIFIED BY 'password' PASSWORD EXPIRE NEVER  % 指匹配所有ip 也可以为特定ip