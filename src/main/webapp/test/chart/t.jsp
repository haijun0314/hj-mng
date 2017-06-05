<!-- 统计图插件highcharts  测试   折线图   -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<head>
	<script src="${contextPath}/static/js/jquery-2.0.3.min.js" type="text/javascript"></script>
    <script src="${contextPath}/static/highcharts/highcharts.js"></script>
    <script src="${contextPath}/static/highcharts/exporting.js"></script>
    <script src="${contextPath}/static/js/ajaxRequest.js" type="text/javascript"></script>
</head>
<body>
<script>
    $(function () {
        $('#container').highcharts({
            //主标题
            title: {
                text: '本月订单金额',
                x: -20 //center
            },
            //副标题，但不是必须的
            subtitle: {
                text: '',
                x: -20
            },
             credits: {
                 enabled:false//不显示highCharts版权信息
             },
            //x坐标轴
            xAxis: {
                categories: ['1', '2', '3', '4', '5', '6',
                    '7', '8', '9', '10', '11', '12', '13', '14', '15'
                    , '16', '17', '18', '19', '20', '21', '22', '23'
                    , '24', '25', '26', '27', '28', '29', '30', '31']
            },
            //y坐标轴
            yAxis: {
                title: {
                    text: 'Money (￥)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }],
            },
            //数据提示框
            tooltip: {
                valueSuffix: '￥'
            },
            //图例
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            //数据列
            series: [{
                name: '捎带',
                data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
            }, {
                name: '问答',
                data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
            }, {
                name: '跑腿',
                data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
            },{
                name: '小时工',
                data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
            },{
                name: '活动',
                data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
            }]
        });
    });
</script>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</body>
</html>