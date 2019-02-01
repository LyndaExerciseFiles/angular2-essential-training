import { Component, Inject, Output, EventEmitter } from "@angular/core";
import { FormBuilder } from "@angular/forms";
import { lookupListToken } from "./providers";
import * as _ from "lodash";

@Component({
  selector: "mw-toolbar",
  templateUrl : "./media-item-toolbar.component.html",
  styleUrls: ["./media-item-form.component.css"]
})
export class MediaItemToolbarComponent{
    constructor(private formBuilder: FormBuilder, @Inject(lookupListToken) public lookupLists) {}
    form;
    category;
    @Output() filter = new EventEmitter();

    ngOnInit() {
        this.form = this.formBuilder.group({
            movieName : this.formBuilder.control(""),
            category : this.formBuilder.control("name")
        });
        this.category = "name";
    }

    onChangeProperty(value) {
        this.category = value
    }

    getPropertyType() {
        let category = this.category ? this.category : "name";
        let lookup = _.find(this.lookupLists.mediaItemProperties , function(obj:any){
            return obj.lookupText === category;
        });
        
        return lookup.type;
    }

    filterMediaItem(formInput) {
        this.filter.emit(formInput);
    }
}