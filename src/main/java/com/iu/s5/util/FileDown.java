package com.iu.s5.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDown extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BoardFileVO boardFileVO = (BoardFileVO)model.get("file");
		String fileName = boardFileVO.getFileName();
		String path = "";
		if(boardFileVO.getBoard()==1) {
			path="/resources/uploadnotice";
		} else {
			path = "/resources/uploadqna";
		}
		path = request.getSession().getServletContext().getRealPath("path");
		
		//hdd에서 파일을 읽을 준비
		File file = new File(path, fileName);
		//파일 크기 전송 처리
		response.setContentLength((int)file.length());
		
		//다운로드시 파일 이름 인코딩
		String downName = URLEncoder.encode(boardFileVO.getOrname(),"UTF-8");
		
		//header 설정
		response.setHeader("Content-disposition", "attachment;filename=\""+downName+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		//stream 연결해서 전송
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
		
	}
	
}
