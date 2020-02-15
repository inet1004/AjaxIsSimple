package com.yedam.board;

public class BoardDTO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String creationDate;
	private int parentNo;
	/**
	 * @return the boardNo
	 */
	public int getBoardNo() {
		return boardNo;
	}
	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", creationDate=" + creationDate + ", parentNo=" + parentNo + "]";
	}
	/**
	 * @param boardNo the boardNo to set
	 */
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}
	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}
	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the parentNo
	 */
	public int getParentNo() {
		return parentNo;
	}
	/**
	 * @param parentNo the parentNo to set
	 */
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
}
