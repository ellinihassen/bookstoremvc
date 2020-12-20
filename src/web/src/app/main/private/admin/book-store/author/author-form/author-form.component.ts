import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthorService} from '../author.service';
import {Author} from '../../../../../../models/author';

@Component({
  selector: 'app-author-form',
  templateUrl: './author-form.component.html',
  styleUrls: ['./author-form.component.css']
})
export class AuthorFormComponent implements OnInit {
  authorForm: FormGroup = new FormGroup({});
  author: Author = new Author();

  constructor(public fb: FormBuilder,
              private router: Router,
              private authorService: AuthorService
  ) {
  }

  ngOnInit(): void {
    this.author = history.state;
    this.authorForm = this.fb.group({
      name: this.fb.control([this.author ? this.author.name : '']),
      lastName: this.fb.control([this.author ? this.author.lastName : '']),
      email: this.fb.control([this.author ? this.author.email : ''])
    });
  }

  goTo(link: string): void {
    this.router.navigateByUrl(link, {skipLocationChange: true});
  }

  addAuthor(): void {
    if (this.author && this.author.id) {
      this.author = {...this.author, ...this.authorForm.value};
      this.authorService.update(this.author).subscribe(res => {
        console.log(res);
        this.router.navigateByUrl('private/admin/book-store/author');
      });
    } else {
      this.authorService.create(this.authorForm.value).subscribe(res => {
        console.log(res);
        this.router.navigateByUrl('private/admin/book-store/author');
      });
    }
  }
}
