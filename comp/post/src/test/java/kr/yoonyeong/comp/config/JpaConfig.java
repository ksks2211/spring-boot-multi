package kr.yoonyeong.comp.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author rival
 * @since 2022-08-16
 */
@Configuration
@EnableJpaAuditing
@EntityScan(
    basePackages = {
        "kr.yoonyeong.comp.entity"
    }
)
@EnableJpaRepositories(
    basePackages = {
        "kr.yoonyeong.comp.repository"
    }
)
public class JpaConfig {
}
