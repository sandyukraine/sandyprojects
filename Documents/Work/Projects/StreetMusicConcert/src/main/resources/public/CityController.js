angular.module('StreetMusicConcertModule', [])
.controller('Cities', function($scope, $http) {
    $http.get('http://localhost:8080/cities').
        then(function(response) {
            $scope.greeting = response.data;
        });
});