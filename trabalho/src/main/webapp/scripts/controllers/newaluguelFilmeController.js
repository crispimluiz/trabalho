
angular.module('trabalho').controller('NewaluguelFilmeController', function ($scope, $location, locationParser, flash, aluguelFilmeResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.aluguelFilme = $scope.aluguelFilme || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The aluguelFilme was created successfully.'});
            $location.path('/aluguelFilmes');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        aluguelFilmeResource.save($scope.aluguelFilme, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/aluguelFilmes");
    };
});