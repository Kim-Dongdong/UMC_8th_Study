package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewRequest is a Querydsl query type for ReviewRequest
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewRequest extends EntityPathBase<ReviewRequest> {

    private static final long serialVersionUID = 1609827925L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewRequest reviewRequest = new QReviewRequest("reviewRequest");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final QAlarm alarm;

    public final StringPath contents = createString("contents");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewRequest(String variable) {
        this(ReviewRequest.class, forVariable(variable), INITS);
    }

    public QReviewRequest(Path<? extends ReviewRequest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewRequest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewRequest(PathMetadata metadata, PathInits inits) {
        this(ReviewRequest.class, metadata, inits);
    }

    public QReviewRequest(Class<? extends ReviewRequest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.alarm = inits.isInitialized("alarm") ? new QAlarm(forProperty("alarm"), inits.get("alarm")) : null;
    }

}

