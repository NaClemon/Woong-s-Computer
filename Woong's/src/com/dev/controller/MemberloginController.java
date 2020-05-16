package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;


public class MemberloginController implements Controller{
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		String id =request.getParameter("id");
		String passwd = request.getParameter("passwd");		
		//�쑀�슚�꽦 泥댄겕 
		if(id.isEmpty() || passwd.isEmpty())
		{
			request.setAttribute("error","紐⑤뱺�빆紐⑹쓣 �엯�젰�빐二쇱꽭�슂.");
			HttpUtil.forward(request, response, "/memberLogin.jsp");
			return ;
		}
		
		//VO 媛앹껜�뿉 �뜲�씠�꽣 諛붿씤�뵫 
		MemberVO member =new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		
		//Service媛앹껜�쓽 硫붿냼�뱶 �샇異�
		MemberService service = MemberService.getInstance();
		int x =service.memberLogin(member);
		
		
		//Output view �럹�씠吏�濡� �씠�룞
		if(x==1)request.setAttribute("success", "�꽦怨�");
		request.setAttribute("id", id);
		request.setAttribute("x", x);
		HttpUtil.forward(request, response, "/result/log_state.jsp");
		
		
	}
}
