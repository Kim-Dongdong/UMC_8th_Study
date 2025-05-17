package umc.study.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository.ReviewRepositoryCustom;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
