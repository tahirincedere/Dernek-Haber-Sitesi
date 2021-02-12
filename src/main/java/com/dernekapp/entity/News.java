package com.dernekapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@DiscriminatorValue("0")
@Entity
@Data
@AllArgsConstructor

public class News extends Activity{


    @Column(name = "haber_linki",length = 255)
    private String link;

    public News(){

    }
    private News(Builder builder)
    {
        this.setDetails(builder.details);
        this.setSubject(builder.subject);
        this.setValidityDate(builder.validityDate);
        this.setLink(builder.link);
    }


    public static class Builder{


        private  String subject;
        private  String details;
        private  Date validityDate;
        private String link;
        public Builder(){

        }

        public Builder setSubject(String subject){
            this.subject=subject;
            return this;

        }
        public Builder setDetails(String details){
            this.details=details;
            return this;

        }

        public Builder setValidityDate(Date validityDate){
            this.validityDate=validityDate;
            return this;

        }
        public Builder setLink(String link){
            this.link=link;
            return this;

        }

        public News build(){
            return new News(this);
        }
    }



}
