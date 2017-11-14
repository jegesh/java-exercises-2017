app = angular.module("firstAngular", ['ngRoute']);

app.config(function($routeProvider, $locationProvider){
	$locationProvider.hashPrefix(); 
	$routeProvider.when(
			"/first", {
        templateUrl: "templates/first-page.html"
        
    })
    .when(
    		"/second", {
    	templateUrl: "templates/second-page.html"
    })
    .otherwise({redirectTo: "/first"});
    
});

