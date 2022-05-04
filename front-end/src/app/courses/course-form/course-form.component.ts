import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CoursesService } from '../services/courses.service';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {

  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: CoursesService,
    private snackBar: MatSnackBar,
    private location: Location
  ) {
    this.form = this.formBuilder.group({
      name: [null],
      category: [null]
    })
  }

  onSubmit(): void {
    this.service
      .save(this.form.value)
      .subscribe(result => this.onSuccess(), () => this.onError())
  }

  onSuccess() {
    this.snackBar.open('Course saved successfully.', '', { duration: 5000 });
    this.onCancel();
  }

  onCancel(): void {
    return this.location.back();
   }

  ngOnInit(): void { }

  private onError(){
    return this.snackBar.open('Error saving course.', '', { duration: 5000 });
  }

}

