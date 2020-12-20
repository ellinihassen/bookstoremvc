import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthorComponent} from './author.component';
import {AuthorFormComponent} from './author-form/author-form.component';


const routes: Routes = [
  {
    path: '',
    component: AuthorComponent
  },
  {
    path: 'add',
    component: AuthorFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})
export class AuthorRoutingModule {
}
