import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { NewsPaylaod } from 'src/app/model/NewsModel';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-news-edit',
  templateUrl: './news-edit.component.html',
  styleUrls: ['./news-edit.component.css']
})

export class NewsEditComponent implements OnInit {

  private news:NewsPaylaod=new NewsPaylaod();
  private newsForm:FormGroup
  constructor(private activatedRouter:ActivatedRoute,private newsService:NewsServiceService
    ,private formBuilder:FormBuilder) { }

    setForm(news:NewsPaylaod)
    {

      this.newsForm=this.formBuilder.group({
        'id':[news.id],
        'subject':[news.subject,[Validators.required,Validators.minLength(5)]],
        'details':[news.details,[Validators.required,Validators.minLength(20)]],
        'link':[news.link,[Validators.required,Validators.minLength(10)]],
        'validityDate':[news.validityDate,Validators.required],

      })
    }
  getForms(id:number)
  {

    this.newsService.getById(id).subscribe(res=>{
      this.news.id=res.id
      this.news.subject=res.subject;
      this.news.details=res.details;
      this.news.link=res.link;
      this.news.validityDate=res.validityDate;
      this.setForm(this.news);

    })

  }

  f()
  {
    return this.newsForm.controls
  }
  update()
  {
    if(this.newsForm.valid)
    {
      this.newsService.update(this.news.id,this.newsForm.value).subscribe(res=>{
        alert('Güncelleme başarılı')
        console.log(res)
        this.newsForm.reset();

      });
    }else
    {
      alert('Gerekli alanları doldurunuz')
    }
  }

  ngOnInit() {
    let id =+this.activatedRouter.snapshot.paramMap.get('id');
    this.getForms(id);

  }

}
