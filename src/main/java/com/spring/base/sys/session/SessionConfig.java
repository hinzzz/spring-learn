package com.spring.base.sys.session;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Component;

/**
 * @author ：quanhz
 * @date ：Created in 2019/10/10 15:54
 */
@Component
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1)
public class SessionConfig {
}
