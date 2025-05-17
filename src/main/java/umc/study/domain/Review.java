package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 100)
    private String contents;

    @Column(nullable = false)
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY) // 현재 엔터티 To 연관관계 엔터티 관계로 생각하자
    @JoinColumn(name = "store_id") // 외래키 이름 지정
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY) // 현재 엔터티 To 연관관계 엔터티 관계로 생각하자
    @JoinColumn(name = "member_id") // 외래키 이름 지정
    private Member member;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList = new ArrayList<>();

    public void addStore(Store store) {
        this.store = store;
        store.getReviewList().add(this);
    }

    public void addReviewImage(ReviewImage reviewImage) {
        reviewImageList.add(reviewImage);
        reviewImage.setReview(this);
    }
}
