package com.project.CrudAssignment.models;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Language {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column        
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @Column
    @NotNull
    @Size(min = 3, max = 20)
    private String creator;

    @Column
    @NotNull
    @Size(min = 3, max = 20)
    private String version;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;

    public Language() {}

    public Language(String name, String creator, String version, Long id) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.version = version;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

   

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}