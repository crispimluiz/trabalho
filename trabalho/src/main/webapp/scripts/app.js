'use strict';

angular.module('trabalho',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/aluguelFilmes',{templateUrl:'views/aluguelFilme/search.html',controller:'SearchaluguelFilmeController'})
      .when('/aluguelFilmes/new',{templateUrl:'views/aluguelFilme/detail.html',controller:'NewaluguelFilmeController'})
      .when('/aluguelFilmes/edit/:aluguelFilmeId',{templateUrl:'views/aluguelFilme/detail.html',controller:'EditaluguelFilmeController'})
      .when('/clientes',{templateUrl:'views/cliente/search.html',controller:'SearchclienteController'})
      .when('/clientes/new',{templateUrl:'views/cliente/detail.html',controller:'NewclienteController'})
      .when('/clientes/edit/:clienteId',{templateUrl:'views/cliente/detail.html',controller:'EditclienteController'})
      .when('/filmes',{templateUrl:'views/filme/search.html',controller:'SearchfilmeController'})
      .when('/filmes/new',{templateUrl:'views/filme/detail.html',controller:'NewfilmeController'})
      .when('/filmes/edit/:filmeId',{templateUrl:'views/filme/detail.html',controller:'EditfilmeController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
