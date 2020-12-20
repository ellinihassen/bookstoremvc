import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
    providedIn: 'root'
  }
)
export class ApiService {
  private headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.headers = new HttpHeaders();
  }

  // tslint:disable-next-line:typedef
  invoke(endpoint: any, reqestData: any) {
    return new Observable<any>(observer => {
      switch (endpoint.method) {
        case 'POST' :
          this.headers.append('Content-Type', endpoint.contentType ? endpoint.contentType : 'application/json; charset=utf-8');
          this.http.post(endpoint.url, reqestData, {headers: this.headers}).subscribe((data) => {
            observer.next(data);
          });
          break;
        case 'GET' :
          this.headers.append('Content-Type', endpoint.contentType ? endpoint.contentType : 'application/json; charset=utf-8');
          this.http.get(endpoint.url, {headers: this.headers, params: reqestData}).subscribe((data) => {
            observer.next(data);
          });
          break;
        case 'PUT' :
          this.headers.append('Content-Type', endpoint.contentType ? endpoint.contentType : 'application/json; charset=utf-8');
          this.http.put(endpoint.url, reqestData, {headers: this.headers}).subscribe((data) => {
            observer.next(data);
          });
          break;
        case 'DELETE' :
          this.headers.append('Content-Type', endpoint.contentType ? endpoint.contentType : 'application/json; charset=utf-8');
          this.http.delete(endpoint.url, {headers: this.headers, params: reqestData}).subscribe((data) => {
            observer.next(data);
          });
          break;
        default:
          break;

      }

    });
  }
}
