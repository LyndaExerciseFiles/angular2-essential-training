System.register(['lodash'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var _;
    var ListUtilityService;
    return {
        setters:[
            function (_1) {
                _ = _1;
            }],
        execute: function() {
            ListUtilityService = (function () {
                function ListUtilityService() {
                }
                ListUtilityService.prototype.filter = function (listToSearch, propertyName, operator, value) {
                    return _.filter(listToSearch, function (obj) {
                        if (operator === "contains") {
                            return obj[propertyName].includes(value);
                        }
                        if (operator === "equals") {
                            return obj[propertyName] === value;
                        }
                        if (operator === "startswith") {
                            return obj[propertyName].startsWith(value);
                        }
                        if (operator === "lessThan") {
                            return obj[propertyName] < value;
                        }
                        if (operator === "greaterThan") {
                            return obj[propertyName] > value;
                        }
                    });
                };
                return ListUtilityService;
            }());
            exports_1("ListUtilityService", ListUtilityService);
        }
    }
});
//# sourceMappingURL=list-utility.service.js.map