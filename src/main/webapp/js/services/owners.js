/**
 * Created by dtanwani on 3/5/2018.
 */
app.factory('owners', ['$http', function ($http) {
    return $http.get('http://localhost:8080/webapi/owners/')
        .then(function(response) {
            console.log(response);
            return response;
        },function(error) {
            console.log("NOT GOT-owners");
        })

}]);


