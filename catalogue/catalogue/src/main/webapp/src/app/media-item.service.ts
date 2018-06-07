import { Injectable } from '@angular/core';
import { Http, URLSearchParams, Response } from '@angular/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

export class Filter{
  propertyName : string;
  operator : string;
  type: string;
  value: any;
}

@Injectable()
export class MediaItemService{
  previewedMediaItem = null;
  constructor(private http: Http) {}

  isValid(filter) {
    if(filter.type === "string"){
      filter.value = filter.value.trim();
    }
    return filter.operator !== "" && filter.value && filter.value !== "" && filter.propertyName !== "";
  }

  get(medium, filter?: Filter) : Observable<any[]> {
    let searchParams = new URLSearchParams();
    searchParams.append('medium', medium);
    if(filter && this.isValid(filter)){
      searchParams.append('filter', JSON.stringify(filter));
    }
    return this.http.get('mediaitems', { search: searchParams })
      .pipe(map(response => {
        return response.json();
      }));
  }
  
  add(mediaItem) {
    return this.http.post('mediaitems', mediaItem)
      .pipe(map(response => { this.get("") }));
  }
  
  delete(mediaItem) {
    return this.http.delete(`mediaitems/${mediaItem.id}`)
      .pipe(map(response => {}));
  }

  setPreview(mediaItem){
    this.previewedMediaItem = mediaItem;
    return this.previewedMediaItem;
  }

  getPreview(){
    return this.previewedMediaItem;
  }

}
