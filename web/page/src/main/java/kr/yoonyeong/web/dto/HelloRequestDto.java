package kr.yoonyeong.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rival
 * @since 2022-08-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloRequestDto {
    private String name;
    private Long age;
}
