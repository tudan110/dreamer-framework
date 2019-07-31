package indi.tudan.dreamer.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangtan
 * @date 2019-07-26 17:06:02
 * @since 1.0
 */
// 注意扫包的问题，因为本项目是多模块的，依赖其他模块中的类都隶属于 package: indi.tudan.dreamer ，故而需要扫描到此包；
// 否则，其他模块的类可能会扫描不到
@SpringBootApplication(scanBasePackages = {"indi.tudan.dreamer"})
//@PropertySource("classpath:application.yml")
//@PropertySource("classpath:application-common.yml")
//@MapperScan(basePackages = {"indi.tudan.dreamer"}, annotationClass = TMapper.class)
@MapperScan(basePackages = {"indi.tudan.dreamer.demo.mapper"})
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        log.info("程序开始执行");
        SpringApplication.run(DemoApplication.class, args);
        log.info("程序执行中");
    }

}