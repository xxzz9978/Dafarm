
const pathname = "/" + window.location.pathname.split("/")[1] + "/";
const origin = window.location.origin;

const contextPath = origin + pathname;

$(document).on('click', '#logout', function(e) {
    e.preventDefault(); // 기본 동작(페이지 이동)을 막음
    Swal.fire({
        title: "로그아웃",
        text: "로그아웃 하시겠습니까?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "로그아웃",
        cancelButtonText: "취소"
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire({
                title: "로그아웃",
                text: "로그아웃 되었습니다.",
                icon: "success"
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = contextPath+'/Admin/login/logout'; // 로그아웃 성공 시 이동할 페이지 지정
                }
            });
        }
    });
});