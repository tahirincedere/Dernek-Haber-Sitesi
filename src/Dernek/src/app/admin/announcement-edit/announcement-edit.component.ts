import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AnnouncementPayload } from 'src/app/model/Announcement';
import { AnnouncementServiceService } from 'src/app/services/announcement-service.service';

@Component({
  selector: 'app-announcement-edit',
  templateUrl: './announcement-edit.component.html',
  styleUrls: ['./announcement-edit.component.css']
})
export class AnnouncementEditComponent implements OnInit {

  private announcement:AnnouncementPayload=new AnnouncementPayload();
  private announcementForms:FormGroup;
  constructor(private formBuilder:FormBuilder,private announcementService:AnnouncementServiceService,
    private activateRouter:ActivatedRoute) { }


  getForms(id:number)
  {
    this.announcementService.getById(id).subscribe(res=>{
      this.announcement.id=res.id;
      this.announcement.subject=res.subject;
      this.announcement.file=res.file;
      this.announcement.validityDate=res.validityDate;
      this.announcement.details=res.details;
      this.setForms(this.announcement)
     
      

    })

    


  }
  update()
  {
    if(this.announcementForms.valid)
    {
     
      this.announcementService.update(this.announcement.id,this.announcementForms.value).subscribe(res=>{
        console.log(res)
      })
    }else{
      alert('Gerekli Alanları doldurunuz')
    }
  }

  setForms(announcenmentDb:AnnouncementPayload)
    {
 
      this.announcementForms=this.formBuilder.group({
        'id':[announcenmentDb.id],
        'subject':[announcenmentDb.subject,[Validators.required,Validators.minLength(5)]],
        'details':[announcenmentDb.details,[Validators.required,Validators.minLength(20)]],
        'file':[announcenmentDb.file,[Validators.required,]],
        'validityDate':[announcenmentDb.validityDate,Validators.required]
      })

    }

    f()
    {
      return this.announcementForms.controls
    }
  ngOnInit() {
    const id=+this.activateRouter.snapshot.paramMap.get('id');
    this.getForms(id);
  }

}
