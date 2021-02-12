import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-news-create',
  templateUrl: './news-create.component.html',
  styleUrls: ['./news-create.component.css']
})
export class NewsCreateComponent implements OnInit {

  private newsForm:FormGroup;
  constructor(private formBuilder:FormBuilder,private newsService:NewsServiceService
    ,private router:Router) { }

  setForms()
  {
    this.newsForm=this.formBuilder.group({
      'subject':[null,[Validators.required,Validators.minLength(5)]],
      'details':[null,[Validators.required,Validators.minLength(20)]],
      'link':[null,[Validators.required,Validators.minLength(10)]],
      'validityDate':[null,Validators.required],

    })

  }
  save()
  {
    if(this.newsForm.valid)
    {
      this.newsService.save(this.newsForm.value).subscribe(res=>{
        if(res)
        {
                 this.newsForm.reset();
                 this.router.navigateByUrl('/admin/news');
        }
      });
    }else
    {
      alert("Boş alanları doldurunuz")
    }
    
  }

  f()
  {
    return this.newsForm.controls;
  }
  ngOnInit() {
    this.setForms();
  }

}
