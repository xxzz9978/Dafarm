
//로고 버튼 요소 가져오기
var logo = document.getElementsByClassName('logo')[0];
//로고 버튼 이벤트 리스너 추가
    logo.addEventListener('click', function(){
        console.log('로고 버튼이 클릭되었습니다.')
        // 프로젝트의 루트 페이지로 이동
    window.location.href = '../main/DAFARM.html';
    });

//구매하기 버튼 요소 가져오기
var Purchase = document.getElementById('Purchase');
//구매하기 버튼 이벤트 리스너 추가
Purchase.addEventListener('click', function(){
    
    console.log('구매하기 버튼이 클릭되었습니다.');
    // 프로젝트의 루트 페이지로 이동
    window.location.href = 'http://localhost:8088/2nd_PJT_Test/UserPage/DAFARM_Purchase/DAFARM_Purchase.jsp';

});
