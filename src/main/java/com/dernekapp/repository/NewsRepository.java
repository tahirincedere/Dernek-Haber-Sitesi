package com.dernekapp.repository;

import com.dernekapp.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Long> {

    News getBySubjectAndIdNot(String subject,Long id);
    News getBySubject(String subject);
}
