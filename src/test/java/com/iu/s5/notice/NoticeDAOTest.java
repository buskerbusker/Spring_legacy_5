package com.iu.s5.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase {

	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void daoIsnull() {
		assertNotNull(noticeDAO);
	}

	@Test
	public void boardWriteTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("title");
		noticeVO.setWriter("test writer");
		noticeVO.setContents("test Contents");
		int result = noticeDAO.boardWrite(noticeVO);
		assertEquals(1, result);
	}

	@Test
	public void boardDeleteTest() throws Exception {

		int result = noticeDAO.boardDelete(10);
		assertNotEquals(0, result);

	}

	@Test
	public void boardUpdateTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("수정");
		noticeVO.setWriter("수정가");
		noticeVO.setContents("수정내용");
		noticeVO.setNum(3);

		int result = noticeDAO.boardUpdate(noticeVO);
		assertEquals(1, result);
	}

	@Test
	public void boardHit() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setHit(1);
		noticeVO.setNum(9);
		int result = noticeDAO.boardHit(noticeVO);
		assertEquals(1, result);
	}
}
