import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthentifiedUser} from './authentified-user';
import {LoginRequest} from './login-request';
import {CurrentUserService} from './current-user.service';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private router: Router, private http: HttpClient) {
    this.http = http;
    this.router = router;
  }

  login (username: string, password: string): void {
    this.http.post('http://localhost:8080/token/generate-token', new LoginRequest(username, password))
      .subscribe(
        (authentifiedUser: AuthentifiedUser) => {
          localStorage.setItem(CurrentUserService.CURRENT_USER, JSON.stringify(authentifiedUser));
          this.router.navigate(['user']);
        }
      );
  }
}
