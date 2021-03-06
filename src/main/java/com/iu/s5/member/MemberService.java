package com.iu.s5.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s5.member.memberFile.MemberFileDAO;
import com.iu.s5.member.memberFile.MemberFileVO;
import com.iu.s5.util.FileSaver;
import com.iu.s5.util.Pager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private MemberFileDAO memberFileDAO;
	
	public List<MemberVO> memberList(Pager memberPager)throws Exception{
		memberPager.makeRow();
		long totalCount = memberDAO.memberCount(memberPager);
		memberPager.makePage(totalCount);
		return memberDAO.memberList(memberPager);
	}

	public int memberUpdate(MemberVO memberVO)throws Exception{
		return memberDAO.memberUpdate(memberVO);
	}
	
	public int memberDelete(MemberVO memberVO) throws Exception{
		return memberDAO.memberDelete(memberVO);
	}
	
	public MemberVO memberLogin(MemberVO memberDTO)throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	
	public int memberJoin(MemberVO memberVO, MultipartFile avatar, HttpSession session)throws Exception{
		//HDD에 저장 resources/memberUpload/
		//1. 파일을 HDD 에 저장
		
		String path = session.getServletContext().getRealPath("/resources/memberUpload");
		System.out.println(path);
		String fileName = fileSaver.saveByUtils(avatar, path);
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(memberVO.getId());
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriName(avatar.getOriginalFilename());
		//2. 파일명을 DB에 저장
		
		 int result = memberDAO.memberJoin(memberVO);
		 result = memberFileDAO.fileInsert(memberFileVO);
		return result;//memberDAO.memberJoin(memberVO);
	}
	
	public MemberFileVO fileSelect(String id)throws Exception{
		return memberFileDAO.fileSelect(id);		
	}

}
