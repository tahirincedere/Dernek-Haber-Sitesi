import { Component, OnInit } from '@angular/core';
import { AnnouncementPayload } from 'src/app/model/Announcement';
import { AnnouncementServiceService } from 'src/app/services/announcement-service.service';

@Component({
  selector: 'app-announcement',
  templateUrl: './announcement.component.html',
  styleUrls: ['./announcement.component.css']
})
export class AnnouncementComponent implements OnInit {
 announcementList:AnnouncementPayload[];
  constructor(private announcementService:AnnouncementServiceService) { }

  getAll()
  {
    this.announcementService.getAll().subscribe(res=>{
      this.announcementList=res;
    })
  }

  delete(id:number)
  {
    this.announcementService.delete(id).subscribe(res=>{
      this.getAll();
    })
  }
  ngOnInit() {
    this.getAll();
  }

}
