
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customPipe',
  standalone: true,
  pure: true
})
export class CustomPipePipe implements PipeTransform {
  transform(value: string[], length: number): string[] {
    return Array.isArray(value) ? value.filter(str => str.length > length) : [];
  }
}
