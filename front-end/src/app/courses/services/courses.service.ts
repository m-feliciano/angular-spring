import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, tap } from 'rxjs';
import { Course } from '../model/course';
import { API_CONFIG } from '../../../config/api.config';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  // private readonly API = "/assets/courses.json";

  private readonly API = API_CONFIG.baseUrl;

  constructor(private httpClient: HttpClient) { }

  list() {
    const url = this.API + "courses";
    return this.httpClient
      .get<Course[]>(url)
      .pipe(
        delay(2000),
        tap(courses => console.log(courses))
      );
  }
}
