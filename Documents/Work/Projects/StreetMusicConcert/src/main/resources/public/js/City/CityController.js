var citySearchModule = angular.module('CitySearchModule', []);

citySearchModule.controller('CitySearchController', ["$scope", function($scope) {
    $scope.items = [
        {
            url: 'http://tutorialzine.com/2013/07/50-must-have-plugins-for-extending-twitter-bootstrap/',
            title: 'Munich',
        },
        {
            url: 'http://tutorialzine.com/2013/08/simple-registration-system-php-mysql/',
            title: 'Dresden',
        },
        {
            url: 'http://tutorialzine.com/2013/08/slideout-footer-css/',
            title: 'Krakow',
        },
        {
            url: 'http://tutorialzine.com/2013/06/digital-clock/',
            title: 'Prague',
        },
        {
            url: 'http://tutorialzine.com/2013/05/diagonal-fade-gallery/',
            title: 'Berlin',
        },
        {
            url: 'http://tutorialzine.com/2013/05/mini-ajax-file-upload-form/',
            title: 'Ivano-Frankivsk',
        },
        {
            url: 'http://tutorialzine.com/2013/04/services-chooser-backbone-js/',
            title: 'Wroclaw',
        }
    ];
}]);

citySearchModule.filter('searchFilter', function() {
    return function(citiesArray, searchString) {

        if(!searchString) {
            return citiesArray;
        }

        searchString = searchString.toLowerCase();

        var result = [];

        angular.forEach(citiesArray, function(element){
            if(element.title.toLowerCase().indexOf(searchString) != -1) {
                result.push(element);
            }
        });

        return result;
    };
});

citySearchModule.controller('Cities', function($scope, $http) {
    $http.get('http://localhost:8080/cities').
        then(function(response) {
            $scope.greeting = response.data;
        });
});