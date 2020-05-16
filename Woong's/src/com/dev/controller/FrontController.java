package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String,Controller>list = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		charset = sc.getInitParameter("charset");
		list = new HashMap<String,Controller>();
		list.put("/gamelist.do", new GameListController());
		list.put("/gamesearch.do", new GameInsertController());
		list.put("/gamedetail.do", new GameDetailController());
		list.put("/min_com.do", new MinComController());
		list.put("/rec_com.do", new RecComController());
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberList.do", new GameListController());
		list.put("/memberLogin.do", new MemberloginController());
		list.put("/min_com.do", new MinComController());
		list.put("/rec_com.do", new RecComController());
		list.put("/calccom.do", new ComSumController());
		list.put("/computerVgaList.do", new ComputerVgaListController());
		list.put("/computerRamList.do", new ComputerRamListController());
		list.put("/computerPowList.do", new ComputerPowListController());
		list.put("/computerMaiList.do", new ComputerMaiListController());
		list.put("/computerHddList.do", new ComputerHddListController());
		list.put("/computerSsdList.do", new ComputerSsdListController());
		list.put("/computerCpuList.do", new ComputerCpuListController());
		list.put("/computerCasList.do", new ComputerCasListController());
	}

	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding(charset);
		String url = request.getRequestURI();
		String contextPath =request.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = list.get(path);
		subController.excute(request,response);
	}

}
