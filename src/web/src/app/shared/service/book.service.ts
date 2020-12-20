import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {APIS, setIdToURL} from '../constant/api';
import {Book} from '../../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private apiService: ApiService) {
  }

  getAll(): Observable<Book[]> {
    return this.apiService.invoke(APIS.book.GET, {});
  }

  getById(id: number): Observable<Book> {
    return this.apiService.invoke(APIS.book.GET + '/' + id, {});
  }

  create(book: Book): Observable<Book> {
    return this.apiService.invoke(APIS.book.ADD, book);
  }

  update(book: Book): Observable<Book> {
    return this.apiService.invoke(APIS.book.UPDATE, book);
  }

  // tslint:disable-next-line:typedef
  delete(id: number) {
    return this.apiService.invoke(setIdToURL(id, APIS.book.DELETE), {});
  }

  calculTotalAmount(books: Book[]): Observable<any> {
    return this.apiService.invoke(APIS.book.CALCULATE_TOTAL_AMOUNT, books);
  }

}
