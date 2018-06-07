System.register(['@angular/router', './media-item-form.component', './media-item-list.component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var router_1, media_item_form_component_1, media_item_list_component_1;
    var appRoutes, routing;
    return {
        setters:[
            function (router_1_1) {
                router_1 = router_1_1;
            },
            function (media_item_form_component_1_1) {
                media_item_form_component_1 = media_item_form_component_1_1;
            },
            function (media_item_list_component_1_1) {
                media_item_list_component_1 = media_item_list_component_1_1;
            }],
        execute: function() {
            appRoutes = [
                { path: 'add', component: media_item_form_component_1.MediaItemFormComponent },
                { path: ':medium', component: media_item_list_component_1.MediaItemListComponent },
                { path: '', pathMatch: 'full', redirectTo: 'all' }
            ];
            exports_1("routing", routing = router_1.RouterModule.forRoot(appRoutes));
        }
    }
});
//# sourceMappingURL=app.routing.js.map