window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    var lang_kor = {
        "lengthMenu": "페이지당 표시 개수 _MENU_",
        "info": "총 _TOTAL_개의 항목 중 _START_부터 _END_까지 표시",
        "infoEmpty": "표시할 항목이 없습니다.",
        "infoFiltered": "(총 _MAX_개의 항목으로부터 검색됨)",
        "search": "검색:",
        "paginate": {
            "first": "첫 페이지",
            "last": "마지막 페이지",
            "next": "다음",
            "previous": "이전"
        },
        "aria": {
            "sortAscending": ": 오름차순으로 정렬",
            "sortDescending": ": 내림차순으로 정렬"
        },
        "perPage": "페이지 당 줄 수" // 이 부분을 추가
    };

    const buyertablesSimple = document.getElementById('buyertablesSimple');
    if (buyertablesSimple) {
        
        new simpleDatatables.DataTable(buyertablesSimple, {
            language: lang_kor
        });
    }
    
    const sellerDatatablesSimple = document.getElementById('sellertablesSimple');
    if (sellerDatatablesSimple) {
        new simpleDatatables.DataTable(sellerDatatablesSimple);
    }
    
    const boardDatatablesSimple = document.getElementById('boardDatatablesSimple');
    if (boardDatatablesSimple) {
        new simpleDatatables.DataTable(boardDatatablesSimple);
    }

    
});
