import { Component, Inject, Output, EventEmitter } from "@angular/core";
import { FormBuilder } from "@angular/forms";
import { lookupListToken } from "./providers";
import * as _ from "lodash";

@Component({
  selector: "mw-toolbar",
  templateUrl : "app/media-item-toolbar.component.html",
  styleUrls: ["app/media-item-form.component.css"]
})
export class MediaItemToolbarComponent{
    constructor(private formBuilder: FormBuilder, @Inject(lookupListToken) public lookupLists) {}
    form;
    propertyName;
    @Output() filter = new EventEmitter();

    ngOnInit() {
        this.form = this.formBuilder.group({
            value : this.formBuilder.control(""),
            propertyName : this.formBuilder.control("name"),
            operator: this.formBuilder.control("equals"),
        });
        this.propertyName = "name";
    }

    onChangeProperty(value) {
        this.propertyName = value
    }

    getPropertyType() {
        let propertyName = this.propertyName ? this.propertyName : "name";
        let lookup = _.find(this.lookupLists.mediaItemProperties , function(obj:any){
            return obj.lookupText === propertyName;
        });
        
        return lookup.type;
    }

    filterMediaItem(formInput) {
        let type = this.getPropertyType();

        //handle number type
        if(type === "number"){
            formInput.value = parseInt(formInput.value, 10);
        }

        //insert type
        formInput.type = type;
        
        this.filter.emit(formInput);
    }
}