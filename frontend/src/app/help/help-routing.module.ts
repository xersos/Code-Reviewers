import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { InformationComponent } from './information/information.component';

const helpRoutes: Routes = [
  {
    path: '',
    component: InformationComponent,
  }
];

@NgModule({
    imports: [RouterModule.forRoot(helpRoutes)],
    exports: [RouterModule]
})
export class HelpRoutingModule { }
