

angular.module('trabalho').controller('EditaluguelFilmeController', function($scope, $routeParams, $location, flash, aluguelFilmeResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.aluguelFilme = new aluguelFilmeResource(self.original);
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The aluguelFilme could not be found.'});
            $location.path("/aluguelFilmes");
        };
        aluguelFilmeResource.get({aluguelFilmeId:$routeParams.aluguelFilmeId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.aluguelFilme);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The aluguelFilme was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.aluguelFilme.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/aluguelFilmes");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The aluguelFilme was deleted.'});
            $location.path("/aluguelFilmes");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.aluguelFilme.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});