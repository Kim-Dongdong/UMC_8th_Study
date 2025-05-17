package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = true, length = 20)
    private String  phoneNum;

    @Column(nullable = false, length = 20)
    private Long age;

    @Column(nullable = false)
    private LocalDate birth;

    private Integer point;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    // 양방향 매핑
    // 1:N에서 1에 해당하는 엔터티에 설정
    // N에 해당하는 엔티티에서 ManyToOne이 설정 된 멤버변수를 mappedBy
    // 양방향이므로 cascade 설정을 여기서 할 수 있음
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Alarm> alarmsList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "member_photo_id")
    private MemberPhoto memberPhoto;

    public void addAlarm(Alarm alarm) {
        alarmsList.add(alarm);
        alarm.setMember(this);
    }

    public void addReview(Review review) {
        reviewList.add(review);
        review.setMember(this);
    }

    public void addUserPhoto(MemberPhoto memberPhoto) {
        this.memberPhoto = memberPhoto;
        memberPhoto.setMember(this);
    }

}
