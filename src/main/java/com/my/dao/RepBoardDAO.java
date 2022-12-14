package com.my.dao;

import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.vo.RepBoard;

public interface RepBoardDAO {
	public void delete(int board_no, String board_pwd) throws RemoveException;
	public void update(RepBoard board, String board_pwd) throws ModifyException;
	
	/**
	 * 조회수를 1증가한다
	 * @param board_no 게시물번호
	 * @throws ModifyException
	 */
	public void updateBoardCnt(int board_no) throws ModifyException;
	/**
	 * 게시물번호에 해당하는 게시물을 검색한다
	 * @param board_no 게시물번호
	 * @return 게시물
	 * @throws FindException 게시물번호에 만족하는 게시물이 없으면 예외가 발생한다
	 */
	public RepBoard selectByBoard_no(int board_no) throws FindException;
	
	/**
	 * 검색어에 만족하는 게시물들을 검색한다.
	 * @param word 검색어. 글제목 또는 작성자
	 * @return 게시물들
	 * @throws FindException 검색어에 만족하는 게시물이 없으면 예외가 발생한다
	 */
	public List<RepBoard> selectByBoard_titleORBoard_writer(String word) throws FindException;
	
	/**
	 * 게시물을 전체 검색한다
	 * @return 게시물들
	 * @throws FindException 저장소처리문제가 발생하거나 게시글이 없을때 예외가 발생한다
	 */
	public List<RepBoard> selectAll() throws FindException;
	/**
	 * 게시물을 추가한다
	 * @param board 게시물
	 * @throws AddException
	 */
	public void insert(RepBoard board) throws AddException;
}
