import {NgModule} from '@angular/core';
import {BookService} from './service/book.service';
import {ApiService} from './service/api.service';
import {CategoryService} from './service/category.service';

@NgModule({
  providers: [
    BookService,
    ApiService,
    CategoryService
  ]
})
export  class SharedModule{
}
