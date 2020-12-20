import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AuthorComponent} from './author.component';
import {AuthorRoutingModule} from './author-routing.module';
import { AuthorFormComponent } from './author-form/author-form.component';
import {ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [AuthorComponent, AuthorFormComponent],
    imports: [
        CommonModule,
        AuthorRoutingModule,
        ReactiveFormsModule
    ]
})
export class AuthorModule {
}
