package com.ushara.dengigo.entity;

@Entity
@Table(name="ROLES")
public class Role extends AuditableEntity{

    @Id
    private int id;
    @Column(name = "ROLE_NAME")
    private String name;

    @Column(name = "ROLE_DESC")
    private String description;

    @OneToMany(mappedBy = "role")
    Set<User> userSet = new HashSet<>();

    public Role() {
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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
