package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Setter
@Builder
@Table(name = "member_photo")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPhoto extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_photo_id")
    private Long id;

    @Column(nullable = false)
    private String image_url;

    @OneToOne(mappedBy = "memberPhoto")
    private Member member;
}
