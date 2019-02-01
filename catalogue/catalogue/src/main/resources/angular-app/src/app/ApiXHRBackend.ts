import { Injectable } from '@angular/core';
import {Request, XHRBackend, XHRConnection} from '@angular/http';

@Injectable()
export class ApiXHRBackend extends XHRBackend {
    createConnection(request: Request): XHRConnection {
        request.url = 'http://localhost:5005/' + request.url;     // prefix base url
        return super.createConnection(request);
    }
}
