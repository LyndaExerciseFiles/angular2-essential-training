import { Directive, HostBinding, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[mwFullSize]'
})
export class FullSizeDirective {
  @HostBinding('class.full-size') isFullSize = true;
  @HostBinding('class.full-size-hovering') hovering = false;

  @HostListener('mouseenter') onMouseEnter() {
    this.hovering = true;
  }
  @HostListener('mouseleave') onMouseLeave() {
    this.hovering = false;
  }

  @Input() set mwFullSize(value){
    this.isFullSize = value;
  }

}
