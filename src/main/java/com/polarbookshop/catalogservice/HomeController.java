package com.polarbookshop.catalogservice;

import com.polarbookshop.catalogservice.config.PolarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final PolarProperties polarProperties; // 사용자 정의 속성 액세스를 위해 생성자 오토와이어링을 통해 주입된 빈

    public HomeController(PolarProperties polarProperties) {
        this.polarProperties = polarProperties;
    }

    @GetMapping("/")
    public String getGreeting() {
        return polarProperties.getGreeting(); // 설정 데이터 빈에서 가져온 환영 메세지를 사용한다.
    }

}
