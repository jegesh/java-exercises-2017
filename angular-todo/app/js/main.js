(function () {

  'use strict';

  require('angular');
  require('angular-route');
  require('angular-animate');
  require('angular-touch');
  require('angular-ui-bootstrap');

  angular.module('SampleApp', ['ngRoute', 'ngAnimate', 'ngTouch', 'ui.bootstrap'])

  .config([
    '$routeProvider',
    function($routeProvider) {
      
        // routes
      $routeProvider
        .when("/", {
          templateUrl: "./partials/partial1.html",
          controller: "MainController"
        })
        .otherwise({
           redirectTo: '/'
        });
    }
  ]);

  //Load controller
  require('./controllers/mainctrl');

}());