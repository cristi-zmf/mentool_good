import {Component, OnInit} from '@angular/core';
import {CurrentUserService} from '../login/current-user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  private username: string;
  private role: string;
  constructor(private currentUser: CurrentUserService) {
    this.currentUser = currentUser;
    const authentifiedUser = currentUser.getCurrentUser();
    this.username = authentifiedUser.username;
    this.role = authentifiedUser.role;
  }

  ngOnInit() {
  }

}
