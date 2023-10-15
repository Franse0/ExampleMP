import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MercadopagoComponent } from './componentes/mercadopago/mercadopago.component';

const routes: Routes = [
  // {path:"/mercadopago", component:MercadopagoComponent},
  // {path:"**",redirectTo:"/mercadopago", pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
