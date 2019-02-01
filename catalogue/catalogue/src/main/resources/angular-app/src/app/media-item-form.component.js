System.register(['@angular/core', '@angular/forms', './media-item.service', './providers'], function(exports_1, context_1) {
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
    var core_1, forms_1, media_item_service_1, providers_1;
    var MediaItemFormComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (forms_1_1) {
                forms_1 = forms_1_1;
            },
            function (media_item_service_1_1) {
                media_item_service_1 = media_item_service_1_1;
            },
            function (providers_1_1) {
                providers_1 = providers_1_1;
            }],
        execute: function() {
            MediaItemFormComponent = (function () {
                function MediaItemFormComponent(formBuilder, mediaItemService, lookupLists) {
                    this.formBuilder = formBuilder;
                    this.mediaItemService = mediaItemService;
                    this.lookupLists = lookupLists;
                }
                MediaItemFormComponent.prototype.ngOnInit = function () {
                    this.form = this.formBuilder.group({
                        medium: this.formBuilder.control('Movies'),
                        name: this.formBuilder.control('', forms_1.Validators.compose([
                            forms_1.Validators.required,
                            forms_1.Validators.pattern('[\\w\\-\\s\\/]+')
                        ])),
                        category: this.formBuilder.control(''),
                        year: this.formBuilder.control('', this.yearValidator),
                        movieID: this.formBuilder.control('', forms_1.Validators.compose([
                            forms_1.Validators.minLength(10),
                            forms_1.Validators.maxLength(12),
                            forms_1.Validators.pattern('[\\w\\-\\s\\/]+')
                        ])),
                        watchedOn: this.formBuilder.control('', this.watchedOnValidator),
                        rating: this.formBuilder.control('')
                    }, { validator: this.requiredIfFirstFieldFilled('watchedOn', 'rating') });
                };
                MediaItemFormComponent.prototype.yearValidator = function (control) {
                    if (control.value.trim().length === 0) {
                        return null;
                    }
                    var year = parseInt(control.value);
                    var minYear = 1800;
                    var maxYear = 2500;
                    if (year >= minYear && year <= maxYear) {
                        return null;
                    }
                    else {
                        return {
                            'year': {
                                min: minYear,
                                max: maxYear
                            }
                        };
                    }
                };
                MediaItemFormComponent.prototype.watchedOnValidator = function (control) {
                    if (new Date(control.value) > new Date()) {
                        return { 'watchedOn': true };
                    }
                    else {
                        return null;
                    }
                };
                MediaItemFormComponent.prototype.requiredIfFirstFieldFilled = function (watchedOnKey, ratingKey) {
                    return function (group) {
                        var watchedOn = group.controls[watchedOnKey];
                        var rating = group.controls[ratingKey];
                        if (watchedOn.value !== "" && rating.value === "") {
                            return {
                                'watchedOnRequired': true
                            };
                        }
                    };
                };
                MediaItemFormComponent.prototype.onSubmit = function (mediaItem) {
                    this.mediaItemService.add(mediaItem)
                        .subscribe();
                };
                MediaItemFormComponent = __decorate([
                    core_1.Component({
                        selector: 'mw-media-item-form',
                        templateUrl: 'app/media-item-form.component.html',
                        styleUrls: ['app/media-item-form.component.css']
                    }),
                    __param(2, core_1.Inject(providers_1.lookupListToken)), 
                    __metadata('design:paramtypes', [forms_1.FormBuilder, media_item_service_1.MediaItemService, Object])
                ], MediaItemFormComponent);
                return MediaItemFormComponent;
            }());
            exports_1("MediaItemFormComponent", MediaItemFormComponent);
        }
    }
});
//# sourceMappingURL=media-item-form.component.js.map