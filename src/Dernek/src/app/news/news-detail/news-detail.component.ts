import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NewsPaylaod } from 'src/app/model/NewsModel';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-news-detail',
  templateUrl: './news-detail.component.html',
  styleUrls: ['./news-detail.component.css']
})
export class NewsDetailComponent implements OnInit {
  private newsDetail:NewsPaylaod;

  constructor(private newsService:NewsServiceService,private activateRouter:ActivatedRoute) { }


  getNews(id:number){
    this.newsService.getById(id).subscribe(res=>{
      this.newsDetail=res;
      console.log(this.newsDetail)

    })
  }

  ngOnInit() {
    const id=+this.activateRouter.snapshot.paramMap.get('id');
    
    this.getNews(id);
    


  }

}
