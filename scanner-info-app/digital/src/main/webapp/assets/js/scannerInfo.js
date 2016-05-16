angular.module('scannnerInfo', ['ngResource', 'ui.bootstrap']).
    factory('HospitalList', function ($resource) {
        return $resource('scannnerInfo/getHospitals');
    });

function ScannerController($scope, HospitalList) {
    function list() {
        $scope.hospitals = HospitalList.query(function () {			            
        		addSelectedToHospList();
		        },
		     function (result) {
		           alert("Error " + result);
		        });
    }
    
    function addSelectedToHospList(){
    	var hospLen = $scope.hospitals.length;
    	for(i=0;i<hospLen;++i){
    		var hosp =  $scope.hospitals[i];
    		hosp.selected = "";
    	}
    	
    }
    
    $scope.onHospitalSelect = function(hospital){
    	$scope.selectedHosp = hospital;
    	var hospLen = $scope.hospitals.length;
    	for(i=0;i<hospLen;++i){
    		var hosp =  $scope.hospitals[i];
    		hosp.selected = "";
    	}    	
    	hospital.selected = "selected";
    	$scope.updateView($scope.viewTypeSelected);
    	$scope.$broadcast('refreshViews', [1,2,3]);
    }

    function clone (obj) {
        return JSON.parse(JSON.stringify(obj));
    }
    
    $scope.updateView = function(viewTypeUpdated){
    	$scope.viewTypeSelected = viewTypeUpdated;
    	if(($scope.selectedHosp != undefined ) && ($scope.viewTypeSelected != undefined)){	 
    		 $scope.viewType  = "assets/templates/" + $scope.viewTypeSelected + ".html" ;
    	}else{
    		$scope.viewType  = "assets/templates/noviewselected.html" ;
    	}
    }
       

    $scope.init = function() {
        list();
        $scope.viewTypeOptions = ['ReferringPhysicianAnalysis','ScanTimeAnalysis','ProtocolAnalysis','SystemLoadAnalysis'];
        $scope.viewType= "assets/templates/noviewselected.html";
        $scope.viewTypeSelected ="ReferringPhysicianAnalysis";
        google.charts.load('current', {'packages':['corechart']});
    };
}



