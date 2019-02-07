import { Component, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MediaItemComponent } from './media-item.component';
import { MediaItemService } from './media-item.service';

@Component({
  selector: 'mw-media-item-list',
  templateUrl: './media-item-list.component.html',
  styleUrls: ['./media-item-list.component.css']
})
export class MediaItemListComponent {
  medium = '';
  mediaItems = [];
  paramsSubscription;
  @Output() preview = new EventEmitter();

  constructor(
    private mediaItemService: MediaItemService,
    private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.paramsSubscription = this.activatedRoute.params
      .subscribe(params => {
        let medium : string = params['medium'];
        if(medium === 'all') {
          medium = '';
        }
        this.getMediaItems(medium);
      });
  }

  ngOnDestroy() {
    this.paramsSubscription.unsubscribe();
  }

  onMediaItemDelete(mediaItem) {
    this.mediaItemService.delete(mediaItem)
      .subscribe(() => {
        this.getMediaItems(this.medium);
      });
  }
  
  getMediaItems(medium, filter?) {
    this.medium = medium;
    this.mediaItemService.get(medium, filter)
      .subscribe(mediaItems => {
        this.mediaItems = mediaItems;
      });
  }

  onMediaItemFilter(filter){
    this.getMediaItems(this.medium, filter);
  }

}
