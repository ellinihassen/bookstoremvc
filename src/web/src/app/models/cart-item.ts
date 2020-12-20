import {Book} from './book';

export class CartItem {
  id: number;
  title: string;
  price: number;
  photoName: string;
  releaseDate: string;
  description: string;
  quantity: number;

  constructor(book: Book) {
    this.id = book.id;
    this.title = book.title;
    this.price = book.price;
    this.photoName = book.photoName;
    this.releaseDate = book.releaseDate;
    this.description = book.description;
    this.quantity = 1;
  }
}
