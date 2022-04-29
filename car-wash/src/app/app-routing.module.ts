import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddwashpacksComponent } from './admin/addwashpacks/addwashpacks.component';
import { AllcustomersComponent } from './admin/allcustomers/allcustomers.component';
import { AllwashersComponent } from './admin/allwashers/allwashers.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { UpdateWashpackComponent } from './admin/update-washpack/update-washpack.component';
import { WashpacksComponent } from './admin/washpacks/washpacks.component';
import { WelcomeComponent } from './admin/welcome/welcome.component';
import { AddOrderComponent } from './customer/add-order/add-order.component';
import { AddRatingComponent } from './customer/add-rating/add-rating.component';
import { CustomerDashboardComponent } from './customer/customer-dashboard/customer-dashboard.component';
import { CustomerProfileComponent } from './customer/customer-profile/customer-profile.component';
import { GreetingsComponent } from './customer/greetings/greetings.component';
import { PaymentComponent } from './customer/payment/payment.component';
import { ViewOrderComponent } from './customer/view-order/view-order.component';
import { ViewWashpacksComponent } from './customer/view-washpacks/view-washpacks.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminGuard } from './service/admin.guard';
import { CustomerGuard } from './service/customer.guard';
import { WasherGuard } from './service/washer.guard';
// import { AdminGuard } from './service/admin.guard';
// import { CustomerGuard } from './service/customer.guard';
// import { WasherGuard } from './service/washer.guard';
import { SignupComponent } from './signup/signup.component';
import { AllOrdersComponent } from './washer/all-orders/all-orders.component';
import { GreetComponent } from './washer/greet/greet.component';
import { ViewRatingComponent } from './washer/view-rating/view-rating.component';
import { WasherDashboardComponent } from './washer/washer-dashboard/washer-dashboard.component';
import { WasherProfileComponent } from './washer/washer-profile/washer-profile.component';


const routes: Routes = [
  {path:'', component:HomeComponent , pathMatch:'full'},
  {path:'signup', component:SignupComponent , pathMatch: 'full'},
  {path:'login' , component:LoginComponent , pathMatch:'full'},
  {
    path:'admin',
    component:DashboardComponent,
    canActivate:[AdminGuard],
    children:[
      { 
        path:'',
        component:WelcomeComponent,
      },
      { 
        path:'profile',
        component:ProfileComponent,
      },
      { 
        path:'washpacks',
        component:WashpacksComponent,
      },
      {
        path: 'addwashpacks',
        component:AddwashpacksComponent,
      },
      { 
        path:'allcustomers',
        component: AllcustomersComponent,
      },
      { 
        path:'allwashers',
        component: AllwashersComponent,
      },
      { 
        path:'updatewashpack/:wid',
        component:UpdateWashpackComponent,
      },
    ],
  },
  {
    path:'customer',
    component:CustomerDashboardComponent ,
    canActivate:[CustomerGuard],
    children:[
      { 
        path:'',
        component: GreetingsComponent,
      },
      { 
        path:'profile',
        component: CustomerProfileComponent,
      },
      { 
        path:'washpacks',
        component: ViewWashpacksComponent,
      },
      { 
        path:'add-order/:wid',
        component: AddOrderComponent,
      },
      { 
        path:'view-order',
        component: ViewOrderComponent,
      },
      { 
        path:'addrating',
        component: AddRatingComponent,
      },
      
    ],
  },

  {
    path:'washer',
    component: WasherDashboardComponent,
    canActivate:[WasherGuard],
    children:[
      {
        path:'',
        component:GreetComponent
      },
      { 
        path:'profile',
        component: WasherProfileComponent,
      },
      {
        path:'all-order',
        component:AllOrdersComponent,
      },
      { 
        path:'viewrating',
        component: ViewRatingComponent,
      }
    ]
  }
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
