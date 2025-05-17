package umc.study.repository.StoreRepository;

import org.springframework.stereotype.Repository;
import umc.study.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
