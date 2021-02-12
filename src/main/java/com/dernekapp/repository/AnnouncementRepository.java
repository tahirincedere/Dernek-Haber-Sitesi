package com.dernekapp.repository;

import com.dernekapp.entity.Announcement;
import com.dernekapp.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
    Announcement getBySubjectAndIdNot(String subject,Long id);
    Announcement getBySubject(String subject);

}
