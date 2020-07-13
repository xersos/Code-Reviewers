import { APP_INITIALIZER, Injector, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Router } from '@angular/router';
import { ServiceWorkerModule } from '@angular/service-worker';
import { catchError } from 'rxjs/operators';

import { LoadingBarModule } from '@ngx-loading-bar/core';
import { ToastrModule } from 'ngx-toastr';

import { environment } from './../environments/environment';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { UserService } from './shared/services/user.service';
import { SharedModule } from './shared/shared.module';

export function loadInitialData(injector: Injector, userService: UserService) {
    return () => userService.loadAndGetCurrentUser()
        .pipe(
            catchError(() => {
              return injector.get(Router).navigate(['/forbidden']);
            })
        )
        .toPromise();
}

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ForbiddenComponent,
    NotFoundComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    SharedModule.forRoot(),
    ToastrModule.forRoot({
      timeOut: 8000
    }),
    LoadingBarModule,
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production })
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: loadInitialData,
      deps: [Injector, UserService],
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
