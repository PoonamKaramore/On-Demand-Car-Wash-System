import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { NavbarComponent } from './navbar/navbar.component';
import { SignupComponent } from './signup/signup.component';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {HttpClientModule} from '@angular/common/http';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { CustomerDashboardComponent } from './customer/customer-dashboard/customer-dashboard.component';
import { SidebarComponent } from './admin/sidebar/sidebar.component';
import {MatListModule} from '@angular/material/list';
import {MatCardModule} from '@angular/material/card';
import { ProfileComponent } from './profile/profile.component';
import { WelcomeComponent } from './admin/welcome/welcome.component';
import { WashpacksComponent } from './admin/washpacks/washpacks.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { AddwashpacksComponent } from './admin/addwashpacks/addwashpacks.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { CustomerSidebarComponent } from './customer/customer-sidebar/customer-sidebar.component';
import { CustomerProfileComponent } from './customer/customer-profile/customer-profile.component';
import { ViewWashpacksComponent } from './customer/view-washpacks/view-washpacks.component';
import { GreetingsComponent } from './customer/greetings/greetings.component';
import {MatTableModule} from '@angular/material/table';
import { AddOrderComponent } from './customer/add-order/add-order.component';
import { ViewOrderComponent } from './customer/view-order/view-order.component';
import { AllcustomersComponent } from './admin/allcustomers/allcustomers.component';
import { WasherDashboardComponent } from './washer/washer-dashboard/washer-dashboard.component';
import { WasherSidebarComponent } from './washer/washer-sidebar/washer-sidebar.component';
import { AllwashersComponent } from './admin/allwashers/allwashers.component';
import { UpdateWashpackComponent } from './admin/update-washpack/update-washpack.component';
import {MatSelectModule} from '@angular/material/select';
import { authInterceptorProviders } from './service/auth.interceptor';
import { FlexLayoutModule } from '@angular/flex-layout';
import { AllOrdersComponent } from './washer/all-orders/all-orders.component';
import { GreetComponent } from './washer/greet/greet.component';
import { PaymentComponent } from './customer/payment/payment.component';
import { AddRatingComponent } from './customer/add-rating/add-rating.component';
import { ViewRatingComponent } from './washer/view-rating/view-rating.component';
import { WasherProfileComponent } from './washer/washer-profile/washer-profile.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    SignupComponent,
    HomeComponent,
    DashboardComponent,
    CustomerDashboardComponent,
    SidebarComponent,
    ProfileComponent,
    WelcomeComponent,
    WashpacksComponent,
    AddwashpacksComponent,
    CustomerSidebarComponent,
    CustomerProfileComponent,
    ViewWashpacksComponent,
    GreetingsComponent,
    AddOrderComponent,
    ViewOrderComponent,
    AllcustomersComponent,
    WasherDashboardComponent,
    WasherSidebarComponent,
    AllwashersComponent,
    UpdateWashpackComponent,
    AllOrdersComponent,
    GreetComponent,
    PaymentComponent,
    AddRatingComponent,
    ViewRatingComponent,
    WasherProfileComponent,
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatSnackBarModule,
    MatCheckboxModule,
    MatTableModule,
    MatSelectModule,
    FlexLayoutModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
