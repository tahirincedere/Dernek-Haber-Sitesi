import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnnouncementComponent } from './announcement/announcement.component';
import { NewsDetailComponent } from './news/news-detail/news-detail.component';
import { NewsComponent } from './news/news.component';

const routes: Routes = [
  {path:'',redirectTo:'/news',pathMatch:'full'},
  {path:'news',component:NewsComponent},
  {path:'news/:id',component:NewsDetailComponent},
  {path:'announcement',component:AnnouncementComponent},
  {path:'admin',loadChildren:'./admin/admin.module#AdminModule'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
