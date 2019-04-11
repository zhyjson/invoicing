package cn.wdu4.invoicing.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhy
 * @create 2019-04-02 20:50
 */
@Configuration
public class MybatisConfig {
    /**
     * 自定义mybatis定义规则-》 开启驼峰命名法匹配规则
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return (x) -> x.setMapUnderscoreToCamelCase(true);
    }
}
