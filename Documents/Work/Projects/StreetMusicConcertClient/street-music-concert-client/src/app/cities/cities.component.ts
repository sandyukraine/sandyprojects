import { Component, OnInit } from '@angular/core';
import { CityService } from "../shared/city/city.service";

@Component({
  selector: 'app-cities',
  templateUrl: './cities.component.html',
  styleUrls: ['./cities.component.css']
})
export class CitiesComponent implements OnInit {
  cities: Array<any>;

  constructor(private cityService: CityService) { }

  ngOnInit() {
    this.cityService.getCities().subscribe(data => {
      this.cities = data;
    });
  }
}
