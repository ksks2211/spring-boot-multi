package kr.yoonyeong.comp.repository;

import kr.yoonyeong.comp.entity.Member;
import kr.yoonyeong.comp.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rival
 * @since 2022-08-16
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    Page<Post> findPostsByWriter(Member writer, Pageable pageable);
}
