package proj.ecom.util;

public class Criteria { //PageTO와 비슷한 기능. 페이징 처리를 위해
	private int page;
	private int perPage;
	
	
	
	public Criteria() {
		page=1;
		perPage=10;
		
	}

	public Criteria(int page, int perPage) {
		super();
		this.page = page;
		this.perPage = perPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	
	public int getStartRow() {
		return (page-1)*perPage+1;
	}
	public int getEndRow() {
		return page*perPage;
	}
	
	
}
