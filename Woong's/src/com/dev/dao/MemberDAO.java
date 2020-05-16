package com.dev.dao;

import java.sql.*;
import java.util.ArrayList;

import com.dev.vo.MemberVO;


public class MemberDAO {
	
	private static MemberDAO dao = new MemberDAO();
	public MemberDAO() {}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbproject?useSSL=false","root","tmvjswl@2877");
			
		}catch (Exception e) {
			System.out.println("�삤瑜� 諛쒖깮 : "+e);
		}
		return conn;
	}
	
	public void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs !=null) {
			try {
				rs.close();
			}catch (Exception ex)
			{
				System.out.println("�삤瑜� 諛쒖깮 : "+ ex);
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
				System.out.println("�삤瑜� 諛쒖깮 : "+ ex);
			}
		}
		if(conn !=null) {
			try {
				conn.close();
			}catch (Exception ex)
			{
				System.out.println("�삤瑜� 諛쒖깮 : " +ex);
			}
		}
	}
	
	public void memberInsert(MemberVO member)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMail());
			pstmt.executeUpdate();
		}catch (Exception ex)
		{
			System.out.println("�삤瑜� 諛쒖깮 : "+ex);
		}
		finally {
			close(conn,pstmt);
		}
	}
	
	public ArrayList<MemberVO> memberList(){
		ArrayList<MemberVO>list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next())
			{
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setMail(rs.getString(4));
				list.add(member);
			}
		}catch(Exception ex) {
			System.out.println("�삤瑜� 諛쒖깮 : "+ex);
		}finally {
			close(conn, pstmt,rs);
		}
		return list;
	}
	//�쑀�� 濡쒓렇�씤 遺�
	public int memberlogin(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String dbpw="";
		int x = 1;
		
		try {
			StringBuffer query = new StringBuffer();
			query.append("select passwd from member where id = ?");
			
			conn = connect();
			pstmt= conn.prepareStatement(query.toString());
			pstmt.setString(1,member.getId());
			rs = pstmt.executeQuery();
			System.out.println(query.toString());
			System.out.println(pstmt);
			if(rs.next()) {
				System.out.println("�뱾�뼱�샂");
				dbpw = rs.getString("passwd");
				System.out.println(dbpw);
				
				if(dbpw.equals(member.getPasswd())) {
					System.out.println("鍮꾨�踰덊샇 留욎쓬");
					x = 1;		//�꽦怨� 
				}
				else
					x = 0;		//鍮꾨�踰덊샇 ��由� 
			}else {
				System.out.println("�븘�씠�뵒 �뾾�쓬");
			 x = -1;		//�븘�씠�뵒媛� �뾾�쓬 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt,rs);
		}
		System.out.println(x);
		return x;
	}
}
