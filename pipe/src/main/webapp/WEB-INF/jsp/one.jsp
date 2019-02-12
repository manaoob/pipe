<%@page pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
    <head> 
        <title></title> 
        <meta charset="utf-8" /> 
        
    </head> 
    <body> 
    						<div id="CrackJs" style="height: 400px; width:400px; float:left;background-color: "></div>
							<div id="CrackMises" style="height: 400px; width:400px; float:left"></div>
							<div id="AxialMises" style="height: 400px; width:400px; float:left"></div>
							<div id="AxialU2" style="height: 400px; width:400px; float:left"></div>
							<div id="AxialPressure" style="height: 400px; width:400px; float:left"></div>	
							<div id="AxialShear" style="height: 400px; width:400px; float:left"></div>	
    
        <a href="save/add">点击01</a>
        
        
<script src="<%=request.getContextPath()%>/lib/assets/js/echarts.min.js"></script>    
	<script type="text/javascript">		
	var myChart = echarts.init(document.getElementById('main'));
	      option={
	            title: {
	                text: '沿裂纹的J积分值',
					borderWidth:2,
					x:'center'
					
	            },
	            tooltip: {},
	            legend: {
					orient:'vertical',
					x:'right',
	                data:[]
					
	            },
	            xAxis: {
					type: 'category',
					name: '单位/。',
	                //data: ${Xlist1}
					data: [1, 2, 3, 4, 5]
	            },
	            yAxis: { 
						name: '单位/kJm-2'
						},
	            series: [{
	                name: '',
	                type: 'line',
//					stack:'总水量',
					smooth: true,
					//data: ${mapCrackJs.Y[0]}
	                data: [12, 15, 18, 21, 14]
					
	            }]
//				{
	//                name: 'd=600',
	//                type: 'line',
//					stack:'总水量',
//					color:'#B5C334',
//					smooth: true,
//					data:${map.first}
	                //data: [22,25,28,31,24]
	//            }

	        };
	     myChart.setOption(option);
	 var myChart1 = echarts.init(document.getElementById('CrackJs'));
      option={
            title: {
                text: '沿裂纹的J积分值',
				borderWidth:2,
				x:'center'
				
            },
            tooltip: {},
            legend: {
				orient:'vertical',
				x:'right',
                data:[]
				
            },
            xAxis: {
				type: 'category',
				name: '单位/。',
                //data: ${Xlist1}
				data: [1, 2, 3, 4, 5]
            },
            yAxis: { 
					name: '单位/kJm-2'
					},
            series: [{
                name: '',
                type: 'line',
//				stack:'总水量',
				smooth: true,
				//data: ${mapCrackJs.Y[0]}
                data: [12, 15, 18, 21, 14]
				
            }]
//			{
//                name: 'd=600',
//                type: 'line',
//				stack:'总水量',
//				color:'#B5C334',
//				smooth: true,
//				data:${map.first}
                //data: [22,25,28,31,24]
//            }

        };
     myChart1.setOption(option);
var myChart2 = echarts.init(document.getElementById('CrackMises'));
      option={
            title: {
                text: '沿裂纹的mises应力',
				borderWidth:2,
				x:'center'
				
            },
            tooltip: {},
            legend: {
				orient:'vertical',
				x:'right',
                data:[]
				
            },
            xAxis: {
				type: 'category',
				name: '单位/。',
                data: ${Xlist2}
            },
            yAxis: { 
					name: '单位/MPa'
					},
            series: [
	
			{
                name: '',
                type: 'line',
//				stack:'总水量',
				smooth: true,
				data:${crackMises}
               // data: [12,15,18,21,14]
				
            },

      ]
            
        };
     myChart2.setOption(option);

var myChart3 = echarts.init(document.getElementById('AxialMises'));
      option={
            title: {
                text: '管道轴向mises应力',
				borderWidth:2,
				x:'center'
				
            },
            tooltip: {},
            legend: {
				orient:'vertical',
				x:'right',
                data:[]
				
            },
            xAxis: {
				type: 'category',
				name: '单位/m',
                data: ${Xlist3}
            },
            yAxis: { 
					name: '单位/MPa'
					},
            series: [{
                name: '',
                type: 'line',
//				stack:'总水量',
				smooth: true,
				data: ${mapAxialMises.Y}
               // data: [12,15,18,21,14]
				
            }]
            
        };
     myChart3.setOption(option);

var myChart4 = echarts.init(document.getElementById('AxialU2'));
      option={
            title: {
                text: '管道沉降',
				borderWidth:2,
				x:'center'
				
            },
            tooltip: {},
            legend: {
				orient:'vertical',
				x:'right',
                data:[]
				
            },
            xAxis: {
				type: 'category',
				name: '单位/m',
                data: ${Xlist4}
            },
            yAxis: { 
					name: '单位/mm'
					},
            series: [{
                name: '',
                type: 'line',
//				stack:'总水量',
				smooth: true,
				data:${mapAxialU2.Y}
               // data: [12,15,18,21,14]
				
            }]
            
        };
     myChart4.setOption(option);

var myChart5 = echarts.init(document.getElementById('AxialPressure'));
      option={
            title: {
                text: '管道轴应力',
				borderWidth:2,
				x:'center'
				
            },
            tooltip: {},
            legend: {
				orient:'vertical',
				x:'right',
                data:[]
				
            },
            xAxis: {
				type: 'category',
				name: '单位/m',
                data: ${Xlist5}
            },
            yAxis: { 
					name: '单位/MPa'
					},
            series: [{
                name: '',
                type: 'line',
//				stack:'总水量',
				smooth: true,
				data:${mapAxialPressure.Y}
               // data: [12,15,18,21,14]
				
            }]
            
        };
     myChart5.setOption(option);
	
var myChart6 = echarts.init(document.getElementById('AxialShear'));
      option={
            title: {
                text: '管道切应力',
				borderWidth:2,
				x:'center'
				
            },
            tooltip: {},
            legend: {
				orient:'vertical',
				x:'right',
                data:[]
				
            },
            xAxis: {
				type: 'category',
				name: '单位/m',
                data: ${Xlist6}
            },
            yAxis: { 
					name: '单位/MPa'
					},
            series: [{
                name: '',
                type: 'line',
//				stack:'总水量',
				smooth: true,
				data:${mapAxialShear.Y}
               // data: [12,15,18,21,14]
				
            
            }]
        };
     myChart6.setOption(option);
	</script>    
    </body>
</html>