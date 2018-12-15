import { Component, OnInit, HostListener } from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-menu-navigation',
  templateUrl: './menu-navigation.component.html',
  styleUrls: ['./menu-navigation.component.css']
})
export class MenuNavigationComponent implements OnInit {

  private itemsLG: MenuItem[];
  private itemsMD: MenuItem[];
  private tailleEcran: any;

  constructor() { }

  ngOnInit() { 
    this.tailleEcran = window.innerWidth;
    let obj1 = {label: 'Ajouter Utilisateur', url: '/addUser'};
    let obj2 = {label: 'Ajouter Utilisateur', url: '/addUser'};
    let obj3 = {label: 'Ajouter Utilisateur', url: '/addUser'};
    let obj4 = {label: 'Ajouter Utilisateur', url: '/addUser'};
    let obj5 = {label: 'Ajouter Utilisateur', url: '/addUser'};
    let obj6 = {label: 'Ajouter Utilisateur', url: '/addUser'};
    let obj7 = {label: 'Ajouter Utilisateur', url: '/addUser'};
    this.itemsLG = [
      obj1, obj2, obj3, obj4, obj5, obj6, obj7
     ];

      this.itemsMD = [{
        label: 'Menu', 
        items: [
          obj1, obj2, obj3, obj4, obj5, obj6, obj7
        ]
      }];
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.tailleEcran = window.innerWidth;
  }
}
