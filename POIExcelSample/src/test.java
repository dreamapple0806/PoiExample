

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int page = 22;
		int countList = 10;
		int countPage = 10;
		int totalCount = 255;

		// ��ü ������ ��� 255 / 10 = 25 >>> 26�������� �Ǿ�� �Ѵ�.
		int totalPage = totalCount / countList;

		if (totalCount % countList > 0) {
			totalPage++;
		}

		// ���� ������ page �� ����� ��ü ���������� ũ�� ���� ������ ������ �ѹ��� ����
		if (totalPage < page) {
			page = totalPage;
		}

		// ���� ������ �������� ���� ù��° ������, ������ �������� ������� ���
		// ���� �������� 22�������� startPage : 21, endPage : 26
		int startPage = ((page - 1) / 10) * 10 + 1;
		int endPage = startPage + countPage - 1;

		// ���⼭ ������ �������� �������ݴϴ�.
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		if (startPage > 1) {
			System.out.print("<a href=\"?page=1\">ó��</a>");
		}

		if (page > 1) {
			System.out.println("<a href=\"?page=" + (page - 1) + "\">����</a>");
		}
		
		// [paging]
		// �� �κ��� �Ʒ����� �߰��� �����մϴ�.
		for (int iCount = startPage; iCount <= endPage; iCount++) {
			System.out.print("<b> " + iCount + " </b> ");
		}
		
		if (page < totalPage) {
			System.out.println("<a href=\"?page=" + (page + 1) + "\">����</a>");

		}

		if (endPage < totalPage) {
			System.out.print("<a href=\"?page=" + totalPage + "\">��</a>");
		}
	}

}
