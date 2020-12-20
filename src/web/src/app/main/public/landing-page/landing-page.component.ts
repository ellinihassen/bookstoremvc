import {Component, OnInit} from '@angular/core';
import {BookService} from '../../../shared/service/book.service';
import {Book} from '../../../models/book';
import {CategoryService} from '../../../shared/service/category.service';
import {Category} from '../../../models/category';
import {Router} from '@angular/router';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {
  books: Book[] = [];
  categories: Category[] = [];

  constructor(private bookService: BookService,
              private router: Router,
              private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.listBooks();
    this.listCategories();
  }

  listBooks(): void {
    this.bookService.getAll().subscribe(data => {
      this.books = data;
    });
  }

  listCategories(): void {
    this.categoryService.getAll().subscribe(data => {
      this.categories = data;
    });
  }


  showDetails(book: Book): void {
    this.router.navigate(['/public/landing-page/book-details'], {state: book});
  }

}
