package com.dernekapp.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "activity_type",discriminatorType = DiscriminatorType.STRING)
@Data
public abstract class Activity extends BaseEntity{

    @Column(name = "konu",nullable =false,length = 255,unique = true)
    private String subject;

    @Column(name = "icerik",nullable =false,length = 1000)
    private String details;

    @Temporal(TemporalType.DATE)
    @Column(name = "gecerlilik_tarihi")
    private Date validityDate;
}
