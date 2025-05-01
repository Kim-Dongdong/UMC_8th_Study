package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "hashtag")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HashTag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "hashtag", cascade = CascadeType.ALL)
    private List<StoreHashtag> storeHashtagList = new ArrayList<>();

}
