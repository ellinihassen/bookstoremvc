import {Component, OnInit} from '@angular/core';
import {Author} from '../../../../../models/author';
import {Router} from '@angular/router';
import {AuthorService} from './author.service';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  authors: Author[] = [];

  constructor(private router: Router,
              private authorService: AuthorService) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit(): void {
    this.getAllAuthors();
  }

  goTo(link: string): void {
    this.router.navigateByUrl(link, {skipLocationChange: true});
  }

  getAllAuthors(): void {
    this.authorService.getAll().subscribe(data => {
      this.authors = data;
    });
  }

  deleteAuthor(id: number): void {
    this.authorService.delete(id).subscribe(data => {
      this.getAllAuthors();
    });
  }

  updateAuthor(author: Author): void {
    this.router.navigate(['private/admin/book-store/author/add'], {state: author});
  }
}
