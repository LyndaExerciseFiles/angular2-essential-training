import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpModule, XHRBackend } from '@angular/http';

import { AppComponent } from './app.component';
import { MediaItemComponent } from './media-item.component';
import { MediaItemListComponent } from './media-item-list.component';
import { FavoriteDirective } from './favorite.directive';
import { CategoryListPipe } from './category-list.pipe';
import { MediaItemFormComponent } from './media-item-form.component';
import { MediaItemPopupComponent } from './media-item-popup.component';
import { PosterSwitcherComponent } from './poster-switcher.component';
import { FullSizeDirective } from './fullsize.directive';
import { MediaItemService } from './media-item.service';
import { lookupListToken, lookupLists } from './providers';
import { ListUtilityService } from './list-utility.service';
import { ApiXHRBackend } from "./ApiXHRBackend";
import { MediaItemToolbarComponent } from "./media-item-toolbar.component";
import { routing } from './app.routing';

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule,
    routing
  ],
  declarations: [
    AppComponent,
    MediaItemComponent,
    MediaItemListComponent,
    FavoriteDirective,
    CategoryListPipe,
    MediaItemFormComponent,
    MediaItemPopupComponent,
    PosterSwitcherComponent,
    FullSizeDirective,
    MediaItemToolbarComponent
  ],
  providers: [
    MediaItemService,
    ApiXHRBackend,
    ListUtilityService,
    { provide: lookupListToken, useValue: lookupLists },
    { provide: XHRBackend, useClass: ApiXHRBackend   }
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {}