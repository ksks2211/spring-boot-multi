package kr.yoonyeong.comp.entity;

import kr.yoonyeong.comp.conf.JpaConfig;
import kr.yoonyeong.comp.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rival
 * @since 2022-08-16
 */
@DataJpaTest
@Import(JpaConfig.class)
class MemberTest {
    @Autowired
    MemberRepository memberRepository;


    @DisplayName("1. Save Member")
    @Test
    void test_1() {

        String email = "example12@email.com";
        String name = "user1";
        String password="12345";



        memberRepository.save(Member.builder()
            .email(email)
            .name(name)
            .password(password)
            .build()
        );

        memberRepository.flush();

        Member member = memberRepository.findAll().get(0);

        System.out.println("==========================================================");
        System.out.println(member);
        System.out.println("==========================================================");

        assertNotNull(member);
        assertEquals(name,member.getName());
        assertEquals(password,member.getPassword());
        assertEquals(email,member.getEmail());


    }



}