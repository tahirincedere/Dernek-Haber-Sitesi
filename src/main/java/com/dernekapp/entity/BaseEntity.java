package com.dernekapp.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "created_By")
    private String createdBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_At")
    private Date createdAt;

    @Column(name = "updated_By")
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_At")
    private Date updatedAt;



}
