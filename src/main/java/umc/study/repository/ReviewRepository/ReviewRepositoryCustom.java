package umc.study.repository.ReviewRepository;

import umc.study.domain.Member;
import umc.study.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {

    void createReview(Member member, Review review);
}
