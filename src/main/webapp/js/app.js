/**
 * Created by dtanwani on 3/5/2018.
 */
var app = angular.module("ComplaintPortal", ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl : "views/home.html"
        })
        .when("/login", {
            templateUrl : "views/login.html"
        })
        .when("/contact", {
            templateUrl : "views/contact.html"
        })
        .when("/complaint", {
            templateUrl : "views/ComplaintRegister.html"
        })
        .when("/signup", {
            templateUrl : "views/signup.html"
        })
});