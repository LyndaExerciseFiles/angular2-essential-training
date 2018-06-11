import { async, TestBed, ComponentFixture, inject } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import {
    RouterTestingModule
} from '@angular/router/testing';
import { Router, RouterOutlet } from "@angular/router";
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import {HttpModule} from '@angular/http';

import { routing } from './app.routing';
import { MediaItemComponent } from './media-item.component';
import { MediaItemService } from './media-item.service';
import { FavoriteDirective } from './favorite.directive';


class MockRouter { public navigate() {}; }

describe('MediaItemComponent', ()=> {
	let component: MediaItemComponent;
	let fixture: ComponentFixture<MediaItemComponent>;
	let element: HTMLElement;

	beforeEach(() => {
		TestBed.configureTestingModule({
			declarations: [ MediaItemComponent, FavoriteDirective],
			providers: [	
						MediaItemService, 
						{provide: Router,  useClass: MockRouter },
		 			 	RouterOutlet
	 	    ],
			imports: [ RouterTestingModule, 
						HttpClientModule, HttpModule ]
		})
	 
		fixture = TestBed.createComponent(MediaItemComponent);
		element = fixture.nativeElement;

	})

	it('should have 3 anchor link, with 1 having css class delete, details, preview', async(() => {
		expect(element.querySelectorAll('.preview').length).toEqual(1);
		expect(element.querySelectorAll('.details').length).toEqual(1);
		expect(element.querySelectorAll('.delete').length).toEqual(1);
	}));

})