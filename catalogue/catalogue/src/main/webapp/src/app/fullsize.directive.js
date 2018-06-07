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
    var FullSizeDirective;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            }],
        execute: function() {
            FullSizeDirective = (function () {
                function FullSizeDirective() {
                    this.isFullSize = true;
                    this.hovering = false;
                }
                FullSizeDirective.prototype.onMouseEnter = function () {
                    this.hovering = true;
                };
                FullSizeDirective.prototype.onMouseLeave = function () {
                    this.hovering = false;
                };
                Object.defineProperty(FullSizeDirective.prototype, "mwFullSize", {
                    set: function (value) {
                        this.isFullSize = value;
                    },
                    enumerable: true,
                    configurable: true
                });
                __decorate([
                    core_1.HostBinding('class.full-size'), 
                    __metadata('design:type', Object)
                ], FullSizeDirective.prototype, "isFullSize", void 0);
                __decorate([
                    core_1.HostBinding('class.full-size-hovering'), 
                    __metadata('design:type', Object)
                ], FullSizeDirective.prototype, "hovering", void 0);
                __decorate([
                    core_1.HostListener('mouseenter'), 
                    __metadata('design:type', Function), 
                    __metadata('design:paramtypes', []), 
                    __metadata('design:returntype', void 0)
                ], FullSizeDirective.prototype, "onMouseEnter", null);
                __decorate([
                    core_1.HostListener('mouseleave'), 
                    __metadata('design:type', Function), 
                    __metadata('design:paramtypes', []), 
                    __metadata('design:returntype', void 0)
                ], FullSizeDirective.prototype, "onMouseLeave", null);
                __decorate([
                    core_1.Input(), 
                    __metadata('design:type', Object), 
                    __metadata('design:paramtypes', [Object])
                ], FullSizeDirective.prototype, "mwFullSize", null);
                FullSizeDirective = __decorate([
                    core_1.Directive({
                        selector: '[mwFullSize]'
                    }), 
                    __metadata('design:paramtypes', [])
                ], FullSizeDirective);
                return FullSizeDirective;
            }());
            exports_1("FullSizeDirective", FullSizeDirective);
        }
    }
});
//# sourceMappingURL=fullsize.directive.js.map