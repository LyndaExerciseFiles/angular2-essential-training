System.register(['@angular/core', "lodash"], function(exports_1, context_1) {
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
    var core_1, _;
    var PosterSwitcherComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (_1) {
                _ = _1;
            }],
        execute: function() {
            PosterSwitcherComponent = (function () {
                function PosterSwitcherComponent() {
                    this.next = new core_1.EventEmitter();
                    this.prev = new core_1.EventEmitter();
                }
                PosterSwitcherComponent.prototype.onPrev = function () {
                    var currentItem = _.find(this.posters, function (obj) {
                        return obj && obj.selected === true;
                    });
                    var currentIndex = this.posters.indexOf(currentItem);
                    var prev = currentIndex - 1 < 0 ? this.posters.length - 1 : currentIndex - 1;
                    this.posters[currentIndex].selected = false;
                    this.posters[prev].selected = true;
                };
                PosterSwitcherComponent.prototype.onNext = function () {
                    var currentItem = _.find(this.posters, function (obj) {
                        return obj.selected === true;
                    });
                    var currentIndex = this.posters.indexOf(currentItem);
                    var next = currentIndex + 1 >= this.posters.length ? 0 : currentIndex + 1;
                    this.posters[currentIndex].selected = false;
                    this.posters[next].selected = true;
                };
                __decorate([
                    core_1.Input(), 
                    __metadata('design:type', Object)
                ], PosterSwitcherComponent.prototype, "posters", void 0);
                __decorate([
                    core_1.Output(), 
                    __metadata('design:type', Object)
                ], PosterSwitcherComponent.prototype, "next", void 0);
                __decorate([
                    core_1.Output(), 
                    __metadata('design:type', Object)
                ], PosterSwitcherComponent.prototype, "prev", void 0);
                PosterSwitcherComponent = __decorate([
                    core_1.Component({
                        selector: 'mw-poster-switcher',
                        templateUrl: 'app/poster-switcher.component.html',
                        styleUrls: ['app/poster-switcher.component.css']
                    }), 
                    __metadata('design:paramtypes', [])
                ], PosterSwitcherComponent);
                return PosterSwitcherComponent;
            }());
            exports_1("PosterSwitcherComponent", PosterSwitcherComponent);
        }
    }
});
//# sourceMappingURL=poster-switcher.component.js.map