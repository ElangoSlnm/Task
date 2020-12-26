import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: 'app.card.html',
  styleUrls: ['app.card.css'],
})
export class CardOverviewExample implements OnInit {
  confData: any;
  filteredItems: any;
  apiUrl =
    'https://o136z8hk40.execute-api.us-east-1.amazonaws.com/dev/get-list-of-conferences';

  constructor(private http: HttpClient) {}

  GetData() {
    this.http.get(this.apiUrl).subscribe((data) => {
      let items = data;
      this.assignconfData(items);
    });
  }

  assignconfData(items: any) {
    this.confData = items.paid
    this.confData = this.confData.concat(items.free)
    this.assignCopy();
  }

  cleanUrl(url: any) {
    return url.replace(/\"/g, '');
  }

  ClearData() {
    this.confData = [];
  }

  assignCopy() {
    this.filteredItems = this.confData;
  }

  filterItem(value: any) {
    if (!value) {
      this.assignCopy();
      return;
    }

    this.filteredItems = Object.assign([], this.confData).filter(
      (item: any) =>
        item.searchTerms.toLowerCase().indexOf(value.toLowerCase()) > -1
    );
    console.log(value);
  }

  searchItems(value: any) {
    if (!value) {
      this.assignCopy();
      return;
    }

    this.filteredItems = Object.assign([], this.confData).filter(
      (item: any) =>
        item.searchTerms.toLowerCase().indexOf(value.toLowerCase()) > -1
    );
    console.log(value);
  }

  ngOnInit() {
    this.GetData();
  }
}
