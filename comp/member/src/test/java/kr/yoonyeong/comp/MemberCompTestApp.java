package kr.yoonyeong.comp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rival
 * @since 2022-08-16
 */
@SpringBootApplication(scanBasePackages = {
    "kr.yoonyeong.comp"
})
public class MemberCompTestApp {
    public static void main(String[] args) {
        SpringApplication.run(MemberCompTestApp.class,args);
    }
}
