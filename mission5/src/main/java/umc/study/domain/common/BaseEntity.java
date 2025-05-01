package umc.study.domain.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// 모든 엔티티 클래스마다 이 추상 클래스를 상속받아 createdAt, updatedAt 사용
@MappedSuperclass // 상속받는 엔티티들에 이 클래스의 필드를 포함시켜줌
@EntityListeners(AuditingEntityListener.class) // 엔티티의 변경 이벤트를 감지해서, @CreatedDate, @LastModifiedDate 값을 자동으로 채워줌
@Getter
public abstract class BaseEntity {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
