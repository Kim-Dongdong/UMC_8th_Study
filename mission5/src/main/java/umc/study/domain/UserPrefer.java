package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Setter
@Builder
@Table(name = "user_prefer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 연관관계 맵핑
    // 외래키가 존재하는 엔터티이므로 주인이다
    @ManyToOne(fetch = FetchType.LAZY) // 현재 엔터티 To 연관관계 엔터티 관계로 생각하자
    @JoinColumn(name = "user_id") // 연관관계 엔터티의 id 이름, 실제 DB에서 해당 칼럼(외래키)의 이름 설정
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    public void addUser(User user) {
        this.user = user;
        user.getUserPreferList().add(this);
    }

    public void addFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
        foodCategory.getUserPrefersList().add(this);
    }
}
