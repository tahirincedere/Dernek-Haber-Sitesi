import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AnnouncementPayload } from '../model/Announcement';

@Injectable({
  providedIn: 'root'
})
export class AnnouncementServiceService {

  private BASE_PATH="http://localhost:8000/api/announcement";
  constructor(private http:HttpClient) { }


  
  save(news:AnnouncementPayload):Observable<boolean>
  {
    return this.http.post<boolean>(this.BASE_PATH+"/save",news);

  }

  getById(id:Number):Observable<AnnouncementPayload>
  {
    return this.http.get<AnnouncementPayload>(this.BASE_PATH+"/"+id)
  }


  getAll():Observable<AnnouncementPayload[]>
  {
    return this.http.get<AnnouncementPayload[]>(this.BASE_PATH+"/all")
  }


  update(id:Number,news:AnnouncementPayload):Observable<AnnouncementPayload>
  {
    return this.http.put<AnnouncementPayload>(this.BASE_PATH+"/"+id,news);
  }

  delete(id:Number):Observable<boolean>
  {
    return this.http.delete<boolean>(this.BASE_PATH+"/"+id);
  }
}
