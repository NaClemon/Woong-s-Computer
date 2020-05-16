package com.dev.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.ComputerService;
import com.dev.vo.ComputerVO;
import com.dev.vo.GameVO;

public class ComSumController implements Controller {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

		int cpu = (int)Integer.parseInt(request.getParameter("cpu"));
		int ram = (int)Integer.parseInt(request.getParameter("ram"));
		int gpu = (int)Integer.parseInt(request.getParameter("gpu"));
		int mb = (int)Integer.parseInt(request.getParameter("mb"));
		int case1 = (int)Integer.parseInt(request.getParameter("case"));
		int hdd = (int)Integer.parseInt(request.getParameter("hdd"));
		int ssd = (int)Integer.parseInt(request.getParameter("ssd"));
		int power = (int)Integer.parseInt(request.getParameter("power"));
		int sum = 0;
		
		ComputerVO gm = new ComputerVO();
		gm.setCpu_id(cpu);
		gm.setRam_id(ram);
		gm.setVga_id(gpu);
		gm.setMb_id(mb);
		gm.setCase_id(case1);
		gm.setHdd_id(hdd);
		gm.setSsd_id(ssd);
		gm.setPower_id(power);
		
		ComputerService service = ComputerService.getInstance();
		ArrayList<ComputerVO> list_cpu = service.pricecpu(gm);
		ArrayList<ComputerVO> list_ram = service.priceram(gm);
		ArrayList<ComputerVO> list_gpu = service.pricegpu(gm);
		ArrayList<ComputerVO> list_mb = service.pricemb(gm);
		ArrayList<ComputerVO> list_case = service.pricecase(gm);
		ArrayList<ComputerVO> list_hdd = service.pricehdd(gm);
		ArrayList<ComputerVO> list_ssd = service.pricessd(gm);
		ArrayList<ComputerVO> list_power = service.pricepower(gm);
		
		
		sum += list_cpu.get(0).getCpu_price();
		sum += list_ram.get(0).getRam_price();
		sum += list_gpu.get(0).getVga_price();
		sum += list_mb.get(0).getMb_price();
		sum += list_case.get(0).getCase_price();
		sum += list_hdd.get(0).getHdd_price();
		sum += list_ssd.get(0).getSsd_price();
		sum += list_power.get(0).getPower_price();
		
		request.setAttribute("sum", sum);
		HttpUtil.forward(request, response, "calc.jsp");
	}
	
}
