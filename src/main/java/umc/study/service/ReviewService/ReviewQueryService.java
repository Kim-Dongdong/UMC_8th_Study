package umc.study.service.ReviewService;

public interface ReviewQueryService {
    Long createReview(Long storeId, Long memberId, String title, String contents, Float score);
}
