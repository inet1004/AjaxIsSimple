package com.yedam.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl extends BoardService {

	@Override
	public void insertBoard(BoardDTO board) {
		String sql = "INSERT INTO BOARD VALUES( " + "(SELECT NVL(MAX(BOARD_NO),0) + 1 FROM BOARD), " + "?," + "?,"
				+ "?," + "SYSDATE," + "NULL)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateBoard(BoardDTO board) {

	}

	@Override
	public BoardDTO getBoard(int boardNo) {
		String sql="select * from board where board_no=?";
		BoardDTO b=new BoardDTO();
		
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,boardNo);
			rs = pstmt.executeQuery();   ////////////////////////////
			
		} catch (Exception e) {
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b;
	}

	public List<BoardDTO> getReplyList(int boardNo) {
		String sql = "select * from board where parent_no = ? order by 1 desc";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,boardNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO b = new BoardDTO();
				b.setBoardNo(rs.getInt("board_no"));
				b.setContent(rs.getString("content"));
				b.setCreationDate(rs.getString("creation_date"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setParentNo(rs.getInt("parent_no"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	@Override
	public List<BoardDTO> getBoardList(BoardDTO board) {
		String sql = "select * from board where parent_no is null order by 1 desc";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO b = new BoardDTO();
				b.setBoardNo(rs.getInt("board_no"));
				b.setContent(rs.getString("content"));
				b.setCreationDate(rs.getString("creation_date"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;

	}

}
