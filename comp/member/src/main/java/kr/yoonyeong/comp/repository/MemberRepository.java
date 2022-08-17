package kr.yoonyeong.comp.repository;

import kr.yoonyeong.comp.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author rival
 * @since 2022-08-16
 */
@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
}
