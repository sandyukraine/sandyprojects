var citySearchModule = angular.module('CitySearchModule', ['ngRoute']);

citySearchModule.controller('CitySearchController', function($scope, $http) {
    $http.get('http://localhost:8080/cities').
        then(function(response) {
            $scope.cities = response.data;
        });
});

citySearchModule.filter('searchFilter', function() {
    return function(citiesArray, searchString) {

        if(!searchString) {
            return citiesArray;
        }

        searchString = searchString.toLowerCase();

        var result = [];

        angular.forEach(citiesArray, function(element){
            if(element.name.toLowerCase().indexOf(searchString) != -1) {
                result.push(element);
            }
        });

        return result;
    };
});

citySearchModule.controller('Cities', function($scope, $http) {
    $http.get('http://localhost:8080/city/Dresden').
        then(function(response) {
            $scope.city = response.data;
        });
});