import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {Book} from '../../../models/book';
import {BookService} from '../../../shared/service/book.service';

@Injectable()
export class CartService {
  books: Book[] = [];
  totalPrice: Subject<number> = new Subject<number>();
  totalQuantity: Subject<number> = new Subject<number>();
  totalPriceValue = 0;

  constructor(private bookService: BookService) {
  }

  addToCart(books: Book[]): void {
    // check if the item already in our cart
    this.books = books;

    this.computeCartTotals();
  }

  computeCartTotals(): void {
    this.bookService.calculTotalAmount(this.books).subscribe(
      data => {
        this.totalPriceValue = data;
        this.totalPrice.next(this.totalPriceValue);
        this.totalQuantity.next(this.books.length);

      }
    );

  }

}
