import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookStoreComponent} from './main/private/admin/book-store/book-store.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'public',
    pathMatch: 'full'
  },
  {
    path: 'private',
    loadChildren: () => import('./main/private/private.module').then(m => m.PrivateModule),

  },
  {
    path: 'public',
    loadChildren: () => import('./main/public/public.module').then(m => m.PublicModule),

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
