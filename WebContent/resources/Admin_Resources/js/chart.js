$(document).ready(function() {
    // Chart.js 코드
    // ------------------Chart.js--------------------
    // 차트 생성
    var labels = [];
    var revenue_labels = [];
    var seller_labels = [];
    var seller_profit_labels = [];
    var user_labels = [];
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
                },
                {
                    label: "광고 수익",
                    lineTension: 0.3,
                    backgroundColor: "rgba(255, 206, 86, 0.4)",
                    borderColor: "rgba(255, 206, 86, 1)",
                    pointRadius: 5,
                    pointBackgroundColor: "rgba(241, 242 ,237 ,1)",
                    pointBorderColor: "rgba(255, 206, 86, 0.8)",
                    pointHoverRadius: 5,
                    pointHoverBackgroundColor: "rgba(255, 206, 86, 1)",
                    pointHitRadius: 50,
                    pointBorderWidth: 2,
                    data: [] // 나중에 값 들어감
                },
                {
                    label: "멤버쉽 수익",
                    lineTension: 0.3,
                    backgroundColor: "rgba(75, 192, 192, 0.4)",
                    borderColor: "rgba(75, 192, 192, 1)",
                    pointRadius: 5,
                    pointBackgroundColor: "rgba(241, 242 ,237 ,1)",
                    pointBorderColor: "rgba(75, 192, 192, 0.8)",
                    pointHoverRadius: 5,
                    pointHoverBackgroundColor: "rgba(75, 192, 192, 1)",
                    pointHitRadius: 50,
                    pointBorderWidth: 2,
                    data: [] // 나중에 값 들어감
                },
				{
				    label: "판매자 회원 수",
				    lineTension: 0.3,
				    backgroundColor: "rgba(255, 159, 64, 0.4)",
				    borderColor: "rgba(255, 159, 64, 1)",
				    pointRadius: 5,
				    pointBackgroundColor: "rgba(241, 242 ,237 ,1)",
				    pointBorderColor: "rgba(255, 159, 64, 0.8)",
				    pointHoverRadius: 5,
				    pointHoverBackgroundColor: "rgba(255, 159, 64, 1)",
				    pointHitRadius: 50,
				    pointBorderWidth: 2,
				    data: [] // 나중에 값 들어감
				},
				{
				    label: "구매자 회원 수",
				    lineTension: 0.3,
				    backgroundColor: "rgba(255, 0, 0, 0.4)",
				    borderColor: "rgba(255, 0, 0, 1)",
				    pointRadius: 5,
				    pointBackgroundColor: "rgba(241, 242 ,237 ,1)",
				    pointBorderColor: "rgba(255, 0, 0, 0.8)",
				    pointHoverRadius: 5,
				    pointHoverBackgroundColor: "rgba(255, 0, 0, 1)",
				    pointHitRadius: 50,
				    pointBorderWidth: 2,
				    data: [] // 나중에 값 들어감
				},
				{
				    label: "전체 판매자 수익",
				    lineTension: 0.3,
				    backgroundColor: "rgba(54, 162, 235, 0.4)",
				    borderColor: "rgba(54, 162, 235, 1)",
				    pointRadius: 5,
				    pointBackgroundColor: "rgba(241, 242 ,237 ,1)",
				    pointBorderColor: "rgba(54, 162, 235, 0.8)",
				    pointHoverRadius: 5,
				    pointHoverBackgroundColor: "rgba(54, 162, 235, 1)",
				    pointHitRadius: 50,
				    pointBorderWidth: 2,
				    data: [] // 나중에 값 들어감
				}
            ],
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

    // 총 수익 체크박스 이벤트 핸들러
    $('#revenue_total').change(function() {
        if (this.checked) {
			updateLabels(revenue_labels);
            unhideData(myChart, 0);
            
            $('#sellerCount').prop('checked', false);
            $('#buyerCount').prop('checked', false);
            $('#sellerProfit').prop('checked', false);
            hideData(myChart, 4);
            hideData(myChart, 5);
            hideData(myChart, 6);
        } else {
            // 체크 해제되면 데이터 제거
            hideData(myChart, 0);
        }
    });

    // 수수료 수익 체크박스 이벤트 핸들러
    $('#revenue_commission').change(function() {
        if (this.checked) {
			updateLabels(revenue_labels);
            // 체크되면 데이터 추가
            unhideData(myChart, 1);
            
            $('#sellerCount').prop('checked', false);
            $('#buyerCount').prop('checked', false);
            $('#sellerProfit').prop('checked', false);
            hideData(myChart, 4);
            hideData(myChart, 5);
            hideData(myChart, 6);
        } else {
            // 체크 해제되면 데이터 제거
            hideData(myChart, 1);
        }
    });
    
 	// 광고 수익 체크박스 이벤트 핸들러
    $('#revenue_advertising').change(function() {
        if (this.checked) {
			updateLabels(revenue_labels);
            // 체크되면 데이터 추가
            unhideData(myChart, 2);
            
            $('#sellerCount').prop('checked', false);
            $('#buyerCount').prop('checked', false);
            $('#sellerProfit').prop('checked', false);
            hideData(myChart, 4);
            hideData(myChart, 5);
            hideData(myChart, 6);
        } else {
            // 체크 해제되면 데이터 제거
            hideData(myChart, 2);
        }
    });
 
 	// 멤버쉽 수익 체크박스 이벤트 핸들러
    $('#revenue_membership').change(function() {
        if (this.checked) {
			updateLabels(revenue_labels);
            // 체크되면 데이터 추가
            unhideData(myChart, 3);
            
            $('#sellerCount').prop('checked', false);
            $('#buyerCount').prop('checked', false);
            $('#sellerProfit').prop('checked', false);
            hideData(myChart, 4);
            hideData(myChart, 5);
            hideData(myChart, 6);
        } else {
            // 체크 해제되면 데이터 제거
            hideData(myChart, 3);
        }
    });
    
    // 판매자 회원 수 체크박스 이벤트 핸들러
    $('#sellerCount').change(function() {
        if (this.checked) {
			updateLabels(seller_labels);
            // 체크되면 데이터 추가
            unhideData(myChart, 4);
            
			// 다른 체크박스들의 체크를 풀어버림
	        $('#revenue_total').prop('checked', false);
	        $('#revenue_commission').prop('checked', false);
	        $('#revenue_advertising').prop('checked', false);
	        $('#revenue_membership').prop('checked', false);
	        $('#buyerCount').prop('checked', false);
	        $('#sellerProfit').prop('checked', false);
	        // 다른 데이터를 숨김
	        hideData(myChart, 0);
	        hideData(myChart, 1);
	        hideData(myChart, 2);
	        hideData(myChart, 3);
	        hideData(myChart, 5);
	        hideData(myChart, 6);
        } else {
            // 체크 해제되면 데이터 제거
            hideData(myChart, 4);
        }
    });
    
    $('#sellerProfit').change(function() {
        if (this.checked) {
			updateLabels(seller_profit_labels);
            // 체크되면 데이터 추가
            unhideData(myChart, 6);
            
			// 다른 체크박스들의 체크를 풀어버림
	        $('#revenue_total').prop('checked', false);
	        $('#revenue_commission').prop('checked', false);
	        $('#revenue_advertising').prop('checked', false);
	        $('#revenue_membership').prop('checked', false);
	        $('#buyerCount').prop('checked', false);
	        $('#sellerCount').prop('checked', false);
	        // 다른 데이터를 숨김
	        hideData(myChart, 0);
	        hideData(myChart, 1);
	        hideData(myChart, 2);
	        hideData(myChart, 3);
	        hideData(myChart, 4);
	        hideData(myChart, 5);
        } else {
            // 체크 해제되면 데이터 제거
            hideData(myChart, 6);
        }
    });
    
    // 구매자 회원 수 체크박스 이벤트 핸들러
    $('#buyerCount').change(function() {
        if (this.checked) {
			updateLabels(user_labels);
            // 체크되면 데이터 추가
            unhideData(myChart, 5);
            
			// 다른 체크박스들의 체크를 풀어버림
	        $('#revenue_total').prop('checked', false);
	        $('#revenue_commission').prop('checked', false);
	        $('#revenue_advertising').prop('checked', false);
	        $('#revenue_membership').prop('checked', false);
	        $('#sellerCount').prop('checked', false);
	        $('#sellerProfit').prop('checked', false);
	        // 다른 데이터를 숨김
	        hideData(myChart, 0);
	        hideData(myChart, 1);
	        hideData(myChart, 2);
	        hideData(myChart, 3);
	        hideData(myChart, 4);
	        hideData(myChart, 6);
        } else {
            // 체크 해제되면 데이터 제거
            hideData(myChart, 5);
        }
    });


    // 기간 변경 및 값 변경

    // 주간 버튼 클릭 이벤트 핸들러
    $('#weeklyChartButton').click(function() {
        sendChartWeekDateRequest();
    });

    // 월간 버튼 클릭 이벤트 핸들러
    $('#monthlyChartButton').click(function() {
        sendChartMonthDateRequest();
    });

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
        chart.data.datasets[2].backgroundColor = "rgba(255, 206, 86, 0.4)";
        chart.data.datasets[3].backgroundColor = "rgba(75, 192, 192, 0.4)";
        chart.data.datasets[4].backgroundColor = "rgba(255, 159, 64, 0.4)";
        chart.data.datasets[5].backgroundColor = "rgba(255, 0, 0, 0.4)";
        chart.data.datasets[6].backgroundColor = "rgba(54, 162, 235, 0.4)";
        chart.update();
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

 	
    // Datepicker 초기화 및 이벤트 핸들러 설정
    initializeDatepicker();

    // Datepicker 초기화 및 설정 함수
    function initializeDatepicker() {
        var startDate = new Date();
        var endDate = new Date();
        // Datepicker 초기화
        $("#startDatepicker, #endDatepicker").datepicker({
            dateFormat: 'yy-mm-dd',
            showOtherMonths: true,
            showMonthAfterYear: true,
            changeYear: true,
            changeMonth: true,
            showOn: "both",
            buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
            buttonImageOnly: true,
            buttonText: "선택",
            yearSuffix: "년",
            monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
            monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
            dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
            minDate: "-1M",
            maxDate: "+1M",
            onSelect: function(selectedDate) {
                if (this.id === 'startDatepicker') {
                    startDate = new Date(selectedDate);
                    if (endDate && startDate > endDate) {
                        endDate = startDate;
                        $("#endDatepicker").datepicker("setDate", endDate);
                    } else {
                        $("#startDatepicker").datepicker("setDate", startDate);
                    }
                } else if (this.id === 'endDatepicker') {
                    endDate = new Date(selectedDate);
                    if (startDate && endDate < startDate) {
                        startDate = endDate;
                        $("#startDatepicker").datepicker("setDate", startDate);
                    } else {
                        $("#endDatepicker").datepicker("setDate", endDate);
                    }
                }
            }
        });

        // 초기값 설정
        $('#startDatepicker').datepicker('setDate', startDate);
        $('#endDatepicker').datepicker('setDate', endDate);
    }

    // 날짜 설정 후 적용버튼 눌렀을 때 호출되는 함수
    function sendChartDateRequest(startDate, endDate) {
        // 선택한 날짜를 JavaScript 객체에 저장
        var dateData = {
            startDate: startDate,
            endDate: endDate
        };

        var jsonData = JSON.stringify(dateData);

        // AJAX 요청
        $.ajax({
            url: 'adminRevenueDate',
            type: "POST",
            contentType: "application/json",
            data: jsonData,
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                revenueUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
        
        $.ajax({
            url: 'adminSellerDate',
            type: "POST",
            contentType: "application/json",
            data: jsonData,
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                sellerUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
        
        $.ajax({
            url: 'adminSellerProfitDate',
            type: "POST",
            contentType: "application/json",
            data: jsonData,
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                sellerProfitUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
        
        $.ajax({
            url: 'adminBuyerDate',
            type: "POST",
            contentType: "application/json",
            data: jsonData,
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                buyerUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
    }
    
    // 주간 버튼 눌렀을 때 요청되는 함수
    function sendChartWeekDateRequest() {
		// AJAX 요청
        $.ajax({
            url: 'adminTotalWeek',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({}),
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                revenueUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
        $.ajax({
            url: 'adminSellerWeek',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({}),
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                sellerUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
        $.ajax({
            url: 'adminSellerProfitWeek',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({}),
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                sellerProfitUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
        $.ajax({
            url: 'adminBuyerWeek',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({}),
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                buyerUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
	}
	
	// 월간 버튼 눌렀을 때 요청되는 함수
    function sendChartMonthDateRequest() {
		// AJAX 요청
        $.ajax({
            url: 'adminTotalMonth',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({}),
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                revenueUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
        $.ajax({
            url: 'adminSellerMonth',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({}),
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                sellerUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
        $.ajax({
            url: 'adminSellerProfitMonth',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({}),
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                sellerProfitUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
        $.ajax({
            url: 'adminBuyerMonth',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({}),
            success: function(response) {
                // 서버로부터 받은 응답을 처리하는 코드
                buyerUpdateChart(response);
            },
            error: function(xhr, status, error) {
                // 에러 처리 코드
            }
        });
	}

 	// 수익 차트를 업데이트하는 함수
    function revenueUpdateChart(data) {
 		
        // data를 사용하여 차트를 업데이트하는 코드
        
        // 데이터 넣을 공간
        var revenue_total = [];
        var revenue_commission = [];
        var revenue_advertising = [];
        var revenue_membership = [];
        var revenue_label = [];
        for (var i = 0; i < data.length; i++) {
        	revenue_total.push(data[i].revenue_total);
        	revenue_commission.push(data[i].revenue_commission);
        	revenue_advertising.push(data[i].revenue_advertising);
        	revenue_membership.push(data[i].revenue_membership);
            revenue_label.push(data[i].revenue_date); // revenue_date는 데이터에서 날짜를 나타내는 필드입니다.
            
        }
        // 차트 업데이트
        myChart.data.datasets[0].data = revenue_total;
        myChart.data.datasets[1].data = revenue_commission;
        myChart.data.datasets[2].data = revenue_advertising;
        myChart.data.datasets[3].data = revenue_membership;
        
     	// 체크박스 체크 여부에 따라 데이터셋 숨김 여부 설정
        myChart.data.datasets[0].hidden = !$('#revenue_total').is(':checked'); 
        myChart.data.datasets[1].hidden = !$('#revenue_commission').is(':checked');
        myChart.data.datasets[2].hidden = !$('#revenue_advertising').is(':checked');
        myChart.data.datasets[3].hidden = !$('#revenue_membership').is(':checked');
        
        revenue_labels = revenue_label;
        
        myChart.update();
        
        console.log('revenue_total : '+revenue_total[0]);
        console.log('labels : '+revenue_label[0]);
        
        if (!$('#revenue_total').is(':checked') && !$('#revenue_commission').is(':checked') 
        && !$('#revenue_advertising').is(':checked') && !$('#revenue_membership').is(':checked')){
			
        }else {
			updateLabels(revenue_label);
		}
    }
    
    // 판매자 차트를 업데이트하는 함수
    function sellerUpdateChart(data) {
 		
        // data를 사용하여 차트를 업데이트하는 코드
        
        // 데이터 넣을 공간
        var seller_count = [];
        var seller_label = [];
        for (var i = 0; i < data.length; i++) {
        	seller_count.push(data[i].seller_count);
        	seller_label.push(new Date(data[i].seller_access_date).toLocaleDateString('ko-KR'));
        	
        }
        // 차트 업데이트
        myChart.data.datasets[4].data = seller_count;
		
		seller_labels = seller_label;
        
     	// 체크박스 체크 여부에 따라 데이터셋 숨김 여부 설정
        myChart.data.datasets[4].hidden = !$('#sellerCount').is(':checked');
        
        if (!$('#sellerCount').is(':checked')) {
			
		} else {
			updateLabels(seller_label);
		}
        
        myChart.update();
    }
    
    // 판매자 수익 차트를 업데이트하는 함수
    function sellerProfitUpdateChart(data) {
 		
        // data를 사용하여 차트를 업데이트하는 코드
        
        // 데이터 넣을 공간
        var seller_profit = [];
        var seller_profit_label = [];
        for (var i = 0; i < data.length; i++) {
        	seller_profit.push(data[i].seller_profit);
        	seller_profit_label.push(new Date(data[i].gen_date).toLocaleDateString('ko-KR'));
        	
        }
        // 차트 업데이트
        myChart.data.datasets[6].data = seller_profit;
		
		seller_profit_labels = seller_profit_label;
        
     	// 체크박스 체크 여부에 따라 데이터셋 숨김 여부 설정
        myChart.data.datasets[6].hidden = !$('#sellerProfit').is(':checked');
        
        if (!$('#sellerProfit').is(':checked')) {
			
		} else {
			updateLabels(seller_profit_labels);
		}
        
        myChart.update();
    }
    
    // 판매자 차트를 업데이트하는 함수
    function buyerUpdateChart(data) {
 		
        // data를 사용하여 차트를 업데이트하는 코드
        
        // 데이터 넣을 공간
        var user_count = [];
        var user_label = [];
        for (var i = 0; i < data.length; i++) {
        	user_count.push(data[i].user_count);
        	user_label.push(new Date(data[i].user_access_date).toLocaleDateString('ko-KR'));
        }
        // 차트 업데이트
        myChart.data.datasets[5].data = user_count;
		
		user_labels = user_label;
        
     	// 체크박스 체크 여부에 따라 데이터셋 숨김 여부 설정
        myChart.data.datasets[5].hidden = !$('#buyerCount').is(':checked'); 
        
        if (!$('#buyerCount').is(':checked')) {
			
		} else {
			updateLabels(user_label);
		}
        
        myChart.update();
    }

    // labels 업데이트 함수
    function updateLabels(newLabels) {
        myChart.data.labels = newLabels;
        myChart.update();
    }
    
    
 	// dateApplyBtn 버튼 클릭 이벤트 핸들러
    $('#dateApplyBtn').click(function() {
        // 선택한 날짜 가져오기
        var startDate = $("#startDatepicker").val();
        var endDate = $("#endDatepicker").val();
        sendChartDateRequest(startDate, endDate);
    });

});
