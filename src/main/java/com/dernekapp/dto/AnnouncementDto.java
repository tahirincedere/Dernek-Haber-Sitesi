package com.dernekapp.dto;

import com.dernekapp.entity.Activity;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class AnnouncementDto  {


    private long id;
    @NotNull(message = "subject is not null")
    @Size(min = 5)
    private String subject;


    @NotNull(message = "Details is not null")
    @Size(min = 20,message = "details least min 20 characters")
    private String details;



    @NotNull(message = "Please you select a date")
    private Date validityDate;

    @NotNull(message = "Please you need to load the file")
    private String file;

    private Date createdAt;
}
