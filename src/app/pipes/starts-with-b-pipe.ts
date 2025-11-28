
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'startsWithB',
  standalone: true
})
export class StartsWithBPipe implements PipeTransform {
  transform(value: string[]): string[] {
    return Array.isArray(value) ? value.filter(str => str.toLowerCase().startsWith('b')) : [];
  }
}
