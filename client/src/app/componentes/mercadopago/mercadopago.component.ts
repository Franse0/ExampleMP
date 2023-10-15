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

  constructor(private mercadoService:MercadoServiceService){}  
  async ngOnInit(): Promise<void> {window.onload = async () => {
      await loadMercadoPago();
      const mp = new MercadoPago("TEST-7afb9f.....");
      const bricksBuilder = mp.bricks().create("wallet", "wallet_container", {
        initialization: {
            preferenceId: "<PREFERENCE_ID>",
        },
     });
      console.log(bricksBuilder)
      console.log("todo bien")
     
  }
  this.mercadoService.obtenerDatos().subscribe(data=>{
    this.eventos=data;
  })


}



}

    

