import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { AdminRoutingModule } from './admin-routing.module';
import { NewsComponent } from './news/news.component';
import { NewsEditComponent } from './news-edit/news-edit.component';

import { NewsCreateComponent } from './news-create/news-create.component';
import { NewsServiceService } from '../services/news-service.service';
import { AnnouncementServiceService } from '../services/announcement-service.service';
import { AnnouncementComponent } from './announcement/announcement.component';
import { AnnouncementCreateComponent } from './announcement-create/announcement-create.component';
import { AnnouncementEditComponent } from './announcement-edit/announcement-edit.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [AdminComponent,NewsComponent,NewsEditComponent,NewsCreateComponent, AnnouncementComponent, AnnouncementCreateComponent, AnnouncementEditComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,

  ]
  ,providers: [NewsServiceService,AnnouncementServiceService],

})
export class AdminModule { }
