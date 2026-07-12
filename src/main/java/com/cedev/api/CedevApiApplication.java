package com.cedev.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cedev.api")
@SpringBootApplication
public class CedevApiApplication {

    public static void main(String[] args) {
        // 기존의 무거운 구동 방식을 최적화하기 위해 설정을 추가하여 실행합니다.
        SpringApplication app = new SpringApplication(CedevApiApplication.class);
        
        // 💡 application.properties 설정을 소스 단에서 한 번 더 강제로 먹여 확실하게 차단합니다.
        System.setProperty("spring.jpa.hibernate.ddl-auto", "none");
        System.setProperty("spring.jpa.open-in-view", "false");
        
        app.run(args);
    }

}
