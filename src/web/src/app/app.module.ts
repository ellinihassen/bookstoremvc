import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavbarComponent} from './core/layout/navbar/navbar.component';
import {FooterComponent} from './core/layout/footer/footer.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {SharedModule} from './shared/shared.module';
import {CorsInterceptor} from './utils/cors-intercepteur';
import {ShoppingCartModule} from './main/public/shopping-cart/shopping-cart.module';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    SharedModule,
    ShoppingCartModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: CorsInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
