package com.dernekapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@DiscriminatorValue("1")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Announcement extends Activity {

    @Column(name = "resim")
    private String file;


}
