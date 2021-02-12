import { Component, OnInit } from '@angular/core';
import { EventListener } from '@angular/core/src/debug/debug_node';
import { NewsPaylaod } from 'src/app/model/NewsModel';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  private newsList:NewsPaylaod[]=[];
  
  constructor(private newService:NewsServiceService) { }

 
  delete(id:number)
  {
   
    this.newService.delete(id).subscribe(res=>{
      this.getAll();
    });
    
    
  }
  getAll()
  {
    this.newService.getAll().subscribe(res=>{
      this.newsList=res;
    })
  }
  ngOnInit() {
    this.getAll();
    
  }

}
