import {Injectable} from '@angular/core';
import {ApiService} from '../../../../../shared/service/api.service';
import {Observable, pipe} from 'rxjs';
import {APIS, setIdToURL} from '../../../../../shared/constant/api';
import {Author} from '../../../../../models/author';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private apiService: ApiService) {
  }

  getAll(): Observable<Author[]> {
    return this.apiService.invoke(APIS.author.GET, {});
  }

  getById(id: number): Observable<Author> {
    return this.apiService.invoke(APIS.author.GET + '/' + id, {});
  }
  create(author: Author): Observable<Author> {
    return this.apiService.invoke(APIS.author.ADD, author);
  }
  update(author: Author): Observable<Author> {
    return this.apiService.invoke(APIS.author.UPDATE, author);
  }
  // tslint:disable-next-line:typedef
  delete(id: number) {
    return this.apiService.invoke(setIdToURL(id, APIS.author.DELETE) , {});
  }

}
