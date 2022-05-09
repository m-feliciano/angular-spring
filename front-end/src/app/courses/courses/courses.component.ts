import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';

import { Course } from '../model/course';
import { CoursesService } from '../services/courses.service';
import { ErrorDialogComponent } from '../../shared/components/error-dialog/error-dialog.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses$: Observable<Course[]>;
  displayedColumns = ["name","category", "actions"];

  constructor(
    private courseService: CoursesService,
    private dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute)
    {
    this.courses$ = this.courseService.list()
      .pipe(
        catchError(() => {
         this.onError("Error on loading courses.");
          return of([]);
        })
      )
   }

   onAdd(): void {
     this.router.navigate(['new'], {relativeTo: this.route})
   }

  ngOnInit(): void {}

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

}
