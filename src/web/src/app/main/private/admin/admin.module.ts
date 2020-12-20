import {NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import {AdminRoutingModule} from './admin-routing.module';
import {BookStoreModule} from './book-store/book-store.module';




@NgModule({
  imports: [
    CommonModule,
   AdminRoutingModule
  ]
})
export class AdminModule {
}
