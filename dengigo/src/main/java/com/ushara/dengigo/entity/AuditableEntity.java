package com.ushara.dengigo.entity;

@MappedSuperclass
public abstract class AuditableEntity {
    @Column(name = "CREATED_BY")
    protected String createdBy;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;
    @Column(name = "UPDATED_BY")
    protected String updatedBy;
    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedDate;

    public AuditableEntity() {

        this.createdDate = new Date();
        this.updatedDate = new Date();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
