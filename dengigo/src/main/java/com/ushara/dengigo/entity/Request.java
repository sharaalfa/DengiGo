package com.ushara.dengigo.entity;


@Entity
@Table(name = "REQUESTS")
public class Request extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REQUEST_ID")
    private Integer requestId;
    @Column(name = "TITLE")
    private  String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ASSIGNED_TO")
    private String assignedTo;
    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", nullable=true)
    private RequestStatus status;

    @ManyToOne
    @JoinColumn(name = "REQUEST_TYPE_ID")
    private RequestType requestType;

    @Version
    private int version;

    public Request() {
        this.createdDate = new Date();
        this.updatedDate = new Date();

    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public RequestStatus getStatus() { return status; }

    public void setStatus(RequestStatus status) { this.status = status; }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }



}
