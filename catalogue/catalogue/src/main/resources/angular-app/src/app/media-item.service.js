System.register(['@angular/core', '@angular/http', 'rxjs/add/operator/map'], function(exports_1, context_1) {
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
    var core_1, http_1;
    var Filter, MediaItemService;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (http_1_1) {
                http_1 = http_1_1;
            },
            function (_1) {}],
        execute: function() {
            Filter = (function () {
                function Filter() {
                }
                return Filter;
            }());
            exports_1("Filter", Filter);
            MediaItemService = (function () {
                function MediaItemService(http) {
                    this.http = http;
                    this.previewedMediaItem = null;
                }
                MediaItemService.prototype.isValid = function (filter) {
                    if (filter.type === "string") {
                        filter.value = filter.value.trim();
                    }
                    return filter.operator !== "" && filter.value && filter.value !== "" && filter.propertyName !== "";
                };
                MediaItemService.prototype.get = function (medium, filter) {
                    var searchParams = new http_1.URLSearchParams();
                    searchParams.append('medium', medium);
                    if (filter && this.isValid(filter)) {
                        searchParams.append('filter', JSON.stringify(filter));
                    }
                    return this.http.get('mediaitems', { search: searchParams })
                        .map(function (response) {
                        return response.json();
                    });
                };
                MediaItemService.prototype.add = function (mediaItem) {
                    var _this = this;
                    return this.http.post('mediaitems', mediaItem)
                        .map(function (response) { _this.get(""); });
                };
                MediaItemService.prototype.delete = function (mediaItem) {
                    return this.http.delete("mediaitems/" + mediaItem.id)
                        .map(function (response) { });
                };
                MediaItemService.prototype.setPreview = function (mediaItem) {
                    this.previewedMediaItem = mediaItem;
                    return this.previewedMediaItem;
                };
                MediaItemService.prototype.getPreview = function () {
                    return this.previewedMediaItem;
                };
                MediaItemService = __decorate([
                    core_1.Injectable(), 
                    __metadata('design:paramtypes', [http_1.Http])
                ], MediaItemService);
                return MediaItemService;
            }());
            exports_1("MediaItemService", MediaItemService);
        }
    }
});
//# sourceMappingURL=media-item.service.js.map