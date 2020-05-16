package com.dev.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.GameService;
import com.dev.vo.GameVO;

public class GameDetailController implements Controller {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		String url = request.getParameter("game_url");
		
		GameVO game = new GameVO();
		game.setImg_url(url);
		
		GameService service = GameService.getInstance();
		ArrayList<GameVO> list = service.gameDetail(game);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "game_detail.jsp");
	}
	
}
