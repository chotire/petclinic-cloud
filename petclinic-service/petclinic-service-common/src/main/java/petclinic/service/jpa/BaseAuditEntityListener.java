package petclinic.service.jpa;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.servlet.http.HttpServletRequest;

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
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return "0.0.0.0";
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getRemoteAddr().startsWith("0:") ? "127.0.0.1" : request.getRemoteAddr();
    }
}
