package com.dev.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.ComputerService;
import com.dev.vo.ComputerVO;
import com.dev.vo.GameVO;

public class RecComController implements Controller {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		int mincpu = Integer.parseInt(request.getParameter("reccpu"));
		int minram = Integer.parseInt(request.getParameter("recram"));
		int mingpu = Integer.parseInt(request.getParameter("recgpu"));
		String gname = request.getParameter("game_name");
		int sum = 0;
		
		ComputerVO gm = new ComputerVO();
		gm.setCpu(mincpu);
		gm.setRam(minram);
		gm.setGpu(mingpu);
		gm.setGame_name(gname);
		
		ComputerService service = ComputerService.getInstance();
		ArrayList<ComputerVO> list_cpu = service.reccpu(gm);
		ArrayList<ComputerVO> list_ram = service.recram(gm);
		ArrayList<ComputerVO> list_gpu = service.recgpu(gm);
		ArrayList<ComputerVO> list_mb = service.minmb(gm);
		ArrayList<ComputerVO> list_case = service.mincase(gm);
		ArrayList<ComputerVO> list_hdd = service.minhdd(gm);
		ArrayList<ComputerVO> list_ssd = service.minssd(gm);
		ArrayList<ComputerVO> list_power = service.minpower(gm);
		
		request.setAttribute("list_cpu", list_cpu);
		request.setAttribute("list_ram", list_ram);
		request.setAttribute("list_gpu", list_gpu);
		request.setAttribute("list_mb", list_mb);
		request.setAttribute("list_case", list_case);
		request.setAttribute("list_hdd", list_hdd);
		request.setAttribute("list_ssd", list_ssd);
		request.setAttribute("list_power", list_power);
		request.setAttribute("sum", sum);
		HttpUtil.forward(request, response, "rec_computer.jsp");
	}
	
}
