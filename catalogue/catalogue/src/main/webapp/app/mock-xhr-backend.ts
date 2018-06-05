import { Http, Request, Response, ResponseOptions, RequestMethod } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Observer } from 'rxjs/Observer';
import { ListUtilityService } from "./list-utility.service";

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
export class MediaItemService extends ListUtilityService {
  constructor(private http:Http) {
    super();
  }

  getMediaItems() : Observable<Comment[]> {
     // ...using get request
     var mediaItemUrl = "http:localhost:8080/mediaitems";
     return this.http.get(mediaItemUrl)
    // ...and calling .json() on the response to return data
     .map((res:Response) => res.json())
     //...errors if any
     .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
 }

  createConnection(request: Request) {
    var response = new Observable((responseObserver: Observer<Response>) => {
      var responseData;
      var responseOptions;
      switch (request.method) {
        case RequestMethod.Get:
          if (request.url.indexOf('mediaitems?medium=') >= 0 || request.url.indexOf('mediaitems?filter=') >= 0 || request.url === 'mediaitems') {
            var filter, medium;
            medium = new RegExp('[\\?&]medium=([^&#]*)').exec(request.url);
            filter = new RegExp('[\\?&]filter=([^&#]*)').exec(request.url);
            var mediaItems;
            if (medium && medium[1] !== "" && filter) {
              filter = JSON.parse(decodeURIComponent(filter[1]));
              mediaItems = this.filter(this._mediaItems.filter(mediaItem => mediaItem.medium === medium[1]), filter.propertyName, filter.operator, filter.value);
            } else if (medium && medium[1] !== "") {
              mediaItems = this._mediaItems.filter(mediaItem => mediaItem.medium === medium[1]);
            }else if (filter) {
              filter = JSON.parse(decodeURIComponent(filter[1]));
              mediaItems = this.filter(this._mediaItems, filter.propertyName, filter.operator, filter.value);
            } else {
              mediaItems = this._mediaItems;
            }
            responseOptions = new ResponseOptions({
              body: { mediaItems: JSON.parse(JSON.stringify(mediaItems)) },
              status: 200
            });
          } else {
            var id = parseInt(request.url.split('/')[1]);
            mediaItems = this._mediaItems.filter(mediaItem => mediaItem.id === id);
            responseOptions = new ResponseOptions({
              body: JSON.parse(JSON.stringify(mediaItems[0])),
              status: 200
            });


          }
          break;
        case RequestMethod.Post:
          var mediaItem = JSON.parse(request.text().toString());
          mediaItem.id = this._getNewId();
          this._mediaItems.push(mediaItem);
          responseOptions = new ResponseOptions({ status: 201 });
          break;
        case RequestMethod.Delete:
          var id = parseInt(request.url.split('/')[1]);
          this._deleteMediaItem(id);
          responseOptions = new ResponseOptions({ status: 200 });
      }

      var responseObject = new Response(responseOptions);
      responseObserver.next(responseObject);
      responseObserver.complete();
      return () => { };
    });
    return { response };
  }

  _deleteMediaItem(id) {
    var mediaItem = this._mediaItems.find(mediaItem => mediaItem.id === id);
    var index = this._mediaItems.indexOf(mediaItem);
    if (index >= 0) {
      this._mediaItems.splice(index, 1);
    }
  }

  _getNewId() {
    if (this._mediaItems.length > 0) {
      return Math.max.apply(Math, this._mediaItems.map(mediaItem => mediaItem.id)) + 1;
    }
  }

  _mediaItems = [
    {
      id: 1,
      name: "Firebug",
      medium: "Series",
      category: "Science Fiction",
      year: 2010,
      rating: 2,
      watchedOn: 1294166565384,
      movieID: 'A1234567890',
      isFavorite: false,
      posters: [
        {imgSrc: './media/firebug1.png', selected: true, isAvailableFullSize : true},
        {imgSrc: './media/firebug2.png', selected: false, isAvailableFullSize : false}
      ]
    },
    {
      id: 2,
      name: "The Small Tall",
      medium: "Movies",
      category: "Comedy",
      year: 2015,
      rating: 3.5,
      watchedOn: null,
      movieID: 'A1234567891',
      isFavorite: true,
      posters: [
        {imgSrc: './media/smalltall1.png', selected: true, isAvailableFullSize : true},
        {imgSrc: './media/smalltall2.png', selected: false, isAvailableFullSize : true}
      ]
    }, {
      id: 3,
      name: "The Redemption",
      medium: "Movies",
      category: "Action",
      year: 2016,
      rating: 4.7,
      watchedOn: null,
      movieID: 'A1234567892',
      isFavorite: false,
      imgSrc : null
    }, {
      id: 4,
      name: "Hoopers",
      medium: "Series",
      category: "Drama",
      year: null,
      rating: 3.2,
      watchedOn: null,
      movieID: 'A1234567893',
      isFavorite: true,
      imgSrc : null
    }, {
      id: 5,
      name: "Happy Joe: Cheery Road",
      medium: "Movies",
      category: "Action",
      year: 2015,
      rating: 2.7,
      watchedOn: 1457166565384,
      movieID: 'A1234567894',
      isFavorite: false,
      imgSrc : null
    }
  ];
}