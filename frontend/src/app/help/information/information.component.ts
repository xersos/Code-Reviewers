import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-information',
  templateUrl: './information.component.html',
  styleUrls: ['./information.component.scss']
})
export class InformationComponent implements OnInit {
    version = environment.version;

    constructor(private _titleService: Title) { }

  ngOnInit(): void {
      this._titleService.setTitle('Information - CodeReviewers');
  }

}
