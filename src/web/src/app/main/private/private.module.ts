import {NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import {PrivateRoutingModule} from './private-routing.module';
import {BookStoreModule} from './admin/book-store/book-store.module';



@NgModule({
  imports: [
    CommonModule,
    PrivateRoutingModule,
    BookStoreModule
  ]
})
export class PrivateModule {
}
