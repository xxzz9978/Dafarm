const pathname2 = "/" + window.location.pathname.split("/")[1] + "/";
const origin2 = window.location.origin;
const contextPath2 = origin2 + pathname2;

function seller_delete(e, seller_num) {
    e.preventDefault(); // 기본 동작(페이지 이동)을 막음
    Swal.fire({
        title: "판매자 정보 삭제",
        text: "삭제 하시겠습니까?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#d33",
        cancelButtonColor: "#008748",
        confirmButtonText: "삭제",
        cancelButtonText: "취소"
    }).then((result) => {
        if (result.isConfirmed) {
            $.post(contextPath2 + 'Admin/table/AdminSellerDelete', {seller_num: seller_num}, function(response) {
                // 성공적으로 처리된 후 실행될 코드
                Swal.fire({
                    title: "판매자 정보 삭제",
                    text: "삭제 되었습니다.",
                    icon: "success"
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = contextPath2 + 'Admin/table/AdminSellerTables';
                    }
                });
            }).fail(function(xhr, status, error) {
                // 오류가 발생한 경우 실행될 코드
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