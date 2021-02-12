import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AnnouncementServiceService } from 'src/app/services/announcement-service.service';

@Component({
  selector: 'app-announcement-create',
  templateUrl: './announcement-create.component.html',
  styleUrls: ['./announcement-create.component.css']
})
export class AnnouncementCreateComponent implements OnInit {

  private forms:FormGroup;
  constructor(private announcementService:AnnouncementServiceService,private formBuilder:FormBuilder) { }

  setForms(){
    this.forms=this.formBuilder.group({
      'subject':[null,[Validators.required,Validators.minLength(5)]],
      'details':[null,[Validators.required,Validators.minLength(20)]],
      'file':[null,[Validators.required,Validators.minLength(10)]],
      'validityDate':[null,[Validators.required]]

    })
  }

  save()
  {
    if(this.forms.valid)
    {
      this.announcementService.save(this.forms.value).subscribe(res=>{
    
        if(res) 
        {
          this.forms.reset();
          alert('Başarılı')
        }
      })
    }else
    {
      alert("Gerekli Alanları doldurunuz");
    }
  
  }
  f(){
   
    return this.forms.controls;
  }
  ngOnInit() {
    this.setForms();
    
  }

}
