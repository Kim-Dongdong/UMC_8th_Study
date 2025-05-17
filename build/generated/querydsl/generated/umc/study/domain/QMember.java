package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 543821340L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final NumberPath<Long> age = createNumber("age", Long.class);

    public final ListPath<Alarm, QAlarm> alarmsList = this.<Alarm, QAlarm>createList("alarmsList", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.study.domain.enums.Gender> gender = createEnum("gender", umc.study.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<MemberAgree, QMemberAgree> memberAgreeList = this.<MemberAgree, QMemberAgree>createList("memberAgreeList", MemberAgree.class, QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<MemberMission, QMemberMission> memberMissionList = this.<MemberMission, QMemberMission>createList("memberMissionList", MemberMission.class, QMemberMission.class, PathInits.DIRECT2);

    public final QMemberPhoto memberPhoto;

    public final ListPath<MemberPrefer, QMemberPrefer> memberPreferList = this.<MemberPrefer, QMemberPrefer>createList("memberPreferList", MemberPrefer.class, QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath phoneNum = createString("phoneNum");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.study.domain.enums.SocialType> socialType = createEnum("socialType", umc.study.domain.enums.SocialType.class);

    public final EnumPath<umc.study.domain.enums.MemberStatus> status = createEnum("status", umc.study.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberPhoto = inits.isInitialized("memberPhoto") ? new QMemberPhoto(forProperty("memberPhoto"), inits.get("memberPhoto")) : null;
    }

}

