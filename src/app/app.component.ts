import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SceneMenuComponent } from "./scene-menu/scene-menu.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SceneMenuComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'phone-book';
}
