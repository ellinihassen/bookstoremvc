import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LandingPageComponent} from './landing-page.component';
import {BookDetailsComponent} from './book-details/book-details.component';



const routes: Routes = [
  {
    path: '',
    component: LandingPageComponent
  },
  {
    path: 'book-details',
    component: BookDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})
export class LandingPageRoutingModule { }
