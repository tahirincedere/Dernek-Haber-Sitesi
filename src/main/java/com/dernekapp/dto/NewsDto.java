package com.dernekapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsDto {

    private long id;

    @NotNull(message = "subject is not null")
    @Size(min = 5)
     private String subject;

    @NotNull(message = "Details is not null")
    @Size(min = 20)
    private String details;

    @NotNull(message = "Please you select a date")
    private Date validityDate;

      @NotNull(message = "Link is not null")
      @Size(min = 10)
      private String link;


}
