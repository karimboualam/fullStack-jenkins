import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { HelloService } from './hello'; // 👈 renomme bien en HelloService

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class AppComponent implements OnInit {
  message = '';

  constructor(private helloService: HelloService) {}

  ngOnInit(): void {
    this.helloService.getMessage().subscribe((data: string) => {
      this.message = data;
    });
  }
}
