package kr.yoonyeong.comp.entity;

import kr.yoonyeong.comp.config.JpaConfig;
import kr.yoonyeong.comp.repository.MemberRepository;
import kr.yoonyeong.comp.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author rival
 * @since 2022-08-16
 */
@DataJpaTest
@Import(JpaConfig.class)
class PostTest {
    @Autowired
    PostRepository postRepository;

    @Autowired
    MemberRepository memberRepository;


    @DisplayName("1. Save Post")
    @Test
    void test_1() {

        // Given
        String title = "Title";
        String content = "Content";

        String name="kanye";
        String email = "email12@example.com";
        String password = "123345";


        Member writer = memberRepository.save(
            Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .build()
        );


        // when
        postRepository.save(
            Post.builder().title(title)
                .content(content)
                .writer(writer)
                .build()
        );

        postRepository.flush();
        List<Post> posts = postRepository.findAll();

        // then
        Post post = posts.get(0);

        System.out.println("================================================================");
        System.out.println(post);

        System.out.println(post.getWriter());

        System.out.println("================================================================");

        assertNotNull(post);
        assertEquals(title,post.getTitle());
        assertEquals(content,post.getContent());
        assertEquals(Post.PostType.FREE, post.getType());
    }

    @DisplayName("2. Get Posts from Member")
    @Test
    void test_2(){
        // Given
        String name = "Kanye West";
        String email = "jaja@email.com";
        String password = "12345";
        Member writer = Member.builder().name(name).email(email).password(password).build();
        memberRepository.save(writer);

        List<Post> posts = IntStream.rangeClosed(0, 9).mapToObj(i -> Post.builder().title("Title" + i).content("Content" + i).writer(writer).build()).collect(Collectors.toList());
        postRepository.saveAll(posts);

        // When
        Page<Post> result = postRepository.findPostsByWriter(writer, Pageable.ofSize(10));
        System.out.println("==================================================================");
        System.out.println(result.getTotalElements());
        System.out.println(result.getTotalPages());
        result.getContent().forEach(System.out::println);
        System.out.println("==================================================================");

        // then
        assertThat(result).isNotNull();
        assertThat(result.getTotalElements()).isEqualTo(10L);
        assertThat(result.getTotalPages()).isEqualTo(1);
        assertThat(result.getContent().size()).isEqualTo(10L);

    }
}