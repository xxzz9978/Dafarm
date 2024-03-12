$(document).ready(function() {
	// Chart.js 코드
	// ------------------Chart.js--------------------
	// 차트 생성
	var labels = [];
	var ctx = document.getElementById('revenue_total_chart').getContext('2d');
	var total_chart = new Chart(ctx, {
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
			}]
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
	var ctx = document.getElementById('seller_count_chart').getContext('2d');
	var seller_count_chart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: labels,
			datasets: [{
				label: "판매자 가입자 수",
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
			}]
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

	$.ajax({
		url: 'adminDashboardTotal',
		type: "POST",
		contentType: "application/json",
		data: JSON.stringify({}), // 빈 JSON 객체를 요청 본문에 포함
		success: function(response) {
			// 서버로부터 받은 응답을 처리하는 코드
			updateTotalChart(response);
		},
		error: function(xhr, status, error) {
			// 에러 처리 코드
		}
	});
	
	$.ajax({
		url: 'adminDashboardSeller',
		type: "POST",
		contentType: "application/json",
		data: JSON.stringify({}), // 빈 JSON 객체를 요청 본문에 포함
		success: function(response) {
			// 서버로부터 받은 응답을 처리하는 코드
			updateSellerChart(response);
		},
		error: function(xhr, status, error) {
			// 에러 처리 코드
		}
	});

	// 차트를 업데이트하는 함수
	function updateTotalChart(data) {

		// data를 사용하여 차트를 업데이트하는 코드

		// 데이터 넣을 공간
		var revenue_total = [];
		var labels = [];
		for (var i = 0; i < data.length; i++) {
			revenue_total.push(data[i].revenue_total);
			labels.push(data[i].revenue_date); // revenue_date는 데이터에서 날짜를 나타내는 필드입니다.
		}
		// 차트 업데이트
		total_chart.data.datasets[0].data = revenue_total;

		total_chart.update();

		console.log('revenue_total : ' + revenue_total[0]);
		console.log('labels : ' + labels[0]);
		updateTotalLabels(labels);
	}
	
	// 차트를 업데이트하는 함수
	function updateSellerChart(data) {

		// data를 사용하여 차트를 업데이트하는 코드

		// 데이터 넣을 공간
		var seller_count = [];
		var labels = [];
		for (var i = 0; i < data.length; i++) {
			// 시간대를 고려하여 날짜를 생성
	        var date = new Date(data[i].seller_access_date + ' UTC'); // 시간대를 UTC로 설정
	        // 현재 시간대로 변환하여 문자열로 변환
	        var dateString = new Date(date.getTime() - (date.getTimezoneOffset() * 60000)).toISOString().split('T')[0];
	        seller_count.push(data[i].seller_count);
	        labels.push(dateString); // 날짜를 라벨에 추가
		}
		// 차트 업데이트
		seller_count_chart.data.datasets[0].data = seller_count;

		seller_count_chart.update();

		console.log('seller_count : ' + seller_count[0]);
		console.log('labels : ' + labels[0]);
		updateSellerLabels(labels);
	}

	// labels 업데이트 함수
	function updateTotalLabels(newLabels) {
		total_chart.data.labels = newLabels;
		total_chart.update();
	}
	
	function updateSellerLabels(newLabels) {
		seller_count_chart.data.labels = newLabels;
		seller_count_chart.update();
	}

});
