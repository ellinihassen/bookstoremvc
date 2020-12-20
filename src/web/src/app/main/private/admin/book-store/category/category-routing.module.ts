import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CategoryComponent} from './category.component';
import {CategoryFormComponent} from './category-form/category-form.component';



const routes: Routes = [
  {
    path: '',
    component: CategoryComponent
  },
  {
    path: 'add',
    component: CategoryFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})
export class CategoryRoutingModule { }
