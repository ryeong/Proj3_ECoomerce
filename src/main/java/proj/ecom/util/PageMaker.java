package proj.ecom.util;

public class PageMaker {
	private int totalCount; //전체 게시글의 수 500개
	private int startPageNum;
	private int endPageNum;
	private Criteria cri;
	private int totalPage; //총 몇 페이지가 필요한 지 50페이지

	public PageMaker() {
		
	}

	public PageMaker(int totalCount, int startPageNum, int endPageNum, Criteria cri) {
		super();
		this.totalCount = totalCount;
		this.startPageNum = startPageNum;
		this.endPageNum = endPageNum;
		this.cri = cri;
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		//1. 페이지가 추가되지 않을 때
		totalPage=totalCount/cri.getPerPage();
		
		//2. 페이지가 추가될 때
		if(totalCount%cri.getPerPage()!=0) {  
			++totalPage;
		}
		//조건문을 만든 이유 -> 만약에 totalcount가 10이고 perPage가 10이면 나누어떨어지는데 이때 무조건 ++totalPage를 하면 2페이지가 만들어지고 내용은 비어있게된다
		
		
		startPageNum=((cri.getPage()-1)/5)*5+1; 
		//21페이지이면  21, 22, 23, 24, 25, 26, 27, 28, 29, 30
		
		
		endPageNum=startPageNum+4;
		
		//만약에 45페이지까지 밖에 없으면 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 내용은 없는데 뒤에 페이지까지 다 만들어짐
		if(endPageNum>totalPage) {
			endPageNum=totalPage;  
			//41, 42, 43, 44, 45
		}
		
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
}
