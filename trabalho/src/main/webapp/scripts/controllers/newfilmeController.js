
angular.module('trabalho').controller('NewfilmeController', function ($scope, $location, locationParser, flash, filmeResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.filme = $scope.filme || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The filme was created successfully.'});
            $location.path('/filmes');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        filmeResource.save($scope.filme, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/filmes");
    };
});