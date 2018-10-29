package com.highway;

import com.highway.mapper.CommonMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Creaed by fj on 2018/10/29
 */
@SpringBootApplication
@MapperScan(basePackages="com.highway.mapper", markerInterface = CommonMapper.class)
public class HighwayApplication {
    public static void main(String[] args) {
        SpringApplication.run(HighwayApplication.class, args);
    }
}
