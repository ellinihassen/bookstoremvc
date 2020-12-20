import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookStoreComponent} from './book-store.component';



const routes: Routes = [
  {
    path: '',
    component: BookStoreComponent
  },
  {
    path: 'author',
    loadChildren: () => import('./author/author.module').then(m => m.AuthorModule)
  },
  {
    path: 'book',
    loadChildren: () => import('./book/book.module').then(m => m.BookModule)
  },
  {
    path: 'category',
    loadChildren: () => import('./category/category.module').then(m => m.CategoryModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})
export class BookStoreRoutingModule { }
