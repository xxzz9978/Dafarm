const pathname3 = "/" + window.location.pathname.split("/")[1] + "/";
const origin3 = window.location.origin;
const contextPath3 = origin3 + pathname3;

function board_write_cancel(e) {
    e.preventDefault(); // 기본 동작(페이지 이동)을 막음
    Swal.fire({
        title: "게시글 작성 취소",
        text: "작성을 취소 하시겠습니까?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#d33",
        cancelButtonColor: "#008748",
        confirmButtonText: "작성 취소",
        cancelButtonText: "계속 작성하기"
    }).then((result) => {
        if (result.isConfirmed) {
            $.get(contextPath3 + 'Admin/board/AdminUserBoardList', function(response) {
                // 성공적으로 처리된 후 실행될 코드
                Swal.fire({
                    title: "게시글 작성 취소",
                    text: "작성이 취소 되었습니다.",
                    icon: "success"
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = contextPath3 + 'Admin/board/AdminUserBoardList';
                    }
                });
            }).fail(function(xhr, status, error) {
                // 오류가 발생한 경우 실행될 코드
                console.error(xhr.responseText);
                Swal.fire({
                    title: "오류",
                    text: "취소 중 오류가 발생했습니다.",
                    icon: "error"
                });
            });
        }
    });
};

function board_write(e) {
    e.preventDefault(); // 기본 동작(페이지 이동)을 막음
    $.post(contextPath3 + 'Admin/board/AdminUserBoardWrite_pro', function(response) {
    Swal.fire({
        title: "게시글 작성",
        text: "게시글이 작성 되었습니다.",
        icon: "success"
    	}).then((result) => {
        	if (result.isConfirmed) {
        	    window.location.href = contextPath3 + 'Admin/board/AdminUserBoardList';
        	}
    	});
	});
};