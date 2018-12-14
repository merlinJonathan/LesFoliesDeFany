import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms'
import { ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


//primeNg
import {AccordionModule} from 'primeng/accordion'; 
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ButtonModule} from 'primeng/button';
import { AddUserReactiveFormComponent } from './add-user-reactive-form/add-user-reactive-form.component';
import { UpdateUserReactiveFormComponent } from './update-user-reactive-form/update-user-reactive-form.component';
import { Routes, RouterModule } from '@angular/router';
import { DeleteUserComponent } from './delete-user/delete-user.component';


const route: Routes =
  [
    { path: 'addUser', component: AddUserReactiveFormComponent },
    { path: 'deleteUser/:id', component: DeleteUserComponent },
    { path: 'updateUser/:id', component: UpdateUserReactiveFormComponent },
  ];

@NgModule({
  declarations: [
    AppComponent,
    AddUserReactiveFormComponent,
    UpdateUserReactiveFormComponent,
    DeleteUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AccordionModule,
    BrowserAnimationsModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(route),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
