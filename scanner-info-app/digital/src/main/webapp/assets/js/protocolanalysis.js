angular.module('protoanalysis', ['ngResource', 'ui.bootstrap']).
    factory('ProtocolAnalysisSrv', function ($resource) {
        return $resource('scannnerInfo/getProtocolAnalysis/:hospID', {hospID: '@hospID'});
    });


function ProtoAnalysisController($scope, ProtocolAnalysisSrv) {
    function refreshProtolcolAnalysisView() {
    	$scope.protoAnalysisServiceCall = false;
        $scope.protoAnalysisList = ProtocolAnalysisSrv.query({hospID: $scope.selectedHosp[1]}, 
        		 function () {			            
        				$scope.protoAnalysisServiceCall = true;
        				paintProtocolAnalysisCharts();
			        },
			     function (result) {
			           alert("Error " + result);
			           $scope.protoAnalysisServiceCall = false;
			        });
    }
    function paintProtocolAnalysisCharts(){
    	if($scope.protoAnalysisServiceCall == true){
    		google.charts.setOnLoadCallback(drawProtocolAnalysisGraph);
    		drawProtocolAnalysisGraph();
    	}
    }
           
    function findUnique(list){
    	list = list.filter((value, index, list) => (list.slice(0, index)).indexOf(value) === -1);
    	return list;
    }
    
    function extraItem(itemIndex){
    	var itemsToExtract = [];
    	var len = $scope.protoAnalysisList.length;
    	for(i=0;i<len;++i){
    		var eachProtoItem = $scope.protoAnalysisList[i];
    		itemsToExtract.push(eachProtoItem[itemIndex]);
    	}
    	return itemsToExtract;
    }
    
    function formDictionary(){
    	var dict = {};
    	var len = $scope.protoAnalysisList.length;
    	for(i=0;i<len;++i){
    		var eachProtoItem = $scope.protoAnalysisList[i];
    		dict[eachProtoItem[1].replace(" " , "") + "_" + eachProtoItem[2]] = eachProtoItem[0];
    	}
    	return dict;
    }
    function drawProtocolAnalysisGraph() {
    	var chartDataHeader = ['Dr Name'];
    	var chartDataFromService = []
    	var protocols = extraItem(2);
    	var uniqueProtocols = findUnique(protocols);
    	
    	var drNames = extraItem(1);
    	var uniqueDoctors = findUnique(drNames);
    	
    	var dictDrNameProtoName = formDictionary();
    	
    	uniqueProtocols.forEach(function(item, index){ 
    		chartDataHeader.push(item);
    	});
    	chartDataFromService.push(chartDataHeader);
    	
    	uniqueDoctors.forEach(function(doctor, docIndex){ 
    		var eachDocProtoRecords = [];
    		eachDocProtoRecords.push(doctor);
    		uniqueProtocols.forEach(function(protocol, protoIndex){
    			var value = dictDrNameProtoName[doctor.replace(" ","") + "_" + protocol];
    			if(value == undefined){
    				value = 0;
    			}
    			eachDocProtoRecords.push(value);
        	});
    		chartDataFromService.push(eachDocProtoRecords);
    	});
    	
    	
    	var barChartData = google.visualization.arrayToDataTable(chartDataFromService);

//        var pieChartOptions = {
//          title: 'Contribution per Referring Physician'
//        };
        
        var barChartOptions = {
                width: 600,
                height: 400,
                legend: { position: 'top', maxLines: 3 },
                bar: { groupWidth: '75%' },
                isStacked: true
              };
        
        var barChart = new google.visualization.BarChart(document.getElementById('barchart'));
        barChart.draw(barChartData, barChartOptions);               
        
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
    
    $scope.$on('refreshViews', function(event, args) {
    	console.log(args);
    	refreshProtolcolAnalysisView();
    	
    });


    $scope.protoAnalysisViewInit = function() {
    	refreshProtolcolAnalysisView();
    };
}



