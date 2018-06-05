import{ Component, Input, Output, EventEmitter } from '@angular/core';
import * as _ from "lodash";

@Component({
  selector: 'mw-poster-switcher',
  templateUrl: 'app/poster-switcher.component.html',
  styleUrls: ['app/poster-switcher.component.css']
})
export class PosterSwitcherComponent{
  @Input() posters;
  @Output() next = new EventEmitter();
  @Output() prev = new EventEmitter();
  
  onPrev() {
    var currentItem = _.find(this.posters, function(obj: any){
        return obj && obj.selected === true;
    });
    var currentIndex = this.posters.indexOf(currentItem);
    var prev = currentIndex - 1 < 0 ? this.posters.length - 1 : currentIndex - 1;

    this.posters[currentIndex].selected = false;
    this.posters[prev].selected = true;
  }

  onNext() {
    var currentItem = _.find(this.posters, function(obj: any){
        return obj.selected === true;
    });
    var currentIndex = this.posters.indexOf(currentItem);
    var next = currentIndex + 1 >= this.posters.length ? 0 : currentIndex + 1;

    this.posters[currentIndex].selected = false;
    this.posters[next].selected = true;
  }

}