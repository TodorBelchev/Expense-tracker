import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment.development';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TestMessageService {
  constructor(private httpClient: HttpClient) {}

  getTestMessage() {
    return this.httpClient.get<{ title: string; description: string }>(
      `${environment.url}/test-message`
    );
  }
}
