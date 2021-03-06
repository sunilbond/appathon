angular.module('refphy', ['ngResource', 'ui.bootstrap']).
    factory('RefPhyAnalysis', function ($resource) {
        return $resource('scannnerInfo/getRefPhy/:hospID', {hospID: '@hospID'});
    });


function RefPhyController($scope, RefPhyAnalysis, $window) {
    function list() {
    	$scope.refPhyServiceCall = false;
        $scope.refPhyList = RefPhyAnalysis.query({hospID: $scope.selectedHosp[1]}, 
        		 function () {			            
        				$scope.refPhyServiceCall = true;
        				paintRefPhyCharts();
			        },
			     function (result) {
			           alert("Error " + result);
			           $scope.refPhyServiceCall = false;
			        });
    }
    function paintRefPhyCharts(){
    	if($scope.refPhyServiceCall == true){
    		google.charts.setOnLoadCallback(drawRefPhyGraphs);
    		drawRefPhyGraphs();
    	}
    }
           
    function drawRefPhyGraphs() {
    	var pieChartDataFromService = [];
    	pieChartDataFromService.push(['Dr Name', 'Revenue Generated By Referring Physician']);
    	
    	var colChartDataFromService = [];
    	colChartDataFromService.push(['Dr Name', 'Exams Referred', { role: 'style' }]);

    	var len = $scope.refPhyList.length;
    	for(i=0;i<len;++i){
    		var eachRefPhyItem = $scope.refPhyList[i];
    		pieChartDataFromService.push([eachRefPhyItem[2],eachRefPhyItem[0]]);
    		colChartDataFromService.push([eachRefPhyItem[2],eachRefPhyItem[1],'color:'+ getRandomColor() +';opacity:0.5'+ Math.random()]);
    	}
    	var pieChartData = google.visualization.arrayToDataTable(pieChartDataFromService);

        var pieChartOptions = {
          title: 'Contribution per Referring Physician'
        };
        var pieChart = new google.visualization.PieChart(document.getElementById('piechart'));
        pieChart.draw(pieChartData, pieChartOptions);        
        
        
        var colChartData = google.visualization.arrayToDataTable(colChartDataFromService);
        var optionsColChart = {
                title: 'Exams Per Referring Physician'
              };
        
        var columnChart = new google.visualization.ColumnChart(
          document.getElementById('colbarchart'));

        columnChart.draw(colChartData, optionsColChart);
        
        
      }
    
    function getRandomColor() {
        var letters = '1123456789ABCDEF'.split('');
        var color = '#';
        for (var i = 0; i < 6; i++ ) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }
    
    function clone (obj) {
        return JSON.parse(JSON.stringify(obj));
    }
    
    $scope.updateView = function(viewTypeUpdated){
    	if(($scope.selectedHosp != undefined ) && ($scope.viewTypeSelected != undefined || viewTypeUpdated != undefined)){    		 
    		 $scope.viewType  = "assets/templates/" + viewTypeUpdated + ".html" ;
    	}else{
    		$scope.viewType  = "assets/templates/noviewselected.html" ;
    	}
    }
    
    $scope.$on('refreshViews', function(event, args) {
    	console.log(args);
    	list();
    	
    });

    $scope.setScannerInfoView = function (viewName) {
        $scope.scannerInfo = "assets/templates/" + viewName + ".html";
    };

    $scope.refPhyViewInit = function() {
        list();
//        $scope.setScannerInfoView("gridScannerInfo");
//        $scope.sortField = "name";
//        $scope.sortDescending = false;
//        $scope.viewTypeOptions = ['ReferringPhysicianAnalysis','ScanTimeAnalysis','ProtocolAnalysis','SystemLoadAnalysis'];
//        $scope.viewType= "assets/templates/noviewselected.html";
//        $scope.viewTypeSelected ="ReferringPhysicianAnalysis";
//        google.charts.load('current', {'packages':['corechart']});
//        google.charts.setOnLoadCallback(drawRefPhyGraphs);
        //drawRefPhyGraphs();
    };
}



