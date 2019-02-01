import { InjectionToken } from '@angular/core';

export const lookupListToken = new InjectionToken('lookupListToken');

export const lookupLists = {
  mediums: ['Movies', 'Series'],
  mediaItemProperties: [{lookupText:'All', type:'string'}, {lookupText:'Comedy', type:'string'}, {lookupText:'Science Fiction', type:'string'}, {lookupText:'Action', type:'string'}, {lookupText:'Drama', type:'string'}],
  operators: [{lookupText:'startswith', type:'string'}, {lookupText:'equals', type:'any'}, {lookupText:'contains', type:'string'}, {lookupText:'lessThan', type:'number'}, {lookupText:'greaterThan', type:'number'}]
};
