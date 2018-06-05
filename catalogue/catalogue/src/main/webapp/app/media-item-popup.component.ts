import { Component, Input, Output, EventEmitter } from '@angular/core';
import { MediaItemService } from './media-item.service';

@Component({
  selector: 'mw-media-item-popup',
  templateUrl : 'app/media-item-popup.component.html',
  styleUrls: ['app/media-item-popup.component.css']
})
export class MediaItemPopupComponent{
  mediaItem = null;
  constructor(private mediaItemService: MediaItemService) {}

  onClose() {
    this.mediaItemService.setPreview(null);
  }

  isClosed() {
    return this.mediaItemService.getPreview() ? false : true;
  }

  getPosterList() {
    return this.mediaItemService.getPreview() && this.mediaItemService.getPreview().posters ? this.mediaItemService.getPreview().posters : [];
  }
}