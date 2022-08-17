package kr.yoonyeong.comp.entity;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author rival
 * @since 2022-08-16
 */
@MappedSuperclass
@EntityListeners(value={AuditingEntityListener.class})
@Getter
@ToString
abstract class BaseEntity {
    @CreatedDate  // Entity 생성시간 , JPA에서 처리
    @Column(updatable=false)
    private LocalDateTime regDate;

    @LastModifiedDate  // Entity 변경시간
    @Column
    private LocalDateTime modDate;
}