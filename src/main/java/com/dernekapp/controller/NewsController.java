package com.dernekapp.controller;

import com.dernekapp.dto.NewsDto;
import com.dernekapp.entity.News;
import com.dernekapp.paths.ApiPaths;
import com.dernekapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = ApiPaths.NEWS_API)
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService  newsService){
        this.newsService=newsService;

    }
    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@Valid @RequestBody NewsDto news){

        return ResponseEntity.ok(this.newsService.save(news));

    }

    @GetMapping("/{id}")
    public  ResponseEntity<NewsDto> getById(@PathVariable("id") Long id){

        return new ResponseEntity(this.newsService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<NewsDto>> getAll(){
       return ResponseEntity.ok(this.newsService.getAll());

    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDto> update(@PathVariable("id") Long id,@Valid @RequestBody NewsDto newsDto)
    {
        return ResponseEntity.ok(this.newsService.update(id,newsDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id)
    {
        return ResponseEntity.ok(this.newsService.delete(id));
    }
}
