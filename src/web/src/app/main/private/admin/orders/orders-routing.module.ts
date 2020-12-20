import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {OrdersComponent} from './orders.component';


const routes: Routes = [
  {
    path: '',
    component: OrdersComponent
  },
  {
    path: 'client',
    loadChildren: () => import('./client/client.module').then(m => m.ClientModule)
  },
  {
    path: 'order',
    loadChildren: () => import('./order/order.module').then(m => m.OrderModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})
export class OrdersRoutingModule {
}
