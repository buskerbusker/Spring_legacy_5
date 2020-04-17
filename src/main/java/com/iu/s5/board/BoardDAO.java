package com.iu.s5.board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	// 멤버변수로 상수만을 가짐
	// 추상메서드만 가능
	// 접근제어자는 무조건 public
	// public abstract. 생략가능

	// List
	public List<BoardVO> boardList(Map<String, Integer> map) throws Exception;

	// select
	public BoardVO boardSelect(long num) throws Exception;

	// insert
	public int boardWrite(BoardVO boardVO) throws Exception;

	// delete
	public int boardDelete(long num) throws Exception;

	// update
	public int boardUpdate(BoardVO boardVO) throws Exception;

	// hit update
	public int hitUpdate(long num) throws Exception;

	// count
	public long boardCount() throws Exception;
}
