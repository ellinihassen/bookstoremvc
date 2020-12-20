import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Book} from '../../../../models/book';
import {CartService} from '../../shopping-cart/cart.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {
  // @ts-ignore
  book: Book = undefined;
  quantity = 1;
  books: Book [] = [];

  constructor(private router: Router,
              private cartService: CartService) {
  }

  ngOnInit(): void {
    this.book = history.state;
    if (!this.book || !this.book.id) {
      this.router.navigate(['/public/landing-page']);
    }
  }
  goTo(link: string): void {
    this.router.navigateByUrl(link, {skipLocationChange: true});
  }
  addToCart(book: Book): void {
    console.log(`Adding To cart: ${book.title}, ${book.price}`);
    for (let i = 0; i < this.quantity; i++) {
      this.books.push(book);
    }

    this.cartService.addToCart(this.books);

  }

  update(value: any): void {
    this.quantity = value;
  }

}
