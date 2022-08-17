package kr.yoonyeong.web.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author rival
 * @since 2022-08-16
 */
@Data
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final Long age;
}
