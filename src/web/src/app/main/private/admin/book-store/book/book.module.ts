import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookComponent } from './book.component';
import {BookRoutingModule} from './book-routing.module';
import {ReactiveFormsModule} from '@angular/forms';



@NgModule({
  declarations: [BookComponent],
  imports: [
    CommonModule,
    BookRoutingModule,
    ReactiveFormsModule
  ]
})
export class BookModule { }
