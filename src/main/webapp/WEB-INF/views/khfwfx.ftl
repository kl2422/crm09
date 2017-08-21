<!DOCTYPE HTML >
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>amCharts examples</title>
        <script src="${ctx}/amcharts/amcharts.js" type="text/javascript"></script>
        <script src="${ctx}/amcharts/pie.js" type="text/javascript"></script>
		<script src="${ctx}/highcharts4/jquery-1.8.3.min.js" type="text/javascript"></script>
        <script>
        	/*
            var chart;
            var legend;
			var chartData = [];
			$.ajax({
				url:"khfwfx",
				dataType: 'json',
				data:{},
				async: false, // 是否异步，默认是true， false就是同步
				success: function(data) {
					chartData = data.result;
				}
			});

            AmCharts.ready(function () {
                // PIE CHART
                chart = new AmCharts.AmPieChart();
                chart.dataProvider = chartData;
                chart.titleField = "serveType";
                chart.valueField = "amount";
                chart.outlineColor = "#FFFFFF";
                chart.outlineAlpha = 0.8;
                chart.outlineThickness = 2;
				
				// new title
				chart.addTitle("客户服务分析");
				
                // WRITE
                chart.write("chartdiv");
            });*/
            
            var chartData = [];
			$.ajax({
				url:"khfwfx",
				dataType: 'json',
				data:{},
				async: false, // 是否异步，默认是true， false就是同步
				success: function(data) {
					chartData = data.result;
				}
			});
            var chart = AmCharts.makeChart( "chartdiv", {
			  "type": "pie",
			  "theme": "light",
			  "dataProvider": chartData,
			  "valueField": "amount",
			  "titleField": "serveType",
			  "balloon":{
			   	"fixedPosition":true
			  },
			  "titles": [{
					"text": "客户服务分析",
					"size": 15
				}
			  ],
			  "export": {
			    "enabled": true
			  }
			});
        </script>
    </head>

    <body>
        <div id="chartdiv" style="width: 100%; height: 400px;"></div>
    </body>

</html>