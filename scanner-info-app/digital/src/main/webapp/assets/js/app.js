angular.module('SpringMusic', ['scannnerInfo','refphy','protoanalysis','albums', 'errors', 'status', 'info', 'ngRoute', 'ui.directives']).
    config(function ($locationProvider, $routeProvider) {
        // $locationProvider.html5Mode(true);

        $routeProvider.when('/errors', {
            controller: 'ErrorsController',
            templateUrl: 'assets/templates/errors.html'
        });
//        $routeProvider.otherwise({
//            controller: 'AlbumsController',
//            templateUrl: 'assets/templates/albums.html'
//        });
        $routeProvider.otherwise({
            controller: 'ScannerController',
            templateUrl: 'assets/templates/scannerInfo.html'
        });
        
    }
);
