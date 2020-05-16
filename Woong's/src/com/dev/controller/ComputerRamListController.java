package com.dev.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.ComputerService;
import com.dev.vo.ComputerVO;

public class ComputerRamListController implements Controller {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		ComputerService service = ComputerService.getInstance();
		ArrayList<ComputerVO> list = service.computerRamList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/computerRamListOutput.jsp");
	}
	
}
