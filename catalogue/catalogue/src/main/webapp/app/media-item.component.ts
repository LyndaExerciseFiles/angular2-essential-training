import { Component, Input, Output, EventEmitter } from '@angular/core';
import { MediaItemService } from './media-item.service';

@Component({
  selector: 'mw-media-item',
  templateUrl: 'app/media-item.component.html',
  styleUrls: ['app/media-item.component.css']
})
export class MediaItemComponent {
  @Input() mediaItem;
  @Output() delete = new EventEmitter();
  @Output() preview = new EventEmitter();

  constructor(private mediaItemservice: MediaItemService) {}

  onDelete() {
    this.delete.emit(this.mediaItem);
  }

  onPreview() {
    this.mediaItemservice.setPreview(this.mediaItem);
  }
}
