import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnnouncementComponent } from './announcement/announcement.component';
import { NewsComponent } from './news/news.component';
import { NavbarComponent } from './navbar/navbar.component';
import {HttpClientModule} from '@angular/common/http'
import { NewsServiceService } from './services/news-service.service';
import { AnnouncementServiceService } from './services/announcement-service.service';
import { AdminModule } from './admin/admin.module';
import { ReactiveFormsModule } from '@angular/forms';
import {ModalModule, } from "ngx-bootstrap";


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AnnouncementComponent,
    NewsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AdminModule,
    ReactiveFormsModule,
    AppRoutingModule, 
    ModalModule.forRoot()
  ],
  providers: [NewsServiceService,AnnouncementServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
