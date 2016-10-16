package com.ushara.dengigo.entity;

import java.io.Serializable;

@Entity
@Table(name = "FIELDS")
public class Field extends AuditableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIELD_ID")
    private Integer fieldId;
    @Column(name="FIELD_NAME")
    private String fieldName;
    @ManyToOne
    @JoinColumn(name = "FIELD_TYPE_ID")
    private  FieldType fieldType;
    @ManyToOne
    @JoinColumn(name = "REQUEST_TYPE_ID")
    private  RequestType requestType;

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }
}
