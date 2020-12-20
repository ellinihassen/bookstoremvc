import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  links: any[] = [
    {
      url: '/private/user/my-orders', title: 'My-Orders'
    },
    {
      url: '/private/admin/book-store', title: 'Book-Store'
    },
    {
      url: '/private/admin/orders', title: ' Manage-Orders'
    }
  ];
  title = 'web';
}
