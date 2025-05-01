package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 20)
    private String operateTime;

    @Column(nullable = false, length = 20)
    private String phoneNum;

    @Column(nullable = false, length = 100)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_ca_id")
    private StoreCategory storeCategory;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Region> regionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<StoreHashtag> storeHashtagList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    public void addRegion(Region region) {
        regionList.add(region);
        region.setStore(this);
    }

    // 학습용으로 만들어봄
    public void addStoreCategory(StoreCategory storeCategory) {
        this.storeCategory = storeCategory;
        storeCategory.getStoreList().add(this);
    }

}
