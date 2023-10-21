import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MercadoServiceService {

    url:String="http://localhost:8080";
  constructor(private http:HttpClient) { }

  obtenerDatos():Observable<any>{
    return this.http.get(this.url+"/eventos")
  }

  iniciarPago(nonce:any, precio:number):Observable<any>{
    const options = {
      params :{
        nonce :nonce,
        precio:precio
      }
    }
    return this.http.get(this.url+"/generarPreference", options)
  }
}
