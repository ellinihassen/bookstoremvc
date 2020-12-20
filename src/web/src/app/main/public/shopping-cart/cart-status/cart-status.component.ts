import { Component, OnInit } from '@angular/core';
import {CartService} from '../cart.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cart-status',
  templateUrl: './cart-status.component.html',
  styleUrls: ['./cart-status.component.css']
})
export class CartStatusComponent implements OnInit {

  totalPrice: number = 0.00;
  totalQuantity: number = 0;

  constructor(private cartService: CartService, private router: Router) { }

  ngOnInit(): void {
    this.updateCartStatus();
  }

  updateCartStatus() {
    this.cartService.totalPrice.subscribe(
      data => this.totalPrice += data
    );
    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity += data
    );
  }

  goTo(link: string): void {
    this.router.navigateByUrl(link, {skipLocationChange: true});
  }
}
