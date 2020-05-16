package com.dev.dao;

import java.sql.*;
import java.util.ArrayList;

import com.dev.vo.GameVO;


public class GameDAO {
	
	private static GameDAO dao = new GameDAO();
	private GameDAO() {}
	public static GameDAO getInstance() {
		return dao;
	}
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbproject?useSSL=false","root","tmvjswl@2877");
		}catch (Exception e) {
			System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+e);
		}
		return conn;
	}
	
	public void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs !=null) {
			try {
				rs.close();
			}catch (Exception ex)
			{
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ ex);
			}
		}
		close(conn,ps);
	}
	public void close(Connection conn, PreparedStatement ps) {
		
		if(ps !=null) {
			try {
				ps.close();
			}catch (Exception ex)
			{
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ ex);
			}
		}
		if(conn !=null) {
			try {
				conn.close();
			}catch (Exception ex)
			{
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : " +ex);
			}
		}
	}
	
	public ArrayList<GameVO> gameList(){
		ArrayList<GameVO>list = new ArrayList<GameVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GameVO game = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select name, price, date, img_url from game_detail");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new GameVO();
				game.setGame_name(rs.getString(1));
				game.setGame_price(rs.getInt(2));
				game.setGame_date(rs.getString(3));
				game.setImg_url(rs.getString(4));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	
	
	
	public ArrayList<GameVO> selectGenreGameList(GameVO temp_game)
	{
		ArrayList<GameVO>list = new ArrayList<GameVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GameVO game = null;
		
		try {
			conn = connect();
			
			if (temp_game.getGenre_name().equals("선택") && temp_game.getGame_name().equals(""))
				pstmt = conn.prepareStatement("select name, price, date, img_url from game_genre_view group by name");
			else if (temp_game.getGenre_name().equals("선택"))
				pstmt = conn.prepareStatement("select name, price, date, img_url from game_genre_view where name like '%" + temp_game.getGame_name() + "%' group by name");
			else if (temp_game.getGame_name().equals("")) {
				pstmt = conn.prepareStatement("select name, price, date, img_url from game_genre_view where genre = '" + temp_game.getGenre_name() + "' group by name");
				System.out.println(pstmt);}
			else if (!temp_game.getGenre_name().equals("선택") && !temp_game.getGame_name().equals(""))
				pstmt = conn.prepareStatement("select name, price, date, img_url from game_genre_view where genre = '" + temp_game.getGenre_name() + "' and name like '%" + temp_game.getGame_name() + "%' group by name");
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new GameVO();
				game.setGame_name(rs.getString(1));
				game.setGame_price(rs.getInt(2));
				game.setGame_date(rs.getString(3));
				game.setImg_url(rs.getString(4));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("�삤瑜� 諛쒖깮 : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	
	public ArrayList<GameVO> gameDetail(GameVO temp_game)
	{
		ArrayList<GameVO>list = new ArrayList<GameVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GameVO game = null;
		
		try {
			conn = connect();
			
			pstmt = conn.prepareStatement("select * from detail where img_url = '" + temp_game.getImg_url() + "'");
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new GameVO();
				game.setGame_name(rs.getString(1));
				game.setGame_price(rs.getInt(2));
				game.setGame_date(rs.getString(3));
				game.setGame_dev(rs.getString(4));
				game.setGame_pub(rs.getString(5));
				game.setGame_cont(rs.getString(6));
				game.setImg_url(rs.getString(7));
				game.setMin_os(rs.getString(8));
				game.setMin_proc(rs.getString(9));
				game.setMin_mem(rs.getString(10));
				game.setMin_graphic(rs.getString(11));
				game.setRec_os(rs.getString(12));
				game.setRec_proc(rs.getString(13));
				game.setRec_mem(rs.getString(14));
				game.setRec_graphic(rs.getString(15));
				game.setMin_cpu(rs.getInt(16));
				game.setMin_ram(rs.getInt(17));
				game.setMin_gpu(rs.getInt(18));
				game.setRec_cpu(rs.getInt(19));
				game.setRec_ram(rs.getInt(20));
				game.setRec_gpu(rs.getInt(21));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("�삤瑜� 諛쒖깮 : "+ex +temp_game.getImg_url());
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	
}
