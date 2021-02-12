package com.dernekapp.service;

import com.dernekapp.dto.NewsDto;
import com.dernekapp.entity.News;

import java.util.List;

public interface NewsService {

    boolean save(NewsDto news);
    NewsDto getById(Long id);
    NewsDto update(Long id,NewsDto newsDto);
    boolean delete(Long id);
    List<NewsDto> getAll();

}
