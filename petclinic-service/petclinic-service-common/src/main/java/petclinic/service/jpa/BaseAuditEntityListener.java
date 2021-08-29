package petclinic.service.jpa;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public final class BaseAuditEntityListener {
    @PreUpdate
    public void preUpdate(Object object) {
        if (object instanceof BaseAuditEntity) {
            BaseAuditEntity baseAuditEntity = (BaseAuditEntity) object;
            baseAuditEntity.setLastModifiedIp(getRemoteAddr());
        }
    }

    @PrePersist
    public void prePersist(Object object) {
        if (object instanceof BaseAuditEntity) {
            BaseAuditEntity baseAuditEntity = (BaseAuditEntity) object;
            baseAuditEntity.setCreatedIp(getRemoteAddr());
        }
    }

    private String getRemoteAddr() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        return request.getRemoteAddr();
    }
}
