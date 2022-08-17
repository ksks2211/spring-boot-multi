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
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String password;

    @Column(unique = true)
    private String email;
}
