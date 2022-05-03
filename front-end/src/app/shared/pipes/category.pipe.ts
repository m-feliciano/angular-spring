import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'category'
})
export class CategoryPipe implements PipeTransform {

  transform(value: string): string {

    switch(value){
      case "Front-End": return "developer_mode";
      case "Back-End": return "computer";
      case "DevOps": return "cloud";
    }
    return "code";

  }

}
