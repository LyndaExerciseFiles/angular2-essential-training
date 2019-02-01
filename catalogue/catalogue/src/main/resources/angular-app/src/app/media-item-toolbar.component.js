System.register(["@angular/core", "@angular/forms", "./providers", "lodash"], function(exports_1, context_1) {
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
    var __param = (this && this.__param) || function (paramIndex, decorator) {
        return function (target, key) { decorator(target, key, paramIndex); }
    };
    var core_1, forms_1, providers_1, _;
    var MediaItemToolbarComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (forms_1_1) {
                forms_1 = forms_1_1;
            },
            function (providers_1_1) {
                providers_1 = providers_1_1;
            },
            function (_1) {
                _ = _1;
            }],
        execute: function() {
            MediaItemToolbarComponent = (function () {
                function MediaItemToolbarComponent(formBuilder, lookupLists) {
                    this.formBuilder = formBuilder;
                    this.lookupLists = lookupLists;
                    this.filter = new core_1.EventEmitter();
                }
                MediaItemToolbarComponent.prototype.ngOnInit = function () {
                    this.form = this.formBuilder.group({
                        value: this.formBuilder.control(""),
                        propertyName: this.formBuilder.control("name"),
                        operator: this.formBuilder.control("equals"),
                    });
                    this.propertyName = "name";
                };
                MediaItemToolbarComponent.prototype.onChangeProperty = function (value) {
                    this.propertyName = value;
                };
                MediaItemToolbarComponent.prototype.getPropertyType = function () {
                    var propertyName = this.propertyName ? this.propertyName : "name";
                    var lookup = _.find(this.lookupLists.mediaItemProperties, function (obj) {
                        return obj.lookupText === propertyName;
                    });
                    return lookup.type;
                };
                MediaItemToolbarComponent.prototype.filterMediaItem = function (formInput) {
                    var type = this.getPropertyType();
                    //handle number type
                    if (type === "number") {
                        formInput.value = parseInt(formInput.value, 10);
                    }
                    //insert type
                    formInput.type = type;
                    this.filter.emit(formInput);
                };
                __decorate([
                    core_1.Output(), 
                    __metadata('design:type', Object)
                ], MediaItemToolbarComponent.prototype, "filter", void 0);
                MediaItemToolbarComponent = __decorate([
                    core_1.Component({
                        selector: "mw-toolbar",
                        templateUrl: "app/media-item-toolbar.component.html",
                        styleUrls: ["app/media-item-form.component.css"]
                    }),
                    __param(1, core_1.Inject(providers_1.lookupListToken)), 
                    __metadata('design:paramtypes', [forms_1.FormBuilder, Object])
                ], MediaItemToolbarComponent);
                return MediaItemToolbarComponent;
            }());
            exports_1("MediaItemToolbarComponent", MediaItemToolbarComponent);
        }
    }
});
//# sourceMappingURL=media-item-toolbar.component.js.map