package com.ushara.dengigo.entity;

@Entity
@Table(name = "FIELD_TYPES")
public class FieldType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIELD_TYPE_ID")
    private Integer fieldTypeId;

    @Column(name = "FIELD_TYPE_NAME")
    private  String fieldTypeName;


    public Set<Field> getFieldSet() {
        return fieldSet;
    }

    @OneToMany(mappedBy = "fieldType", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Field> fieldSet = new HashSet<>();


    public Integer getFieldTypeId() {
        return fieldTypeId;
    }

    public void setFieldTypeId(Integer fieldTypeId) {
        this.fieldTypeId = fieldTypeId;
    }

    public String getFieldTypeName() {
        return fieldTypeName;
    }

    public void setFieldTypeName(String fieldTypeName) {
        this.fieldTypeName = fieldTypeName;
    }
}
