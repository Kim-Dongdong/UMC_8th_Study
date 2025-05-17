package umc.study.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.QStore;
import umc.study.domain.Store;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {

}