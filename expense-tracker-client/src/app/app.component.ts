import { Component, inject, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TestMessageService } from './core/test-message.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent implements OnInit {
  message = signal<{ title: string; description: string } | undefined>(
    undefined
  );

  testMessageService = inject(TestMessageService);

  ngOnInit(): void {
    this.testMessageService.getTestMessage().subscribe((message) => {
      this.message.set(message);
    });
  }
}
