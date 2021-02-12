import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NewsPaylaod } from '../model/NewsModel';
import { NewsServiceService } from '../services/news-service.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  private newsList:Array<NewsPaylaod>=[];
  constructor(router:Router,activateRouter:ActivatedRoute,private newsService:NewsServiceService) { }


  
  ngOnInit() {
    this.newsService.getAll().subscribe(res=>{

      this.newsList=res;
      this.newsList.forEach( res=>{
        

      })
    })
     
    
      
    

  }

}
