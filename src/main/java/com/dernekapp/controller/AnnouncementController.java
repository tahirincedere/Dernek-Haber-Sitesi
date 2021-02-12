package com.dernekapp.controller;


import com.dernekapp.dto.AnnouncementDto;
import com.dernekapp.paths.ApiPaths;
import com.dernekapp.service.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = ApiPaths.ANNOUNCEMENT_API)
public class AnnouncementController {

    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService)
    {
        this.announcementService=announcementService;
    }


    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@Valid @RequestBody AnnouncementDto announcementDto){

        return ResponseEntity.ok(this.announcementService.save(announcementDto));

    }

    @GetMapping("/{id}")
    public  ResponseEntity<AnnouncementDto> getById(@PathVariable("id") Long id){

        return ResponseEntity.ok(this.announcementService.getById(id));
    }


    @GetMapping("/all")
    public ResponseEntity<List<AnnouncementDto>> getAll(){
        return ResponseEntity.ok(this.announcementService.getAll());

    }

    @PutMapping("/{id}")
    public ResponseEntity<AnnouncementDto> update(@PathVariable("id") Long id,@Valid @RequestBody AnnouncementDto announcementDto)
    {
        return ResponseEntity.ok(this.announcementService.update(id,announcementDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id)
    {
          return ResponseEntity.ok(this.announcementService.delete(id));
    }
}
