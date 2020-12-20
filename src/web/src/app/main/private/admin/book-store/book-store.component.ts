import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {BookService} from '../../../../shared/service/book.service';
import {Book} from '../../../../models/book';

@Component({
  selector: 'app-book-store',
  templateUrl: './book-store.component.html',
  styleUrls: ['./book-store.component.css']
})
export class BookStoreComponent implements OnInit {
  books: Book[] = [];

  constructor(private router: Router,
              private bookService: BookService) {
  }

  ngOnInit(): void {
    this.getAllBooks();
  }

  goTo(link: string): void {
    this.router.navigateByUrl(link, {skipLocationChange: true});
  }

  getAllBooks(): void {
    this.bookService.getAll().subscribe(data => {
      this.books = data;
    });
  }

  deleteBook(id: number): void {
    this.bookService.delete(id).subscribe(data => {
      this.getAllBooks();
    });
  }

  updateBook(book: Book): void {
    this.router.navigate(['private/admin/book-store/book'], {state: book});
  }
}
