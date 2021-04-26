

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int page = 22;
		int countList = 10;
		int countPage = 10;
		int totalCount = 255;

		// 전체 페이지 계산 255 / 10 = 25 >>> 26페이지가 되어야 한다.
		int totalPage = totalCount / countList;

		if (totalCount % countList > 0) {
			totalPage++;
		}

		// 현재 페이지 page 가 계산한 전체 페이지보다 크면 가장 마지막 페이지 넘버로 변경
		if (totalPage < page) {
			page = totalPage;
		}

		// 현재 페이지 기준으로 가장 첫번째 페이지, 마지막 페이지가 몇번인지 계산
		// 현재 페이지가 22페이지면 startPage : 21, endPage : 26
		int startPage = ((page - 1) / 10) * 10 + 1;
		int endPage = startPage + countPage - 1;

		// 여기서 마지막 페이지를 보정해줍니다.
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		if (startPage > 1) {
			System.out.print("<a href=\"?page=1\">처음</a>");
		}

		if (page > 1) {
			System.out.println("<a href=\"?page=" + (page - 1) + "\">이전</a>");
		}
		
		// [paging]
		// 이 부분은 아래에서 추가로 설명합니다.
		for (int iCount = startPage; iCount <= endPage; iCount++) {
			System.out.print("<b> " + iCount + " </b> ");
		}
		
		if (page < totalPage) {
			System.out.println("<a href=\"?page=" + (page + 1) + "\">다음</a>");

		}

		if (endPage < totalPage) {
			System.out.print("<a href=\"?page=" + totalPage + "\">끝</a>");
		}
	}

}
