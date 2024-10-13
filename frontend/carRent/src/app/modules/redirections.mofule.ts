
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { AuthorizedComponent } from '../components/redirections/authorized/authorized.component';
import { PageNotFoundComponentComponent } from '../components/redirections/page-not-found-component/page-not-found-component.component';


@NgModule({
  declarations: [
    AuthorizedComponent,
    PageNotFoundComponentComponent
   
  ],
  imports: [
    CommonModule,
    HttpClientModule,
  
  ],
  providers: [

  ],
  exports: [
    AuthorizedComponent,
    PageNotFoundComponentComponent
  ]
})
export class RedirectionsModule { }
``
