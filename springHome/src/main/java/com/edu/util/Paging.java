package com.edu.util;

import java.io.Serializable;

public class Paging implements Serializable {
	
	public static final int PAGE_SCALE = 10;
	public static final int BLOCK_SCALE = 10;
//	Page : 	우리가 일반적으로 생각하는 하나의 게시물
	//* Page_scale : 한페이지(한 화면)에 보여지는 게시물의 갯수, 보고자 하는 목록의 갯수 (게시판에서 하나의 행을 차지하게 된다)
//	Block: 하나의 묶음 단위 (우리가 일반적으로 생각하던 페이지의 개념, 설정한 블럭스케일 만큼이 하나의 블럭이다 
//	ex) 현재블럭(페이지1부터 페이지10까지), 넥스트블럭(페이지11부터 페이지20까지) 
	//* Block_scale : 페이징 기술을 조작할수 있는 인터페이스에 관련된것, 몇 페이지까지 있는지를 알려줌
//					하나의 블럭안에는 페이지들이 들어갈수 있다 (여기선 1페이지부터 10페이지까지 하나의 블럭으로 보는것)
	
	private int curPage;  //current page: 현재 페이지 (현재의 위치)
	private int prevPage; // previous page: 이전 페이지
	private int nextPage; // 다음 페이지
	private int totPage; // total page: 전체 페이지
	private int totBlock; // 전체 페이지 블록 갯수
	private int curBlock; // 현재 블록 (ex:11~20페이지)
	private int prevBlock; // 이전 블록 (ex:1~10페이지)
	private int nextBlock; // 다음 블록 (ex:21~30페이지)
	
	// 데이터베이스에서 사용될 실제 게시물
	private int pageBegin; // db에서 들고올 실제 게시물 위치의 시작
	private int pageEnd;	// db에서 들고올 실제 게시물 위치의 끝
	
	
	private int blockBegin;	// 블록의 시작번호
	private int blockEnd;	// 블록의 끝번호
	
	// 생성자
	public Paging(int count, int curPage) {
		this.curBlock = 1;
		this.curPage = curPage;
		setTotPage(count);
		setPageRange();
		setTotBlock();
		setBlockRange();
	}
	
	public void setPageRange() {
		pageBegin = (curPage -1) * PAGE_SCALE + 1;
		pageEnd = pageBegin + PAGE_SCALE - 1;
	}
		
	public void setBlockRange() {
		curBlock = (int)Math.ceil((curPage - 1) / BLOCK_SCALE) + 1;
		blockBegin = (curBlock -1) * BLOCK_SCALE + 1;
		blockEnd = blockBegin + BLOCK_SCALE -1;
		
		if (blockEnd > totPage) {
			blockEnd = totPage;
		}
		
		// 삼항연산자
		// (boolean) ? c(true일경우) : d(false일경우)
		
		// 10페이지 단위씩 넘어가도록 강사님이 커스터마이징 함
		// (강사님은 1~10사이 어느 페이지든 현재페이지라 가정한 상태에서, nextPage 하면 11페이지로이동)
		// (보통은 nextPage는 현재 1페이지라면 2페이지가 된다)
		// << 눌렀을 경우
		prevPage = (curPage ==1) ? 1 : (curBlock -1)* BLOCK_SCALE;
		// >> 눌렀을 경우
		nextPage = curBlock > totBlock ? (curBlock * BLOCK_SCALE)
				: (curBlock * BLOCK_SCALE) + 1;
		
		// validation 체크!
		// 아무리 여러번 prevPage(<<)를 눌러도 , 음수페이지는 없으니 무조건 1페이지로 가도록 
		if (prevPage <= 0) {
			prevPage = 1;
		}
		// 아무리 여러번 nextPage(>>)를 눌러도, totPage를 넘어서는 안된다
		if (nextPage >= totPage) {
			nextPage = totPage;
		}
		
	}
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
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
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int count) {
		
		this.totPage = (int)Math.ceil(count * 1.0 / PAGE_SCALE); 
		// ceil 은 실수일 경우 무조건 올림처리 하라는 것
		// * 1.0 이 없이 그냥 (int)(count / PAGE_SCALE) 만 해버리면, int형 형변환 할때 몫값만 남고, 나머지값이 다 버려진다
		// ex) 게시물이 총 13개, 한페이지에 포함될 게시물 갯수(PAGE_SCALE)은 10개, *1.0을 안하면 총게시물 갯수를 충족하는 몫만 남아서 1페이지만 나타내게됨
		// 하지만 우리는 총게시물 갯수를 충족하지못하는 나머지 3개의 게시물도 보여주는 2페이지도 필요한것이다 -> 그래도 ceil을 통해 무조건 올림처리 한것
	}
	public int getTotBlock() {
		return totBlock;
	}
	public void setTotBlock() {
		this.totBlock = (int)Math.ceil( (double)totPage / (double)BLOCK_SCALE);
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public int getBlockBegin() {
		return blockBegin;
	}
	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}
	public int getBlockEnd() {
		return blockEnd;
	}
	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	
	
	
	
}
