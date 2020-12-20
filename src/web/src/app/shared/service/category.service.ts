import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {APIS, setIdToURL} from '../constant/api';
import {Category} from '../../models/category';

@Injectable()
export class CategoryService {

  constructor(private apiService: ApiService) {
  }

  getAll(): Observable<Category[]> {
    return this.apiService.invoke(APIS.category.GET, {});
  }

  getById(id: number): Observable<Category> {
    return this.apiService.invoke(APIS.category.GET + '/' + id, {});
  }

  create(category: Category): Observable<Category> {
    return this.apiService.invoke(APIS.category.ADD, category);
  }

  update(category: Category): Observable<Category> {
    return this.apiService.invoke(APIS.category.UPDATE, category);
  }


  delete(id: number): Observable<any> {

    return this.apiService.invoke(setIdToURL(id, APIS.category.DELETE), {});
  }
}
