import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CategoryService} from '../../../../../shared/service/category.service';
import {Category} from '../../../../../models/category';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories: Category[] = [];

  constructor(
    private router: Router,
    private categoryService: CategoryService
  ) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit(): void {
    this.getAllCategories();
  }
  goTo(link: string): void {
    this.router.navigateByUrl(link, {skipLocationChange: true});
  }

  getAllCategories(): void {
    this.categoryService.getAll().subscribe(data => {
      console.log(data);
      this.categories = data;
    });
  }

  deleteCategory(id: number): void {
    this.categoryService.delete(id).subscribe(value => {
      this.getAllCategories();
    });
  }



  updateCategory(category: Category): void {
    this.router.navigate(['private/admin/book-store/category/add'], {state: category});
  }
}
