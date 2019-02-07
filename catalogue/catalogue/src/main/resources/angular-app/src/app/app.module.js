System.register(['@angular/core', '@angular/platform-browser', '@angular/forms', '@angular/http', './app.component', './media-item.component', './media-item-list.component', './favorite.directive', './category-list.pipe', './media-item-form.component', './media-item-popup.component', './poster-switcher.component', './fullsize.directive', './media-item.service', './providers', './list-utility.service', "./ApiXHRBackend", "./media-item-toolbar.component", './app.routing'], function(exports_1, context_1) {
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
    var core_1, platform_browser_1, forms_1, http_1, app_component_1, media_item_component_1, media_item_list_component_1, favorite_directive_1, category_list_pipe_1, media_item_form_component_1, media_item_popup_component_1, poster_switcher_component_1, fullsize_directive_1, media_item_service_1, providers_1, list_utility_service_1, ApiXHRBackend_1, media_item_toolbar_component_1, app_routing_1;
    var AppModule;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (platform_browser_1_1) {
                platform_browser_1 = platform_browser_1_1;
            },
            function (forms_1_1) {
                forms_1 = forms_1_1;
            },
            function (http_1_1) {
                http_1 = http_1_1;
            },
            function (app_component_1_1) {
                app_component_1 = app_component_1_1;
            },
            function (media_item_component_1_1) {
                media_item_component_1 = media_item_component_1_1;
            },
            function (media_item_list_component_1_1) {
                media_item_list_component_1 = media_item_list_component_1_1;
            },
            function (favorite_directive_1_1) {
                favorite_directive_1 = favorite_directive_1_1;
            },
            function (category_list_pipe_1_1) {
                category_list_pipe_1 = category_list_pipe_1_1;
            },
            function (media_item_form_component_1_1) {
                media_item_form_component_1 = media_item_form_component_1_1;
            },
            function (media_item_popup_component_1_1) {
                media_item_popup_component_1 = media_item_popup_component_1_1;
            },
            function (poster_switcher_component_1_1) {
                poster_switcher_component_1 = poster_switcher_component_1_1;
            },
            function (fullsize_directive_1_1) {
                fullsize_directive_1 = fullsize_directive_1_1;
            },
            function (media_item_service_1_1) {
                media_item_service_1 = media_item_service_1_1;
            },
            function (providers_1_1) {
                providers_1 = providers_1_1;
            },
            function (list_utility_service_1_1) {
                list_utility_service_1 = list_utility_service_1_1;
            },
            function (ApiXHRBackend_1_1) {
                ApiXHRBackend_1 = ApiXHRBackend_1_1;
            },
            function (media_item_toolbar_component_1_1) {
                media_item_toolbar_component_1 = media_item_toolbar_component_1_1;
            },
            function (app_routing_1_1) {
                app_routing_1 = app_routing_1_1;
            }],
        execute: function() {
            AppModule = (function () {
                function AppModule() {
                }
                AppModule = __decorate([
                    core_1.NgModule({
                        imports: [
                            platform_browser_1.BrowserModule,
                            forms_1.ReactiveFormsModule,
                            http_1.HttpModule,
                            app_routing_1.routing
                        ],
                        declarations: [
                            app_component_1.AppComponent,
                            media_item_component_1.MediaItemComponent,
                            media_item_list_component_1.MediaItemListComponent,
                            favorite_directive_1.FavoriteDirective,
                            category_list_pipe_1.CategoryListPipe,
                            media_item_form_component_1.MediaItemFormComponent,
                            media_item_popup_component_1.MediaItemPopupComponent,
                            poster_switcher_component_1.PosterSwitcherComponent,
                            fullsize_directive_1.FullSizeDirective,
                            media_item_toolbar_component_1.MediaItemToolbarComponent
                        ],
                        providers: [
                            media_item_service_1.MediaItemService,
                            ApiXHRBackend_1.ApiXHRBackend,
                            list_utility_service_1.ListUtilityService,
                            { provide: providers_1.lookupListToken, useValue: providers_1.lookupLists },
                            { provide: http_1.XHRBackend, useClass: ApiXHRBackend_1.ApiXHRBackend }
                        ],
                        bootstrap: [
                            app_component_1.AppComponent
                        ]
                    }), 
                    __metadata('design:paramtypes', [])
                ], AppModule);
                return AppModule;
            }());
            exports_1("AppModule", AppModule);
        }
    }
});
//# sourceMappingURL=app.module.js.map