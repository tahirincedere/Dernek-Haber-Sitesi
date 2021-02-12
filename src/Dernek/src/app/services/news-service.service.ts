import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewsPaylaod } from '../model/NewsModel';

@Injectable({
  providedIn: 'root'
})
export class NewsServiceService {

  private BASE_PATH="http://localhost:8000/api/news";
  constructor(private http:HttpClient) { }


  save(news:NewsPaylaod):Observable<boolean>
  {
    return this.http.post<boolean>(this.BASE_PATH+"/save",news);

  }

  getById(id:Number):Observable<NewsPaylaod>
  {
    return this.http.get<NewsPaylaod>(this.BASE_PATH+"/"+id)
  }


  getAll():Observable<NewsPaylaod[]>
  {
    return this.http.get<NewsPaylaod[]>(this.BASE_PATH+"/all")
  }


  update(id:Number,news:NewsPaylaod):Observable<NewsPaylaod>
  {
    return this.http.put<NewsPaylaod>(this.BASE_PATH+"/"+id,news);
  }

  delete(id:Number):Observable<boolean>
  {
    return this.http.delete<boolean>(this.BASE_PATH+"/"+id);
  }
}
