import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartStatusComponent } from './cart-status/cart-status.component';
import {CartService} from './cart.service';
import { CartDetailsComponent } from './cart-details/cart-details.component';
import {ShoppingCartRoutingModule} from './shopping-cart-routing.module';



@NgModule({
  declarations: [CartStatusComponent, CartDetailsComponent],
  exports: [
    CartStatusComponent
  ],
  imports: [
    CommonModule,
    ShoppingCartRoutingModule
  ],
  providers: [
    CartService
  ]
})
export class ShoppingCartModule { }
