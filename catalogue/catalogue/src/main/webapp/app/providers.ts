import { OpaqueToken } from '@angular/core';

export const lookupListToken = new OpaqueToken('lookupListToken');

export const lookupLists = {
  mediums: ['Movies', 'Series'],
  mediaItemProperties: [{lookupText:'name', type:'string'}, {lookupText:'category', type:'string'}, {lookupText:'year', type:'number'}],
  operators: [{lookupText:'startswith', type:'string'}, {lookupText:'equals', type:'any'}, {lookupText:'contains', type:'string'}, {lookupText:'lessThan', type:'number'}, {lookupText:'greaterThan', type:'number'}]
};