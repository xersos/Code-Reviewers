import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, of as observableOf } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

import { environment } from '../../../environments/environment';
import { User } from '../entities/user';
import { AppService } from './app.service';

@Injectable({ providedIn: 'root'})
export class UserService extends AppService {
    private readonly apiEndpoint = environment.baseUrl + '/api/users';
    private user: User = null;

    constructor(private http: HttpClient) {
        super();
    }

    loadAndGetCurrentUser(): Observable<User> {
        return this.http
            .get<User>(this.apiEndpoint + '/data', this.noCacheParams())
            .pipe(
                tap((user: User) => this.user = user),
                catchError(this.handleError)
            );
    }

    getCurrentUser(): User {
        return this.user;
    }

    getCurrentUser$(): Observable<User> {
        if (this.user) {
          return observableOf(this.user);
        }
        else {
          return this.loadAndGetCurrentUser();
        }
    }

    updateCurrentUser(newProperties: User): Observable<User> {
        return this.http
              .post<User>(this.apiEndpoint + '/update', newProperties)
              .pipe(catchError(this.handleError));
    }


}
