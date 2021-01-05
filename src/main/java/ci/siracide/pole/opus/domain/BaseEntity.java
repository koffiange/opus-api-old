package ci.siracide.pole.opus.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity extends PanacheEntityBase {
    @Id
    @Column(name = "ID")
    public String uuid;


    @Column(name = "CREATED")
    public LocalDateTime createdDate;

    @Column(name = "UPDATED")
    public LocalDateTime updatedDate;

    @Column(name = "CREATED_BY")
    public String createdBy;

    @Column(name = "UPDATED_BY")
    public String updatedBy;

    public String generateEntityId(){
        UUID oUuid = UUID.randomUUID();
        return oUuid.toString();
    }

    @PrePersist
    public void initializeEntity() {
        this.createdDate = LocalDateTime.now();
        this.uuid = generateEntityId();
    }

    @PreUpdate
    public void setEntityForUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
