System.register(['@angular/core'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var core_1;
    var lookupListToken, lookupLists;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            }],
        execute: function() {
            exports_1("lookupListToken", lookupListToken = new core_1.OpaqueToken('lookupListToken'));
            exports_1("lookupLists", lookupLists = {
                mediums: ['Movies', 'Series'],
                mediaItemProperties: [{ lookupText: 'name', type: 'string' }, { lookupText: 'category', type: 'string' }, { lookupText: 'year', type: 'number' }],
                operators: [{ lookupText: 'startswith', type: 'string' }, { lookupText: 'equals', type: 'any' }, { lookupText: 'contains', type: 'string' }, { lookupText: 'lessThan', type: 'number' }, { lookupText: 'greaterThan', type: 'number' }]
            });
        }
    }
});
//# sourceMappingURL=providers.js.map