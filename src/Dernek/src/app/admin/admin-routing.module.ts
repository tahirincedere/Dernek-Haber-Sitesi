import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AnnouncementCreateComponent } from './announcement-create/announcement-create.component';
import { AnnouncementEditComponent } from './announcement-edit/announcement-edit.component';
import { AnnouncementComponent } from './announcement/announcement.component';
import { NewsCreateComponent } from './news-create/news-create.component';
import { NewsEditComponent } from './news-edit/news-edit.component';
import { NewsComponent } from './news/news.component';



const routes: Routes = [
    {path:'admin',component:AdminComponent,children:[
        {path:'news',component:NewsComponent,children:[
            {path:'create',component:NewsCreateComponent}
        ]},
        {path:'news/edit/:id',component:NewsEditComponent},
      
        
        {path:'announcement',component:AnnouncementComponent},
        {path:'announcement/create',component:AnnouncementCreateComponent},
        {path:'announcement/edit/:id',component:AnnouncementEditComponent},
    ]},
    
    
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
