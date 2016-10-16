package com.ushara.dengigo.entity;

@Entity
@Table(name = "REQUEST_TYPES")
public class RequestType extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REQUEST_TYPE_ID")
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "requestType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Request> requests = new HashSet<>();

    @OneToMany(mappedBy = "requestType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Field> fields = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
