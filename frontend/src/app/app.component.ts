import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'frontend';

  currentLanguage: string;
  languageList = [
    { code: 'en', name: 'English'},
    { code: 'de', name: 'German'},
    { code: 'fr', name: 'Français'},
  ];
  constructor() {}

  ngOnInit(): void {
    this.currentLanguage = this.languageList.find(p => p.code).name;
  }

  changeLanguage(language: string): void {
    window.location.search = '?lang=' + language;
  }
}
