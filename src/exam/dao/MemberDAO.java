package exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DBConnection;
import exam.dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO instance() {
		return instance;
	}
	private MemberDAO() {}
	
	public ArrayList<MemberDTO> getAllList() {
		Connection conn = DBConnection.getConnection();
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setPoint(point);
				list.add(dto);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}	
		return list; 
	}
	
	public boolean member_check(String id, String pw) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			String sql = "select * from member where id = ? and pw = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}	
		return check; 
	}
	
	public int member_join(String id, String pw, String name) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;

		int check = 0;
		
		try {
			String sql = "insert into member values(?,?,?,DEFAULT)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
		
			check = pstmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}	
		return check; 
	}
	
	public boolean id_check(String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = true;
		
		try {
			String sql = "select * from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = false;
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}	
		return check; 
	}
	
	public int member_revise(String pw, String name, int point, String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;

		int check = 0;
		
		try {
			String sql = "update member set pw = ?, name = ?, point = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setInt(3, point);
			pstmt.setString(4, id);
		
			check = pstmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}	
		return check; 
	}
	
	public int member_delete(String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;

		int check = 0;
		
		try {
			String sql = "delete from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
		
			check = pstmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}	
		return check; 
	}
	
	public int point_add(int point, String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;

		int check = 0;
		
		try {
			String sql = "update member set point = point + ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
		
			check = pstmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}	
		return check; 
	}
	
	public int point_sub(int point, String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;

		int check = 0;
		
		try {
			String sql = "update member set point = point - ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
		
			check = pstmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}	
		return check; 
	}
	
	public int getPoint(String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int point = 0;
		
		try {
			String sql = "select * from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				point = rs.getInt("point");
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}	
		return point;  
	}
	
	
}
