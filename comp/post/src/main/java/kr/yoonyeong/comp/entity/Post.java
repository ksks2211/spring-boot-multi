package kr.yoonyeong.comp.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author rival
 * @since 2022-08-16
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString(callSuper = true)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private PostType type = PostType.FREE;

    @ToString.Exclude
    @ManyToOne
    private Member writer;

    public enum PostType {
        NOTICE, FREE
    }

}
