System.register(['@angular/core'], function(exports_1, context_1) {
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
    var core_1;
    var FavoriteDirective;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            }],
        execute: function() {
            FavoriteDirective = (function () {
                function FavoriteDirective() {
                    this.isFavorite = true;
                    this.hovering = false;
                }
                FavoriteDirective.prototype.onMouseEnter = function () {
                    this.hovering = true;
                };
                FavoriteDirective.prototype.onMouseLeave = function () {
                    this.hovering = false;
                };
                Object.defineProperty(FavoriteDirective.prototype, "mwFavorite", {
                    set: function (value) {
                        this.isFavorite = value;
                    },
                    enumerable: true,
                    configurable: true
                });
                __decorate([
                    core_1.HostBinding('class.is-favorite'), 
                    __metadata('design:type', Object)
                ], FavoriteDirective.prototype, "isFavorite", void 0);
                __decorate([
                    core_1.HostBinding('class.is-favorite-hovering'), 
                    __metadata('design:type', Object)
                ], FavoriteDirective.prototype, "hovering", void 0);
                __decorate([
                    core_1.HostListener('mouseenter'), 
                    __metadata('design:type', Function), 
                    __metadata('design:paramtypes', []), 
                    __metadata('design:returntype', void 0)
                ], FavoriteDirective.prototype, "onMouseEnter", null);
                __decorate([
                    core_1.HostListener('mouseleave'), 
                    __metadata('design:type', Function), 
                    __metadata('design:paramtypes', []), 
                    __metadata('design:returntype', void 0)
                ], FavoriteDirective.prototype, "onMouseLeave", null);
                __decorate([
                    core_1.Input(), 
                    __metadata('design:type', Object), 
                    __metadata('design:paramtypes', [Object])
                ], FavoriteDirective.prototype, "mwFavorite", null);
                FavoriteDirective = __decorate([
                    core_1.Directive({
                        selector: '[mwFavorite]'
                    }), 
                    __metadata('design:paramtypes', [])
                ], FavoriteDirective);
                return FavoriteDirective;
            }());
            exports_1("FavoriteDirective", FavoriteDirective);
        }
    }
});
//# sourceMappingURL=favorite.directive.js.map