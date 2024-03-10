import chartData from './chartdata.js';


$(document).ready(function() {
	// 차트 생성

	// 기본 라벨 값
	var labels = ["월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"];

	var ctx = document.getElementById('myChart').getContext('2d');
	var myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: labels,
			datasets: [{
				label: "총 수익",
				lineTension: 0.3,
				backgroundColor: "rgba(0, 135, 72, 0.4)",
				borderColor: "rgba(0, 135, 72, 1)",
				pointRadius: 5,
				pointBackgroundColor: "rgba(241, 242 ,237 ,1)",
				pointBorderColor: "rgba(0, 135, 72, 0.8)",
				pointHoverRadius: 5,
				pointHoverBackgroundColor: "rgba(0, 135, 72, 1)",
				pointHitRadius: 50,
				pointBorderWidth: 2,
				data: [] // 나중에 값 들어감
			},
			{
				label: "수수료 수익",
				lineTension: 0.3,
				backgroundColor: "rgba(255, 99, 132, 0.4)",
				borderColor: "rgba(255, 99, 132, 1)",
				pointRadius: 5,
				pointBackgroundColor: "rgba(241, 242 ,237 ,1)",
				pointBorderColor: "rgba(255, 99, 132, 0.8)",
				pointHoverRadius: 5,
				pointHoverBackgroundColor: "rgba(255, 99, 132, 1)",
				pointHitRadius: 50,
				pointBorderWidth: 2,
				data: [], // 나중에 값 들어감
				hidden: true
			}],
		},
		options: {
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero: true, // 최소값을 0으로 설정
					}
				}],
			},
			legend: {
				display: false
			},
			// 다른 차트 옵션들 설정
		},
	});

	// 데이터 추가 함수
	function addData(chart, label, data, datasetIndex) {
		if (chart.data.labels.length === 0) {
			// labels 배열이 비어있으면 labels 설정
			chart.data.labels = ["월", "화", "수", "목", "금", "토", "일"];
		}
		chart.data.datasets[datasetIndex].label = label;
		chart.data.datasets[datasetIndex].hidden = false; // 숨겨진 상태 해제
		chart.data.datasets[datasetIndex].data = data; // 데이터 설정
		chart.update();
	}

	// 데이터 제거 함수
	function removeData(chart, datasetIndex) {
		chart.data.datasets[datasetIndex].hidden = true;
		chart.update();
	}

	// 총 수익 체크박스 이벤트 핸들러
	$('#siteCheckbox1').change(function() {
		if (this.checked) {
			unhideData(myChart, 0);
		} else {
			// 체크 해제되면 데이터 제거
			hideData(myChart, 0);
		}
	});

	// 수수료 수익 체크박스 이벤트 핸들러
	$('#siteCheckbox2').change(function() {
		if (this.checked) {
			// 체크되면 데이터 추가
			unhideData(myChart, 1);
		} else {
			// 체크 해제되면 데이터 제거
			hideData(myChart, 1);
		}
	});


	// 기간 변경 및 값 변경

	// 주간 버튼 클릭 이벤트 핸들러
	$('#weeklyChartButton').click(function() {

		labels = ["월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"];

		updateLabels(labels);

		// 주간 데이터
		// 수익 데이터 추가
		addData(myChart, "총 수익", chartData.weekly1, 0);
		addData(myChart, "수수료 수익", chartData.weekly2, 1);

	});

	// 월간 버튼 클릭 이벤트 핸들러
	$('#monthlyChartButton').click(function() {
		labels = [];
		for (var i = 1; i <= 31; i++) {
			labels.push(i + "일");
		}
		updateLabels(labels);

		// 월간 데이터

		// 수익 데이터 추가
		addData(myChart, "총 수익", chartData.monthly1, 0);
		addData(myChart, "수수료 수익", chartData.monthly2, 1);
	});

	// labels 업데이트 함수
	function updateLabels(newLabels) {
		myChart.data.labels = newLabels;
		myChart.update();
	}


	// 차트 모양 변경

	// 바 버튼 클릭 이벤트 핸들러
	$('#barChartButton').click(function() {
		// 차트의 유형을 'bar'로 변경
		myChart.config.type = 'bar';
		rollbackBgColors(myChart);
		myChart.update();
	});

	// 에어리어 버튼 클릭 이벤트 핸들러
	$('#areaChartButton').click(function() {
		// 차트의 유형을 'area'로 변경
		myChart.config.type = 'line';
		clearBgColors(myChart);
		myChart.update();
	});
	
	// 배경 색 지우는 함수
	function clearBgColors(chart) {
		for (var i = 0; i < chart.data.datasets.length; i++) {
			chart.data.datasets[i].backgroundColor = "rgba(0, 0, 0, 0)";
		}
		chart.update();
	}

	function rollbackBgColors(chart) {
		chart.data.datasets[0].backgroundColor = "rgba(0, 135, 72, 0.4)";
		chart.data.datasets[1].backgroundColor = "rgba(255, 99, 132, 0.4)";
	}

	// 데이터 숨기거나 보여주는 함수

	// 숨기기
	function hideData(chart, datasetIndex) {
		chart.getDatasetMeta(datasetIndex).hidden = true;
		chart.update();
	}

	// 보여주기
	function unhideData(chart, datasetIndex) {
		chart.getDatasetMeta(datasetIndex).hidden = false;
		chart.update();
	}

	// 초기 값 설정

	addData(myChart, "총 수익", chartData.weekly1, 0);
	hideData(myChart, 0);
	addData(myChart, "수수료 수익", chartData.weekly2, 1);
	hideData(myChart, 1);

});