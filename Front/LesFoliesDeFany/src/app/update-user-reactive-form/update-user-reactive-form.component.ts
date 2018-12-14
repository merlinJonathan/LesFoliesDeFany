import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MyUser } from '../my-user';

@Component({
  selector: 'app-update-user-reactive-form',
  templateUrl: './update-user-reactive-form.component.html',
  styleUrls: ['./update-user-reactive-form.component.css']
})

export class UpdateUserReactiveFormComponent implements OnInit {
  userForm = this.fb.group({
    login: ['', Validators.required],
		nom: ['', Validators.required],
		prenom: ['', Validators.required],
		email: ['', [Validators.required, Validators.email]],
		adresse: ['', Validators.required],
		ville: ['', Validators.required],
		codePostal: ['', Validators.compose([Validators.minLength(5),Validators.maxLength(5), Validators.required, Validators.pattern('[0-9]{5}$')])],
		numTel: ['', Validators.maxLength(10)]
  });
  
 
  id: number;
  loginAffichage: string;

  constructor(private router: Router, private fb: FormBuilder, private serviceUser: UserService, private activatedRoute: ActivatedRoute) { 
    
  }

  ngOnInit() {
    this.id = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));

    this.serviceUser.getUser(this.id).subscribe(u => {
      // je suis le bon user
      this.userForm.setValue({
          login: u.login,
          nom: u.nom,
          prenom: u.prenom,
          email: u.email,
          adresse: u.adresse,
          ville: u.ville,
          codePostal: u.codePostal, 
           numTel: u.numTel
        }) ;
              
      this.loginAffichage = u.login;
    });
  }

  onSubmit()
  {
    let leRole = "ROLE_USER";
    let user = new MyUser(this.userForm.value.login, '', leRole, this.userForm.value.nom
      , this.userForm.value.prenom, this.userForm.value.email, this.userForm.value.adresse, this.userForm.value.ville
      , this.userForm.value.codePostal, this.userForm.value.numTel);
    user.id = this.id;
   
        localStorage.setItem("loginVK", user.login  );
        localStorage.setItem("passwordVK", user.password );
        localStorage.setItem("roleVK", user.role);
        this.serviceUser.updateUser(user);
      
  }
}

