import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioComponent } from './component/portfolio/portfolio.component';
import { Routes, RouterModule } from '@angular/router';
import { StockpickerComponent } from './component/stockpicker/stockpicker.component';
import { SettingComponent } from './component/setting/setting.component';

const routes: Routes = [{
  component: PortfolioComponent,
  path: "portfolio"},{
  component: StockpickerComponent,
  path: "stockpicker"},{
  component: SettingComponent,
  path: "setting"
}];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule],
  declarations: []
})
export class AppRoutingModule { }