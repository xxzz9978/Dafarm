const pathname3 = "/" + window.location.pathname.split("/")[1] + "/";
const origin3 = window.location.origin;
const contextPath3 = origin3 + pathname3;

function board_modify(e) {
	e.preventDefault();
	Swal.fire({
		title: "게시글 수정",
		text: "게시글을 수정 하시겠습니까?",
		icon: "warning",
		showCancelButton: true,
		confirmButtonColor: "#0d6efd",
		cancelButtonColor: "#dc3545",
		confirmButtonText: "수정",
		cancelButtonText: "계속 작성하기"
	}).then((result) => {
		if (result.isConfirmed) {
			$.post(contextPath3 + 'Admin/board/AdminSellerBoardModify_pro', $('#adminSellerBoardBean').serialize(), function(response) {
				Swal.fire({
					title: "게시글 수정",
					text: "게시글이 수정 되었습니다.",
					icon: "success"
				}).then((result) => {
					if (result.isConfirmed) {
						window.location.href = contextPath3 + 'Admin/board/AdminSellerBoardList';
					}
				});
			}).fail(function(xhr, status, error) {
				console.error(xhr.responseText);
				Swal.fire({
					title: "오류",
					text: "수정 중 오류가 발생했습니다.",
					icon: "error"
				});
			});
		}
	});
};

function board_delete(e, seller_board_num) {
	e.preventDefault();
	Swal.fire({
		title: "게시글 삭제",
		text: "게시글을 삭제 하시겠습니까?",
		icon: "warning",
		showCancelButton: true,
		confirmButtonColor: "#d33",
		cancelButtonColor: "#008748",
		confirmButtonText: "삭제",
		cancelButtonText: "취소"
	}).then((result) => {
		if (result.isConfirmed) {
			$.post(contextPath3 + 'Admin/board/AdminSellerBoardDelete', { seller_board_num: seller_board_num }, function(response) {

				Swal.fire({
					title: "게시글 삭제",
					text: "게시글이 삭제 되었습니다.",
					icon: "success"
				}).then((result) => {
					if (result.isConfirmed) {
						window.location.href = contextPath3 + 'Admin/board/AdminSellerBoardList';
					}
				});
			}).fail(function(xhr, status, error) {

				console.error(xhr.responseText);
				Swal.fire({
					title: "오류",
					text: "삭제 중 오류가 발생했습니다.",
					icon: "error"
				});
			});
		}
	});
};

function board_modify_cancel2(e) {
	e.preventDefault();
	Swal.fire({
		title: "게시글 수정",
		text: "게시글 수정을 취소 하시겠습니까?",
		icon: "warning",
		showCancelButton: true,
		confirmButtonColor: "#d33",
		cancelButtonColor: "#008748",
		confirmButtonText: "취소",
		cancelButtonText: "계속 작성하기"
	}).then((result) => {
		if (result.isConfirmed) {
			$.get(contextPath3 + 'Admin/board/AdminSellerBoardList', function(response) {

				Swal.fire({
					title: "게시글 수정",
					text: "게시글 수정이 취소 되었습니다.",
					icon: "success"
				}).then((result) => {
					if (result.isConfirmed) {
						window.location.href = contextPath3 + 'Admin/board/AdminSellerBoardList';
					}
				});
			}).fail(function(xhr, status, error) {

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