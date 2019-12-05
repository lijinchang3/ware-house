package com.hcl.warehouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hcl.warehouse.sys.mapper")
public class WareHouseErpApplication {

    public static void main(String[] args) {
        SpringApplication.run(WareHouseErpApplication.class, args);
    }

}
