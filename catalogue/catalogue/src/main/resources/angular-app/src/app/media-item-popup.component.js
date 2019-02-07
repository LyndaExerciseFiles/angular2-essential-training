System.register(['@angular/core', './media-item.service'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, media_item_service_1;
    var MediaItemPopupComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (media_item_service_1_1) {
                media_item_service_1 = media_item_service_1_1;
            }],
        execute: function() {
            MediaItemPopupComponent = (function () {
                function MediaItemPopupComponent(mediaItemService) {
                    this.mediaItemService = mediaItemService;
                    this.mediaItem = null;
                }
                MediaItemPopupComponent.prototype.onClose = function () {
                    this.mediaItemService.setPreview(null);
                };
                MediaItemPopupComponent.prototype.isClosed = function () {
                    return this.mediaItemService.getPreview() ? false : true;
                };
                MediaItemPopupComponent.prototype.getPosterList = function () {
                    return this.mediaItemService.getPreview() && this.mediaItemService.getPreview().posters ? this.mediaItemService.getPreview().posters : [];
                };
                MediaItemPopupComponent = __decorate([
                    core_1.Component({
                        selector: 'mw-media-item-popup',
                        templateUrl: 'app/media-item-popup.component.html',
                        styleUrls: ['app/media-item-popup.component.css']
                    }), 
                    __metadata('design:paramtypes', [media_item_service_1.MediaItemService])
                ], MediaItemPopupComponent);
                return MediaItemPopupComponent;
            }());
            exports_1("MediaItemPopupComponent", MediaItemPopupComponent);
        }
    }
});
//# sourceMappingURL=media-item-popup.component.js.map