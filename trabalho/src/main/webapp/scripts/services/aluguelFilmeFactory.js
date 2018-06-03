angular.module('trabalho').factory('aluguelFilmeResource', function($resource){
    var resource = $resource('rest/aluguelfilmes/:aluguelFilmeId',{aluguelFilmeId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});