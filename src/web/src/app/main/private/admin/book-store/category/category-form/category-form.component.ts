import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CategoryService} from '../../../../../../shared/service/category.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Category} from '../../../../../../models/category';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {
  categoryForm: FormGroup = new FormGroup({});
  category: Category = new Category();
  constructor(public fb: FormBuilder,
              private router: Router,
              private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.category = history.state;

    this.categoryForm = this.fb.group({
      name: this.fb.control([this.category ? this.category.name : ''])
    });
  }
  goTo(link: string): void {
    this.router.navigateByUrl(link, {skipLocationChange: true});
  }

  addCategory(): void {
    if (this.category && this.category.id) {
      this.category = {...this.category, ...this.categoryForm.value};
      this.categoryService.update(this.category).subscribe(res => {
        console.log(res);
        this.router.navigateByUrl('private/admin/book-store/category');
      });
    } else {
      this.categoryService.create(this.categoryForm.value).subscribe(res => {
        console.log(res);
        this.router.navigateByUrl('private/admin/book-store/category');
      });
    }

  }


}
