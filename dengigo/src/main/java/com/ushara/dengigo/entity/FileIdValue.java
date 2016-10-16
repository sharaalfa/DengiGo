package com.ushara.dengigo.entity;


@Entity
@Table(name = "FIELD_VALUES")
public class FileIdValue {
    @Id
    private FileldValueKey fieldValueKey;

    @Column(name = "STRING_VALUE")
    private String stringValue;
    @Column(name = "NUMBER_VALUE")
    private Number numberValue;
    @Column(name = "DATE_VALUE")
    private Date dateValue;
}
