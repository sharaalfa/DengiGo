package com.ushara.dengigo.entity;

@Entity
@Table(name = "DEPARTMENTS")
public class Department extends  AuditableEntity{
    @Id
    private int id;
    @Column(name = "DEPART_NAME")
    private String name;

    @OneToMany(mappedBy = "department")
    Set<User> userSet = new HashSet();

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
