import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginService } from "./login.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private login:LoginService){}
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        // add jwt token which is stored in local storage into request
        let authrequest = req;
        const token =this.login.getToken();
        console.log("inside interceptor");
        
        if(token != null){
            authrequest = authrequest.clone({setHeaders:{Authorization: `Bearer ${token}`},
        });
        }
        return next.handle(authrequest); 
    }
}

export const authInterceptorProviders = [
    {
        provide: HTTP_INTERCEPTORS,
        useClass: AuthInterceptor,
        multi:true,
    },
];