package cn.wdu4.invoicing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 扫描mapper接口位置
@MapperScan("cn.wdu4.invoicing.mapper")
// SpringBoot主应用注解
@SpringBootApplication
public class InvoicingApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvoicingApplication.class, args);
    }

}
