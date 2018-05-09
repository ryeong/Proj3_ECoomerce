package proj.ecom.product.domain;

public class SearchCriteria extends Criteria{
	
	//기존의 Criteria가 갖고있는 page, perPage 뿐만 아니라 searchType, keyword도 사용할 수 있다
	
	private String searchType;//검색기준
	private String keyword;
	
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
}
