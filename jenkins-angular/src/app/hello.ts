import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HelloService {
  private apiUrl = 'http://localhost:8081/api/hello';

  constructor(private http: HttpClient) {}

  getMessage(): Observable<string> {
    return this.http.get(this.apiUrl, { responseType: 'text' });
  }
}
