angular.module('trabalho').factory('filmeResource', function($resource){
    var resource = $resource('rest/filmes/:filmeId',{filmeId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});