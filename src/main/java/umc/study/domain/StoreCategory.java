package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_ca_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "storeCategory", cascade = CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();
}

