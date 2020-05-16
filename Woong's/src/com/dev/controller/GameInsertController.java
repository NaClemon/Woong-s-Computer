package com.dev.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.GameService;
import com.dev.vo.GameVO;


public class GameInsertController implements Controller{
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		String name = request.getParameter("game_name");
		String genre = request.getParameter("game_genre");
		
		GameVO game = new GameVO();
		game.setGame_name(name);
		game.setGenre_name(genre);
		
		GameService service = GameService.getInstance();
		ArrayList<GameVO> list = service.gameSelect(game);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "GameList.jsp");
	}
}
