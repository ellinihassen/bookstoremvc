import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Book} from '../../../../../models/book';
import {Router} from '@angular/router';
import {AuthorService} from '../author/author.service';
import {CategoryService} from '../../../../../shared/service/category.service';
import {Author} from '../../../../../models/author';
import {Category} from '../../../../../models/category';
import {BookService} from '../../../../../shared/service/book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  bookForm: FormGroup = new FormGroup({});
  book: Book = new Book();
  authors: Author[] = [];
  categories: Category[] = [];

  constructor(public fb: FormBuilder,
              private router: Router,
              private authorService: AuthorService,
              private categoryService: CategoryService,
              private bookService: BookService
  ) {
  }

  ngOnInit(): void {
    this.getAllAuthors();
    this.getAllCategories();
    this.book = history.state;
    this.bookForm = this.fb.group({
      title: this.fb.control([this.book ? this.book.title : '']),
      price: this.fb.control([this.book ? this.book.price : '']),
      releaseDate: this.fb.control([this.book ? this.book.releaseDate : '']),
      description: this.fb.control([this.book ? this.book.description : '']),
      photoName: this.fb.control([this.book ? this.book.photoName : '']),
      productInStock: this.fb.control([this.book ? this.book.productInStock : '']),
      author: this.fb.group({
        id: this.book ? this.book?.author?.id : ''
      }),
      category: this.fb.group({
        id: this.book ? this.book?.category?.id : ''
      })
    });
  }

  getAllCategories(): void {
    this.categoryService.getAll().subscribe(data => {
      console.log(data);
      this.categories = data;
    });
  }

  getAllAuthors(): void {
    this.authorService.getAll().subscribe(data => {
      this.authors = data;
    });
  }

  addBook(): void {
    if (this.book && this.book.id) {
      this.book = {...this.book, ...this.bookForm.value};
      this.bookService.update(this.book).subscribe(res => {
        console.log(res);
        this.router.navigateByUrl('private/admin/book-store');
      });
    } else {
      this.bookService.create(this.bookForm.value).subscribe(res => {
        console.log(res);
        this.router.navigateByUrl('private/admin/book-store');
      });
    }
  }

}
