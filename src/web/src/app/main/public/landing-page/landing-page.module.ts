import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LandingPageComponent } from './landing-page.component';
import {LandingPageRoutingModule} from './landing-page-routing.module';
import { BookDetailsComponent } from './book-details/book-details.component';



@NgModule({
  declarations: [LandingPageComponent, BookDetailsComponent],
  imports: [
    CommonModule,
    LandingPageRoutingModule
  ]
})
export class LandingPageModule { }
