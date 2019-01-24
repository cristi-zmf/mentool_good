import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LoginComponent} from './login/login.component';
import {RouterModule} from '@angular/router';
import {MatButtonModule, MatCardModule, MatFormFieldModule, MatInputModule, MatRippleModule} from '@angular/material';
import {UserComponent} from './user/user.component';
import {FormsModule} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';


const routes = [
  { path: 'login', component: LoginComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'user', component: UserComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(
      routes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRippleModule,
    MatCardModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
