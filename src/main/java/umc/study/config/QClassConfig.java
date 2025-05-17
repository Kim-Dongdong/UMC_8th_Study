package umc.study.config;

import com.querydsl.core.annotations.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import umc.study.domain.*;

@Configuration
public class QClassConfig {

    @Bean public QAlarm alarm() { return QAlarm.alarm; }
    @Bean public QFoodCategory foodCategory() { return QFoodCategory.foodCategory; }
    @Bean public QMember member() { return QMember.member; }
    @Bean public QMemberAgree memberAgree() { return QMemberAgree.memberAgree; }
    @Bean public QMemberMission memberMission() { return QMemberMission.memberMission; }
    @Bean public QMemberPhoto memberPhoto() { return QMemberPhoto.memberPhoto; }
    @Bean public QMemberPrefer memberPrefer() { return QMemberPrefer.memberPrefer; }
    @Bean public QMission mission() { return QMission.mission; }
    @Bean public QNewMission newMission() { return QNewMission.newMission; }
    @Bean public QRegion region() { return QRegion.region; }
    @Bean public QReview review() { return QReview.review; }
    @Bean public QReviewImage reviewImage() { return QReviewImage.reviewImage; }
    @Bean public QReviewRequest reviewRequest() { return QReviewRequest.reviewRequest; }
    @Bean public QStore store() { return QStore.store; }
    @Bean public QStoreCategory storeCategory() { return QStoreCategory.storeCategory; }
    @Bean public QTerms terms() { return QTerms.terms; }
}
