import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';
import { HelpRoutingModule } from './help-routing.module';
import { InformationComponent } from './information/information.component';

@NgModule({
    imports: [
      SharedModule,
      HelpRoutingModule
    ],
    declarations: [
      InformationComponent
    ]
})

export class HelpModule { }

