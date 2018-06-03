angular.module('trabalho').factory('clienteResource', function($resource){
    var resource = $resource('rest/clientes/:clienteId',{clienteId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});