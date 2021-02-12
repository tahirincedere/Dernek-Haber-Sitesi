package com.dernekapp.service.serviceImpl;

import com.dernekapp.dto.AnnouncementDto;
import com.dernekapp.entity.Announcement;
import com.dernekapp.exception.AnnouncementNotFoundException;
import com.dernekapp.exception.SubjectUniqueException;
import com.dernekapp.repository.AnnouncementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class AnnouncementService implements com.dernekapp.service.AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final ModelMapper modelMapper;

    public AnnouncementService(AnnouncementRepository announcementRepository, ModelMapper modelMapper)
    {
        this.announcementRepository=announcementRepository;
        this.modelMapper=modelMapper;

    }
    @Override
    public boolean save(AnnouncementDto announcementDto) {
        Announcement announcementDbUniqueSubject= this.announcementRepository.getBySubject(announcementDto.getSubject());
        if(announcementDbUniqueSubject!=null)
        {
            throw new SubjectUniqueException("the subject must unique: "+announcementDto.getSubject());
        }
      Announcement announcementDb= modelMapper.map(announcementDto,Announcement.class);
      announcementDb.setCreatedAt(new Date());
      this.announcementRepository.save(announcementDb);
      return true;

    }

    @Override
    public AnnouncementDto getById(Long id) {
        Announcement announcementDb=this.announcementRepository.findById(id)
                .orElseThrow(()->new AnnouncementNotFoundException("the announcement not found this id :"+id));
        return modelMapper.map(announcementDb,AnnouncementDto.class);
    }

    @Override
    public AnnouncementDto update(Long id, AnnouncementDto announcementDto) {

        Announcement announcementDb=this.announcementRepository.findById(id).
                orElseThrow(()->new AnnouncementNotFoundException("the announcement not found for this id :"+id));

        Announcement announcementDbUniqueSubject =  this.announcementRepository.getBySubjectAndIdNot(announcementDto.getSubject(),id);
        if(announcementDbUniqueSubject!=null)
        {
            throw new SubjectUniqueException("the subject must unique: "+announcementDto.getSubject());
        }

        announcementDb.setUpdatedAt(new Date());
        announcementDb.setValidityDate(announcementDto.getValidityDate());
        announcementDb.setSubject(announcementDto.getSubject());
        announcementDb.setDetails(announcementDto.getDetails());
        announcementDb.setFile(announcementDto.getFile());
        this.announcementRepository.save(announcementDb);
        return modelMapper.map(announcementDb,AnnouncementDto.class);
    }

    @Override
    public boolean delete(Long id) {
        Announcement announcementDb=this.announcementRepository.findById(id).
                orElseThrow(()->new AnnouncementNotFoundException("the announcement not found for this id :"+id));
        this.announcementRepository.delete(announcementDb);
        return true;
    }

    @Override
    public List<AnnouncementDto> getAll() {
        List<Announcement> announcementsDb= announcementRepository.findAll();
        List<AnnouncementDto> announcementsDto= Arrays.asList(modelMapper.map(announcementsDb,AnnouncementDto[].class));
        return announcementsDto;
    }
}
