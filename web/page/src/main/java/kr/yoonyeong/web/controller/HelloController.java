package kr.yoonyeong.web.controller;

import kr.yoonyeong.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rival
 * @since 2022-08-16
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(HelloResponseDto reqDto){
        return new HelloResponseDto(reqDto.getName(),reqDto.getAge());
    }
}
