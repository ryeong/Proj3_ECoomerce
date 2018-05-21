package proj.ecom.util;

public class SearchCriteria extends Criteria{
	
	//기존의 Criteria가 갖고있는 page, perPage 뿐만 아니라  keyword도 사용할 수 있다
	//private String searchType; 검색기준
	private String keyword;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
