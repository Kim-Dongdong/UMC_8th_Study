package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Setter
@Builder
@Table(name = "store_hashtag")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StoreHashtag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) // 현재 엔터티 To 연관관계 엔터티 관계로 생각하자
    @JoinColumn(name = "store_id") // 외래키 이름 지정
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY) // 현재 엔터티 To 연관관계 엔터티 관계로 생각하자
    @JoinColumn(name = "hashtag_id") // 외래키 이름 지정
    private HashTag hashtag;

    public void addStore(Store store) {
        this.store = store;
        store.getStoreHashtagList().add(this);
    }

    public void addHashtag(HashTag hashtag) {
        this.hashtag = hashtag;
        hashtag.getStoreHashtagList().add(this);
    }
}
