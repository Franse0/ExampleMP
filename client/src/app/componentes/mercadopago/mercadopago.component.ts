import { Component, OnInit } from '@angular/core';
import { loadMercadoPago } from "@mercadopago/sdk-js";
import { MercadoServiceService } from 'src/app/servicios/mercado-service.service';

declare var MercadoPago: any;


@Component({
  selector: 'app-mercadopago',
  templateUrl: './mercadopago.component.html',
  styleUrls: ['./mercadopago.component.css']
})
export class MercadopagoComponent implements OnInit{
  eventos:any;
  nonce:any= crypto.randomUUID()
  
  constructor(private mercadoService:MercadoServiceService){}  
 
  async loadMercadoPago(){
    const script = document.createElement('script');
    script.src = 'https://sdk.mercadopago.com/js/v2/mp.js';
    script.async = true;
    script.nonce = this.nonce;
    document.head.appendChild(script);

    await new Promise<void>((resolve, reject) => {
      script.onload =()=> resolve();
      script.onerror =()=> reject();
      console.log(reject)
    });
    return MercadoPago
  }

   async ngOnInit() {
    loadMercadoPago()
  this.mercadoService.obtenerDatos().subscribe(data=>{
    console.log(data)
    this.eventos=data;
   })
}

inciarPago(precio:number){
  const mp = new MercadoPago("", {nonce:this.nonce});

  this.mercadoService.iniciarPago(this.nonce, precio).subscribe(data=>{
    const preferenceId = data.preferenceId
    console.log(precio)    
    console.log(preferenceId)    
    const bricksBuilder = mp.bricks().create("wallet", "wallet_container",{
      initialization: {
        preferenceId:preferenceId ,
    }})
  })}
}

    

