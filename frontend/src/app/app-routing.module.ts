import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';


const appRoutes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'help',
    loadChildren: () => import('./help/help.module').then(m => m.HelpModule),
  },
  {
    path: 'forbidden',
    component: ForbiddenComponent,
    pathMatch: 'full',
  },
  {
    path: '**',
    component: NotFoundComponent,
  }
];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
