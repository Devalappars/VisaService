package com.visa.erp.DAO;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 */
@MappedSuperclass
public abstract class AbstractDAO extends PersistenceEntity {

    /**
     *
     */
    private static final long serialVersionUID = 7595201076212808020L;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "UpdatedBy")
    private String updatedBy;

    @Column(name = "CreatedOn")
    private LocalDateTime createdDate;

    @Column(name = "UpdatedOn")
    private LocalDateTime updatedDate;

    /**
     *
     */
    public AbstractDAO() {
        super();
    }

    /**
     * @param id
     */
    public AbstractDAO(Long id) {
        super(id);
    }

    /**
     * @param createdDate
     * @param updatedDate
     */
    public AbstractDAO(LocalDateTime createdDate, LocalDateTime updatedDate) {
        super();
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the updatedBy
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the createdDate
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the updatedDate
     */
    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate the updatedDate to set
     */
    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("createdBy=");
        builder.append(createdBy);
        builder.append(", updatedBy=");
        builder.append(updatedBy);
        builder.append("createdDate=");
        builder.append(createdDate);
        builder.append(", updatedDate=");
        builder.append(updatedDate);
        builder.append(",");
        return builder.toString();
    }

}
