package com.example.demo.domains;

import javax.persistence.*;

@Entity
@Table(name = "ClassRoom")
public class ClassRoom {
    @Id
 //   @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "className", length = 50, nullable = false)
    private String className;

    public ClassRoom() {
    }

    public ClassRoom(String className) {
        this.className = className;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}



