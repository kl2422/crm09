<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>amCharts examples</title>
        <script src="${ctx}/amcharts/amcharts.js" type="text/javascript"></script>
        <script src="${ctx}/amcharts/serial.js" type="text/javascript"></script>
         <script src="${ctx}/highcharts4/jquery-1.8.3.min.js" type="text/javascript"></script>

        <script>
            var chart;
            /*
			$.get("khgcfx", {}, function() {
				
			});*/
			var chartData = [];
			$.ajax({
				url:"khgcfx",
				dataType: 'json',
				data:{},
				async: false, // 是否异步，默认是true， false就是同步
				success: function(data) {
					chartData = data.result;
				}
			});
			/*
            var chartData = [
                {
                    "country": "USA",
                    "visits": 4025
                },
                {
                    "country": "China",
                    "visits": 1882
                },
                {
                    "country": "Japan",
                    "visits": 1809
                },
                {
                    "country": "Germany",
                    "visits": 1322
                },
                {
                    "country": "UK",
                    "visits": 1122
                },
                {
                    "country": "France",
                    "visits": 1114
                },
                {
                    "country": "India",
                    "visits": 984
                },
                {
                    "country": "Spain",
                    "visits": 711
                },
                {
                    "country": "Netherlands",
                    "visits": 665
                },
                {
                    "country": "Russia",
                    "visits": 580
                },
                {
                    "country": "South Korea",
                    "visits": 443
                },
                {
                    "country": "Canada",
                    "visits": 441
                },
                {
                    "country": "Brazil",
                    "visits": 395
                },
                {
                    "country": "Italy",
                    "visits": 386
                },
                {
                    "country": "Australia",
                    "visits": 384
                },
                {
                    "country": "Taiwan",
                    "visits": 338
                },
                {
                    "country": "Poland",
                    "visits": 328
                }
            ];*/


            AmCharts.ready(function () {
                // SERIAL CHART
                chart = new AmCharts.AmSerialChart();
                chart.dataProvider = chartData;
                chart.categoryField = "levelName";
                chart.startDuration = 1;

                // AXES
                // category
                var categoryAxis = chart.categoryAxis;
                categoryAxis.labelRotation = 0;
                categoryAxis.gridPosition = "start";

                // value
                // in case you don't want to change default settings of value axis,
                // you don't need to create it, as one value axis is created automatically.

                // GRAPH
                var graph = new AmCharts.AmGraph();
                graph.valueField = "amount";
                graph.balloonText = "类型：[[levelName]] <br>数量：[[amount]]个</b>";
                graph.type = "column";
                graph.lineAlpha = 0;
                graph.fillAlphas = 0.8;
                chart.addGraph(graph);
				
                // CURSOR
                var chartCursor = new AmCharts.ChartCursor();
                chartCursor.cursorAlpha = 0;
                chartCursor.zoomable = false;
                chartCursor.categoryBalloonEnabled = false;
                chart.addChartCursor(chartCursor);

                chart.creditsPosition = "top-right";
                
				chart.addTitle("客户构成分析");
				
                chart.write("chartdiv");
            });
        </script>
    </head>

    <body>
        <div id="chartdiv" style="width: 100%; height: 400px;"></div>
    </body>

</html>