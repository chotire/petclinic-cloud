package petclinic.service.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// https://goodgid.github.io/Spring-Data-JPA-Auditing/
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EntityListeners({ AuditingEntityListener.class, BaseAuditEntityListener.class })
public class BaseAuditEntity {
    @CreatedBy
    @Column(length = 36, updatable = false)
    @JsonIgnore
    private String createdBy;

    @Setter
    @Column(length = 30, updatable = false)
    @JsonIgnore
    private String createdIp;

    @CreatedDate
    @Column(updatable = false)
    @JsonIgnore
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(length = 36, insertable = false)
    @JsonIgnore
    private String lastModifiedBy;

    @Setter
    @Column(length = 30, insertable = false)
    @JsonIgnore
    private String lastModifiedIp;

    @LastModifiedDate
    @Column(length = 30, insertable = false)
    @JsonIgnore
    private LocalDateTime lastModifiedDate;
}
