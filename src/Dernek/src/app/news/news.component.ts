import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';
import { NewsPaylaod } from '../model/NewsModel';
import { NewsServiceService } from '../services/news-service.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  private modalRef:BsModalRef;
  private newsList:Array<NewsPaylaod>=[];
  constructor(private modal:BsModalService,router:Router,activateRouter:ActivatedRoute,private newsService:NewsServiceService) { }

openModal(template)
{
this.modalRef=this.modal.show(template);
}
  
  ngOnInit() {
    this.newsService.getAll().subscribe(res=>{

      this.newsList=res;
      this.newsList.forEach( res=>{
        

      })
    })
     
    
      
    

  }

}
