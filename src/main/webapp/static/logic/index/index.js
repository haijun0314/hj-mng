var xset = [];//X轴数据集  
var yset = [];//Y轴数据集
var IndexUtil = {
			/********************最新订单数据***********************************/
			loadNewOrderInfo : function() {
				$("#newOderinfo").addClass("position-relative");
				$("#newOderinfo_").show();
				AjaxRequest.httpPost(
						"/orderinfo?newOrderinfo",
						{
							 
						},
						function(result) {
							 var  newOrderinfo = Handlebars.compile($("#orderinfo").html());
							 $('#ttt').append(newOrderinfo(result));
							 $("#newOderinfo_").hide();
						});
				}  ,
				
				/********************统计 折线图数据***********************************/
				loadStat_line : function() {
					$("#stat_line").addClass("position-relative");
					$("#stat_line_").show();
					AjaxRequest.httpPost(
							"/stat?getIndexStatMonthLineData",
							{},
							function(result) {
				                showChart(result);
				                $("#stat_line_").hide();
						});
					},
			/********************获取数据库数据 统计昨日 本周  本月数据***********************************/
			loadStat : function() {
				$("#stat").addClass("position-relative");
				$("#stat_").show();
				AjaxRequest.httpPost(
						"/stat?getTodayStat",
						{
							 
						},
						function(result) {
							 var todayOrder=$("#todayOrder");
							 var successCount=$("#successCount");
							 var failCount=$("#failCount");
							 var todayMoney=$("#todayMoney");
							 var successMoney=$("#successMoney");
							 var failMoney=$("#failMoney");
							 var monthCount=$("#monthCount");
							 var monthMoney=$("#monthMoney");
							 var monthsuccessCount=$("#monthsuccessCount");
							 var monthfailCount=$("#monthfailCount");
							 var monthsuccessMoney=$("#monthsuccessMoney");
							 var monthfailMoney=$("#monthfailMoney");
							 
							 var weekMoney=$("#weekMoney");
							 var weekCount=$("#weekCount");
							 var wsuccessCount=$("#wsuccessCount");
							 var wfailCount=$("#wfailCount");
							 var weeksuccessMoney=$("#weeksuccessMoney");
							 var weekfailMoney=$("#weekfailMoney");
							  
							 todayOrder.append('<span > '+result.totalCount+'</span>');
							 successCount.append('<span > '+result.successCount+'</span>');
							 failCount.append('<span > '+result.failCount+'</span>');
							 todayMoney.append('<span > '+result.totalMoney+'</span>');
							 successMoney.append('<span > '+result.successMoney+'</span>');
							 failMoney.append('<span > '+result.failMoney+'</span>');
							 monthCount.append('<span > '+result.MtotalCount+'</span>');
							 monthMoney.append('<span > '+result.MtotalMoney+'</span>');
							 monthsuccessCount.append('<span > '+result.MsuccessCount+'</span>');
							 monthfailCount.append('<span > '+result.MfailCount+'</span>');
							 monthsuccessMoney.append('<span > '+result.MsuccessMoney+'</span>');
							 monthfailMoney.append('<span > '+result.MfailMoney+'</span>');
							
							 weekCount.append('<span > '+result.WtotalCount+'</span>');
							 weekMoney.append('<span > '+result.WtotalMoney+'</span>');
							 wsuccessCount.append('<span > '+result.WsuccessCount+'</span>');
							 wfailCount.append('<span > '+result.WfailCount+'</span>');
							 weeksuccessMoney.append('<span > '+result.WsuccessMoney+'</span>');
							 weekfailMoney.append('<span > '+result.WfailMoney+'</span>');
							 $("#stat_").hide();
						});
				}, 
				
};
/*定义图表*/  
function showChart(result){  
	
	$('#container').highcharts({  
        chart:{  
             defaultSeriesType: 'spline',//图表的显示类型（line,spline,scatter,splinearea bar,pie,area,column）  
             marginRight: 125,//上下左右空隙  
             marginBottom: 25 //上下左右空隙  
        },  
        title:{  
            text: '本月交易额统计(元)',//主标题  
                x: -20 //center  
        },  
        credits: {
            enabled:false//不显示highCharts版权信息
        },
        lang:{  
        	contextButtonTitle: '图表导出菜单',
            decimalPoint: '.',
            downloadJPEG: "下载JPEG图片",
            downloadPDF: "下载PDF文件",
            downloadPNG: "下载PNG文件",
            downloadSVG: "下载SVG文件",
            drillUpText: "返回 {series.name}",
            loading: '加载中...',
            months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            noData: "没有数据",
            numericSymbols: ['k', 'M', 'G', 'T', 'P', 'E'],
            printChart: "打印图表",
            resetZoom: '重置缩放比例',
            resetZoomTitle: '重置为原始大小',
            shortMonths: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            thousandsSep: ',',
            weekdays: ['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期天'],
            },  
            exporting: {
                enabled: true
            },
        xAxis: {   //横坐标  
               categories: result.listXdata 
        },  
            yAxis: {  
           title: {  
             text: '' //纵坐标  
               },  
               plotLines: [{  //标线属性  
            value: 0,  
             width: 1,  
             color: 'red'  
                }]  
              },  
             tooltip: { //数据点的提示框  
             formatter: function() { //formatter格式化函数  
             return '<b>'+ this.series.name +'</b><br/>'+  
             this.x +': '+ this.y;  
            }  
        },  
        legend: {  
              layout: 'vertical',  
              align: 'right',  
              verticalAlign: 'top',  
              x: -10,  
              y: 100,  
              borderWidth: 0  
             },   
             series:result.listYdata  //动态解析</span>  
         });      
       }  
 