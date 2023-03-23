import { Injectable } from '@angular/core';
import {Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ShareService {

  constructor() { }
  private subject = new Subject<any>();
  private isLogged = new Subject<boolean>();

  sendClickEvent() {
    this.subject.next();
  }

  getClickEvent(): Observable<any> {
    return this.subject.asObservable();
  }
  getIsLogged(): Observable<boolean> {
    return this.isLogged.asObservable();
  }
}
