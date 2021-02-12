package com.dernekapp.service;

import com.dernekapp.dto.AnnouncementDto;
import java.util.List;

public interface AnnouncementService {

    boolean save(AnnouncementDto announcementDto);
    AnnouncementDto getById(Long id);
    AnnouncementDto update(Long id,AnnouncementDto announcementDto);
    boolean delete(Long id);
    List<AnnouncementDto> getAll();
}
