import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryComponent } from './category.component';
import {CategoryRoutingModule} from './category-routing.module';
import {ReactiveFormsModule} from '@angular/forms';
import { CategoryFormComponent } from './category-form/category-form.component';



@NgModule({
  declarations: [CategoryComponent, CategoryFormComponent],
    imports: [
        CommonModule,
        CategoryRoutingModule,
        ReactiveFormsModule
    ]
})
export class CategoryModule { }
