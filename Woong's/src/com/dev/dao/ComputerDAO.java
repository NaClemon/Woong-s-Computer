package com.dev.dao;

import java.sql.*;
import java.util.ArrayList;

import com.dev.vo.ComputerVO;
import com.dev.vo.GameVO;

public class ComputerDAO {
	
	private static ComputerDAO dao = new ComputerDAO();
	private ComputerDAO() {}
	public static ComputerDAO getInstance() {
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
	//-----cpu------
	@SuppressWarnings("resource")
	public ArrayList<ComputerVO> mincpu(ComputerVO temp_cm){
		ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String temp = null;
		
		ComputerVO game = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select cpu from game_min_spec as a join game_detail as b on a.game_id = b.game_id where b.name = '" + temp_cm.getGame_name() + "'");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				temp = String.valueOf(rs.getInt(1));
			}

			pstmt = conn.prepareStatement("select no from cpu where cpu_id = '" + temp + "'");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				temp = String.valueOf(rs.getInt(1));
			}
			
			pstmt = conn.prepareStatement("select img_url1, name, price, cpu_id from cpu where no >= '" + temp + "' order by cpu_id desc");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new ComputerVO();
				game.setCpu_img_url1(rs.getString(1));
				game.setCpu_name(rs.getString(2));
				game.setCpu_price(rs.getInt(3));
				game.setCpu_id(rs.getInt(4));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	//-------ram------------
	@SuppressWarnings("resource")
	public ArrayList<ComputerVO> minram(ComputerVO temp_cm){
		ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String temp = null;
		
		ComputerVO game = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select memory from game_min_spec as a join game_detail as b on a.game_id = b.game_id where b.name = '" + temp_cm.getGame_name() + "'");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				temp = String.valueOf(rs.getInt(1));
			}
			
			pstmt = conn.prepareStatement("select gb from ram where ram_id = '" + temp + "'");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				temp = String.valueOf(rs.getInt(1));
			}
			
			pstmt = conn.prepareStatement("select url_img1, name, price, ram_id from ram where gb >= '" + temp + "' order by ram_id desc");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new ComputerVO();
				game.setRam_img_url1(rs.getString(1));
				game.setRam_name(rs.getString(2));
				game.setRam_price(rs.getInt(3));
				game.setRam_id(rs.getInt(4));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	//-------gpu------------
		@SuppressWarnings("resource")
		public ArrayList<ComputerVO> mingpu(ComputerVO temp_cm){
		ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String temp = null;
		
		ComputerVO game = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select gpu from game_min_spec as a join game_detail as b on a.game_id = b.game_id where b.name = '" + temp_cm.getGame_name() + "'");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				temp = String.valueOf(rs.getInt(1));
			}
			
			pstmt = conn.prepareStatement("select model from vga where vga_id = '" + temp + "'");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				temp = String.valueOf(rs.getInt(1));
			}
			
			pstmt = conn.prepareStatement("select img_url1, name, price, vga_id from vga where model >= '" + temp + "' order by vga_id desc");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new ComputerVO();
				game.setVga_img_url1(rs.getString(1));
				game.setVga_name(rs.getString(2));
				game.setVga_price(rs.getInt(3));
				game.setVga_id(rs.getInt(4));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
		
		
		//-----cpu------
		@SuppressWarnings("resource")
		public ArrayList<ComputerVO> reccpu(ComputerVO temp_cm){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String temp = null;
			
			ComputerVO game = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select cpu from game_rec_spec as a join game_detail as b on a.game_id = b.game_id where b.name = '" + temp_cm.getGame_name() + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					temp = String.valueOf(rs.getInt(1));
				}
				
				pstmt = conn.prepareStatement("select no from cpu where cpu_id = '" + temp + "' order by cpu_id desc");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					temp = String.valueOf(rs.getInt(1));
				}
				
				pstmt = conn.prepareStatement("select img_url1, name, price, cpu_id from cpu where no >= '" + temp + "' order by cpu_id asc");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					game = new ComputerVO();
					game.setCpu_img_url1(rs.getString(1));
					game.setCpu_name(rs.getString(2));
					game.setCpu_price(rs.getInt(3));
					game.setCpu_id(rs.getInt(4));
					
					list.add(game);
				}
			}catch(Exception ex) {
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		//-------ram------------
		@SuppressWarnings("resource")
		public ArrayList<ComputerVO> recram(ComputerVO temp_cm){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String temp = null;
			
			ComputerVO game = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select memory from game_rec_spec as a join game_detail as b on a.game_id = b.game_id where b.name = '" + temp_cm.getGame_name() + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					temp = String.valueOf(rs.getInt(1));
				}
				
				pstmt = conn.prepareStatement("select gb from ram where ram_id = '" + temp + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					temp = String.valueOf(rs.getInt(1));
				}
				
				pstmt = conn.prepareStatement("select url_img1, name, price, ram_id from ram where gb >= '" + temp + "' order by ram_id asc");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					game = new ComputerVO();
					game.setRam_img_url1(rs.getString(1));
					game.setRam_name(rs.getString(2));
					game.setRam_price(rs.getInt(3));
					game.setRam_id(rs.getInt(4));
					
					list.add(game);
				}
			}catch(Exception ex) {
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		//-------gpu------------
			@SuppressWarnings("resource")
			public ArrayList<ComputerVO> recgpu(ComputerVO temp_cm){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String temp = null;
			
			ComputerVO game = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select gpu from game_rec_spec as a join game_detail as b on a.game_id = b.game_id where b.name = '" + temp_cm.getGame_name() + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					temp = String.valueOf(rs.getInt(1));
				}
				
				pstmt = conn.prepareStatement("select model from vga where vga_id = '" + temp + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					temp = String.valueOf(rs.getInt(1));
				}
				
				pstmt = conn.prepareStatement("select img_url1, name, price, vga_id from vga where model >= '" + temp + "' order by vga_id asc");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					game = new ComputerVO();
					game.setVga_img_url1(rs.getString(1));
					game.setVga_name(rs.getString(2));
					game.setVga_price(rs.getInt(3));
					game.setVga_id(rs.getInt(4));
					
					list.add(game);
				}
			}catch(Exception ex) {
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		
		
		
		//----mb----
	public ArrayList<ComputerVO> minmb(ComputerVO temp_cm){
		ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ComputerVO game = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select m.img_url1, m.name, m.price, m.mb_id from mainboard as m join cpu as c on m.socket = c.socket group by m.name");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new ComputerVO();
				game.setMb_img_url1(rs.getString(1));
				game.setMb_name(rs.getString(2));
				game.setMb_price(rs.getInt(3));
				game.setMb_id(rs.getInt(4));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	public ArrayList<ComputerVO> minpower(ComputerVO temp_cm){
		ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ComputerVO game = null;
		try {
			conn = connect();
			
			pstmt = conn.prepareStatement("select p.img_url, p.name, p.price, p.id from power as p join mainboard as m on p.mb = m.mb_id");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new ComputerVO();
				game.setPower_img_url(rs.getString(1));
				game.setPower_name(rs.getString(2));
				game.setPower_price(rs.getInt(3));
				game.setPower_id(rs.getInt(4));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	public ArrayList<ComputerVO> minhdd(ComputerVO temp_cm){
		ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ComputerVO game = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select h.img_url, h.name, h.price, h.id from hdd as h join mainboard as m on h.mb = m.mb_id");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new ComputerVO();
				game.setHdd_img_url(rs.getString(1));
				game.setHdd_name(rs.getString(2));
				game.setHdd_price(rs.getInt(3));
				game.setHdd_id(rs.getInt(4));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	public ArrayList<ComputerVO> minssd(ComputerVO temp_cm){
		ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ComputerVO game = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select s.img_url, s.name, s.price, s.ssd_id from ssd  as s join mainboard as m on s.mb = m.mb_id");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new ComputerVO();
				game.setSsd_img_url(rs.getString(1));
				game.setSsd_name(rs.getString(2));
				game.setSsd_price(rs.getInt(3));
				game.setSsd_id(rs.getInt(4));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	public ArrayList<ComputerVO> mincase(ComputerVO temp_cm){
		ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ComputerVO game = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select c.img_url1, c.name, c.price, c.case_id from `case` as c join mainboard as m on c.mb = m.mb_id");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				game = new ComputerVO();
				game.setCase_img_url1(rs.getString(1));
				game.setCase_name(rs.getString(2));
				game.setCase_price(rs.getInt(3));
				game.setCase_id(rs.getInt(4));
				
				list.add(game);
			}
		}catch(Exception ex) {
			System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	
	
	
	
	//-----cpu------
		@SuppressWarnings("resource")
		public ArrayList<ComputerVO> pricecpu(ComputerVO temp_cm){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String tm = String.valueOf(temp_cm.getCpu_id());
			
			ComputerVO game = null;
			try {
				conn = connect();
				
				pstmt = conn.prepareStatement("select price from cpu where cpu_id = '" + tm + "'");

				rs = pstmt.executeQuery();
				while(rs.next())
				{
					game = new ComputerVO();
					game.setCpu_price(rs.getInt(1));
					
					list.add(game);
				}
			}catch(Exception ex) {
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		//-------ram------------
		@SuppressWarnings("resource")
		public ArrayList<ComputerVO> priceram(ComputerVO temp_cm){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String tm = String.valueOf(temp_cm.getRam_id());
			
			ComputerVO game = null;
			try {
				conn = connect();
				
				pstmt = conn.prepareStatement("select price from ram where ram_id = '" + tm + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					game = new ComputerVO();
					game.setRam_price(rs.getInt(1));
					
					list.add(game);
				}
			}catch(Exception ex) {
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		//-------gpu------------
			@SuppressWarnings("resource")
			public ArrayList<ComputerVO> pricegpu(ComputerVO temp_cm){
				ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String tm = String.valueOf(temp_cm.getVga_id());
				
				ComputerVO game = null;
				try {
					conn = connect();
					
					pstmt = conn.prepareStatement("select price from vga where vga_id = '" + tm + "'");
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						game = new ComputerVO();
						game.setVga_price(rs.getInt(1));
						
						list.add(game);
					}
				}catch(Exception ex) {
					System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
				}finally {
					close(conn, pstmt,rs);
				}
				return list;
		}
			//----mb----
		public ArrayList<ComputerVO> pricemb(ComputerVO temp_cm){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String tm = String.valueOf(temp_cm.getMb_id());
			
			ComputerVO game = null;
			try {
				conn = connect();
				
				pstmt = conn.prepareStatement("select price from mainboard where mb_id = '" + tm + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					game = new ComputerVO();
					game.setMb_price(rs.getInt(1));
					
					list.add(game);
				}
			}catch(Exception ex) {
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		public ArrayList<ComputerVO> pricepower(ComputerVO temp_cm){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String tm = String.valueOf(temp_cm.getPower_id());
			
			ComputerVO game = null;
			try {
				conn = connect();
				
				pstmt = conn.prepareStatement("select price from power where id = '" + tm + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					game = new ComputerVO();
					game.setPower_price(rs.getInt(1));
					
					list.add(game);
				}
			}catch(Exception ex) {
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		public ArrayList<ComputerVO> pricehdd(ComputerVO temp_cm){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String tm = String.valueOf(temp_cm.getHdd_id());
			
			ComputerVO game = null;
			try {
				conn = connect();
				
				pstmt = conn.prepareStatement("select price from hdd where id = '" + tm + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					game = new ComputerVO();
					game.setHdd_price(rs.getInt(1));
					
					list.add(game);
				}
			}catch(Exception ex) {
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		public ArrayList<ComputerVO> pricessd(ComputerVO temp_cm){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String tm = String.valueOf(temp_cm.getSsd_id());
			
			ComputerVO game = null;
			try {
				conn = connect();
				
				pstmt = conn.prepareStatement("select price from ssd where ssd_id = '" + tm + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					game = new ComputerVO();
					game.setSsd_price(rs.getInt(1));
					
					list.add(game);
				}
			}catch(Exception ex) {
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		public ArrayList<ComputerVO> pricecase(ComputerVO temp_cm){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String tm = String.valueOf(temp_cm.getCase_id());
			
			ComputerVO game = null;
			try {
				conn = connect();
				
				pstmt = conn.prepareStatement("select price from `case` where case_id = '" + tm + "'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					game = new ComputerVO();
					game.setCase_price(rs.getInt(1));
					
					list.add(game);
				}
			}catch(Exception ex) {
				System.out.println("占쎌궎�몴占� 獄쏆뮇源� : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		
		//------jino------------
		public ArrayList<ComputerVO> computerMaiList(){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ComputerVO computer = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from mainboard");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					computer = new ComputerVO();
					computer.setJino_mai_name(rs.getString(2));
					computer.setJino_mai_price(rs.getInt(3));
					computer.setJino_mai_dev(rs.getString(4));
					computer.setJino_mai_socket(rs.getString(5));
					computer.setJino_mai_chip(rs.getString(6));
					computer.setJino_mai_bz(rs.getString(7));
					computer.setJino_mai_img(rs.getString(8));

					
					list.add(computer);
				}
			}catch(Exception ex) {
				System.out.println("?ㅻ쪟 諛쒖깮 : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		
		public ArrayList<ComputerVO> computerHddList(){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ComputerVO computer = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from hdd");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					computer = new ComputerVO();
					computer.setJino_hdd_name(rs.getString(2));
					computer.setJino_hdd_price(rs.getInt(3));
					computer.setJino_hdd_storage(rs.getString(4));
					computer.setJino_hdd_manufacturer(rs.getString(5));
					computer.setJino_hdd_type(rs.getString(6));
					computer.setJino_hdd_img(rs.getString(7));

					
					list.add(computer);
				}
			}catch(Exception ex) {
				System.out.println("?ㅻ쪟 諛쒖깮 : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		
		public ArrayList<ComputerVO> computerSsdList(){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ComputerVO computer = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from ssd");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					computer = new ComputerVO();
					computer.setJino_ssd_name(rs.getString(2));
					computer.setJino_ssd_price(rs.getInt(3));
					computer.setJino_ssd_storage(rs.getString(4));
					computer.setJino_ssd_manufacturer(rs.getString(5));
					computer.setJino_ssd_type(rs.getString(6));
					computer.setJino_ssd_img(rs.getString(7));

					
					list.add(computer);
				}
			}catch(Exception ex) {
				System.out.println("?ㅻ쪟 諛쒖깮 : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		
		public ArrayList<ComputerVO> computerCpuList(){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ComputerVO computer = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from cpu");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					computer = new ComputerVO();
					computer.setJino_cpu_name(rs.getString(2));
					computer.setJino_cpu_price(rs.getInt(3));
					computer.setJino_cpu_core(rs.getString(4));
					computer.setJino_cpu_thred(rs.getString(5));
					computer.setJino_cpu_spd(rs.getString(6));
					computer.setJino_cpu_socket(rs.getString(7));
					computer.setJino_cpu_img(rs.getString(8));
					
					list.add(computer);
				}
			}catch(Exception ex) {
				System.out.println("?ㅻ쪟 諛쒖깮 : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		
		public ArrayList<ComputerVO> computerCasList(){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ComputerVO computer = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from `case`");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					computer = new ComputerVO();
					computer.setJino_cas_name(rs.getString(2));
					computer.setJino_cas_price(rs.getInt(3));
					computer.setJino_cas_dev(rs.getString(4));
					computer.setJino_cas_type(rs.getString(5));
					computer.setJino_cas_size(rs.getString(6));
					computer.setJino_cas_img(rs.getString(7));

					
					list.add(computer);
				}
			}catch(Exception ex) {
				System.out.println("?ㅻ쪟 諛쒖깮 : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		
		public ArrayList<ComputerVO> computerRamList(){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ComputerVO computer = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from ram");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					computer = new ComputerVO();
					computer.setJino_ram_name(rs.getString(2));
					computer.setJino_ram_price1(rs.getInt(3));
					computer.setJino_ram_price2(rs.getInt(4));
					computer.setJino_ram_ddr(rs.getString(5));
					computer.setJino_ram_spd(rs.getString(6));
					computer.setJino_ram_img1(rs.getString(7));
					computer.setJino_ram_img2(rs.getString(8));
					
					list.add(computer);
				}
			}catch(Exception ex) {
				System.out.println("?ㅻ쪟 諛쒖깮 : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		
		public ArrayList<ComputerVO> computerVgaList(){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ComputerVO computer = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from vga");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					computer = new ComputerVO();
					computer.setJino_vga_name(rs.getString(2));
					computer.setJino_vga_price(rs.getInt(3));
					computer.setJino_vga_dev(rs.getString(4));
					computer.setJino_vga_mod(rs.getString(5));
					computer.setJino_vga_mem(rs.getString(6));
					computer.setJino_vga_img1(rs.getString(7));
					computer.setJino_vga_img2(rs.getString(8));
					
					list.add(computer);
				}
			}catch(Exception ex) {
				System.out.println("?ㅻ쪟 諛쒖깮 : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		
		public ArrayList<ComputerVO> computerPowList(){
			ArrayList<ComputerVO>list = new ArrayList<ComputerVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ComputerVO computer = null;
			try {
				conn = connect();
				pstmt = conn.prepareStatement("select * from power");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					computer = new ComputerVO();
					computer.setJino_pow_name(rs.getString(2));
					computer.setJino_pow_price(rs.getInt(3));
					computer.setJino_pow_output(rs.getString(4));
					computer.setJino_pow_type(rs.getString(5));
					computer.setJino_pow_img(rs.getString(6));

					
					list.add(computer);
				}
			}catch(Exception ex) {
				System.out.println("?ㅻ쪟 諛쒖깮 : "+ex);
			}finally {
				close(conn, pstmt,rs);
			}
			return list;
		}
		

}
