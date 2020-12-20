import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';



const routes: Routes = [
  {
    path: '',
    redirectTo: 'my-orders',
    pathMatch: 'full'
  },
  {
    path: 'my-orders',
    loadChildren: () => import('./my-orders/my-orders.module').then(m => m.MyOrdersModule)

  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})
export class UserRoutingModule { }
