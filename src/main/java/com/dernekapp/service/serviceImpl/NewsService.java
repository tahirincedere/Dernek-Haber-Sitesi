package com.dernekapp.service.serviceImpl;

import com.dernekapp.dto.NewsDto;
import com.dernekapp.entity.News;
import com.dernekapp.exception.NewsNotFoundException;
import com.dernekapp.exception.SubjectUniqueException;
import com.dernekapp.repository.NewsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class NewsService implements com.dernekapp.service.NewsService {


    private final NewsRepository newsRepository;
    private final ModelMapper modelMapper;


    public NewsService(NewsRepository newsRepository, ModelMapper modelMapper) {
        this.newsRepository = newsRepository;
        this.modelMapper=modelMapper;
    }


    @Override
    public boolean save(NewsDto newsDto) {
        News newsDbUniqueSubject =  this.newsRepository.getBySubject(newsDto.getSubject());
        if(newsDbUniqueSubject!=null)
        {
            throw new SubjectUniqueException("the subject must unique: "+newsDto.getSubject());
        }
        News newsDb=new News.Builder().setLink(newsDto.getLink())
                .setDetails(newsDto.getDetails()).setSubject(newsDto.getSubject())
                .setValidityDate(newsDto.getValidityDate()).build();
        newsDb.setCreatedAt(new Date());
        newsRepository.save(newsDb);
        return true;

    }

    @Override
    public NewsDto getById(Long id) {
       News newsDb= newsRepository.findById(id).
               orElseThrow(()->new NewsNotFoundException("the news not found for this id :"+id));
       return modelMapper.map(newsDb,NewsDto.class);
    }

    @Override
    public NewsDto update(Long id, NewsDto newsDto) {


        News newsDb=this.newsRepository.findById(id).
                orElseThrow(()->new NewsNotFoundException("the news not found for this id :"+id));

      News newsDbUniqueSubject =  this.newsRepository.getBySubjectAndIdNot(newsDto.getSubject(),id);
      if(newsDbUniqueSubject!=null)
      {
          throw new SubjectUniqueException("the subject must unique: "+newsDto.getSubject());
      }


        newsDb.setValidityDate(newsDto.getValidityDate());
        newsDb.setSubject(newsDto.getSubject());
        newsDb.setDetails(newsDto.getDetails());
        newsDb.setLink(newsDto.getLink());
        newsDb.setUpdatedAt(new Date());
        this.newsRepository.save(newsDb);
        return modelMapper.map(newsDb,NewsDto.class);
    }

    @Override
    public boolean delete(Long id) {
       News news=newsRepository.findById(id).
               orElseThrow(()->new NewsNotFoundException("the news not found for this id :"+id));
       newsRepository.delete(news);
       return true;
    }

    @Override
    public List<NewsDto> getAll() {
      List<News> newsDb= newsRepository.findAll();
      List<NewsDto>newsDto= Arrays.asList(modelMapper.map(newsDb,NewsDto[].class));
      return newsDto;
    }
}
