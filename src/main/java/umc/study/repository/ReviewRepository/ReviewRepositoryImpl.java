package umc.study.repository.ReviewRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.*;

import java.util.List;

@Repository
@AllArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QReview qReview = QReview.review;

    @Override
    public void createReview(Member member, Review review) {
        jpaQueryFactory.insert(qReview)
                .columns(qReview.member.name, qReview.score, qReview.title, qReview.contents, qReview.createdAt)
                .values(member.getName(), review.getScore(), review.getTitle(), review.getContents(), review.getCreatedAt())
                .execute();
    }

}
