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
  private readonly courseUrl = this.API + "courses";

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient
      .get<Course[]>(this.courseUrl)
      .pipe(
        delay(2000),
        tap(courses => console.log(courses))
      );
  }

  save(record: Course) {
    const obj = {
      name: record.name,
      category: {
        name: record.category
      }
    }
    console.log(obj);
    return this.httpClient.post<Course>(this.courseUrl, obj);
  }
}
