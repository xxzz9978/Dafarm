package kr.co.dafarm.bean;

public class UserBoardPageBean {

	private int min; // 최소 페이지 번호
	private int max; // 최대 페이지 번호
	private int prevPage; // 이전 버튼 페이지 번호
	private int nextPage; // 다음 버튼 페이지 번호
	private int pageCnt; // 전체 페이지 갯수
	private int currentPage; // 현재 페이지 갯수

	/*
	 * contentCnt : 전체 글 갯수 currentPage : 현재 페이지 번호
	 * contentPageCnt:페이지당 글 갯수(10)
	 * pageinationCnt : 한번에 표시할 페이지 버튼 최대 갯수
	 */

	public UserBoardPageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		
		this.currentPage = currentPage;
		//현재 페이지 번호
		
		pageCnt = contentCnt / contentPageCnt;
		//게시글 1/ 페이지당 글 갯수 10개 => 나머지가 0으로 떨어지지 않는 게시글의 수 + (1필요)
		//게시글 10/ 페이지당 글 갯수 10개 => 나머지가 0으로 떨어지는 게시글의 수 + (1필요x)
		
		if(contentCnt % contentPageCnt > 0) {
			pageCnt++;
		}
		//게시글의 갯수가 1~0 => 1페이지
		//게시글의 갯수가 11~19 => 2페이지
		
		min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1 ;
		//현재 페이지 1 ==> [1]부터 화면에 출력
		//현재 페이지 2 ==> [1]부터 화면에 출력
		//현재 페이지 10 ==> [1]부터 화면에 출력
		//현재 페이지 11 ==> [11]부터 화면에 출력
		//현재 페이지 19 ==> [11]부터 화면에 출력
		
		max = min + paginationCnt -1 ;
		//[1]이 최소 페이지, [10] 최대 페이지
		//[2]가 최소 페이지, [10] 최대
		//[10]가 최소 페이지, [10] 최대
		//[11]가 최소 페이지, [20] 최대
		//[19]가 최소 페이지, [20] 최대
		
		if(max>pageCnt) {
			max = pageCnt;
		}
		//현재 페이지가 2페이지,max페이지는 2페이지로 제한 => [10]x
		//현재 페이지가 9페이지,max페이지는 9페이지로 제한 => [10]x
		
		prevPage = min - 1;
		nextPage = max + 1;
		//이전 페이지는 최소 페이지에서 -1			<이전 [11] => [10]
		//다음 페이지는 최소 페이지에서 +1			[10] 다음> => [11]
		
		if(nextPage > pageCnt) {
			nextPage = pageCnt;
		}
		//최대페이지 제한
		//현재 페이지가 15페이지라면 nextPage는 15페이지로 조정
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
