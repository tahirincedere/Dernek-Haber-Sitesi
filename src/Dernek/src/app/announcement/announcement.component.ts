import { Component, OnInit } from '@angular/core';
import { AnnouncementPayload } from '../model/Announcement';
import { AnnouncementServiceService } from '../services/announcement-service.service';

@Component({
  selector: 'app-announcement',
  templateUrl: './announcement.component.html',
  styleUrls: ['./announcement.component.css']
})
export class AnnouncementComponent implements OnInit {
  private announcements:AnnouncementPayload[]=[];

  constructor(private announcementService:AnnouncementServiceService) { }

  getAll()
  {
    this.announcementService.getAll().subscribe(res=>{
      this.announcements=res;
      
     
      
    })
  }

  ngOnInit() {
    this.getAll();
  }

}
