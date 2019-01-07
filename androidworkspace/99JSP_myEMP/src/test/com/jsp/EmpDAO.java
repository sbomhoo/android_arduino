package test.com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
	
	ArrayList<EmpDTO> list;
	
	String driver = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3306/test";
	String userid = "root";
	String passwd = "1234";
	
	
	public EmpDAO() {
		
		try {
			list = new ArrayList<EmpDTO>();
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}//end try~catch
	}//end ������
	

	public ArrayList<EmpDTO> select() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			//3.	Connection �α�	
				con = DriverManager.getConnection(url, userid, passwd);

			//4.	sql �� �ۼ�
				String query = "SELECT bno, writer, contents FROM board ORDER BY bno asc";
				
			//5.	Statement ����
				stmt = con.prepareStatement(query);
				
			//6.	sql �� ����
				rs = stmt.executeQuery();

			//7.	Data ���
		
				
				boolean b = rs.next();
				
				while (rs.next())	{

					  int deptno = rs.getInt("bno");
					String dname = rs.getString("writer");
					String loc = rs.getString("contents");	// ���� select���� �Էµ� ���� ( 3 = loc )
					
					list.add(new EmpDTO(deptno,dname,loc));
					
				}//end while
				
			} catch (Exception e) {	e.printStackTrace();} //end try~catch
			
			finally {
				
				//8.	�ڿ� �ݳ�
				try {
					
					rs.close();
					stmt.close();
					con.close();
					
				} catch (SQLException se) {
					se.printStackTrace();
				}
				
			}
		//db ���� ��
		return list;
	}//end select()
	
	//���ǻ��� �Է�
	public void insert2(String category,String phone,String title, String contents) {
		

		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			//3.	Connection �α�	
				con = DriverManager.getConnection(url, userid, passwd);

			//4.	sql �� �ۼ�
				String insert = "insert into recom(category,phone,title,contents) values(?,?,?,?)";
				
			//5.	Statement ����
				stmt = con.prepareStatement(insert);
			
			//6. 	���� �Է�
				stmt.setString(1, category);
				stmt.setString(2, phone);
				stmt.setString(3, title);
				stmt.setString(4,contents);
				
			//7.	sql �� ����
				stmt.executeUpdate();

			} catch (Exception e) {	e.printStackTrace();} //end try~catch
			
			finally {
				
				//8.	�ڿ� �ݳ�
				try {
					
					stmt.close();
					con.close();
					
				} catch (SQLException se) {
					se.printStackTrace();
				}
				
			}
		//db ���� ��
	}//end insert()
	
	
	
	//�����Խ��� �Է�
	public void insert(String writer, String contents) {
		

		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			//3.	Connection �α�	
				con = DriverManager.getConnection(url, userid, passwd);

			//4.	sql �� �ۼ�
				String insert = "insert into board (writer,contents) values ( ?,? )";
				
			//5.	Statement ����
				stmt = con.prepareStatement(insert);
			
			//6. 	���� �Է�
				stmt.setString(1, writer);
				stmt.setString(2,contents);
				
			//7.	sql �� ����
				int n = stmt.executeUpdate();

			} catch (Exception e) {	e.printStackTrace();} //end try~catch
			
			finally {
				
				//8.	�ڿ� �ݳ�
				try {
					
					stmt.close();
					con.close();
					
				} catch (SQLException se) {
					se.printStackTrace();
				}
				
			}
		//db ���� ��
	}//end insert()
			
/*	public EmpDTO retrieve(String deptno) {
		
		EmpDTO dto = new EmpDTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DriverManager.getConnection(url,userid,passwd);
			String sql = "select * from dept where deptno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(deptno));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
			
		}
		
		return dto;
		
	}//end retrieve()
	
	public void delete(String deptno) {
		
		EmpDTO dto = new EmpDTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url,userid,passwd);
			String sql = "delete from dept where deptno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(deptno));
			int n = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
			
		}
		

	}//end delete
	
	public void update(String deptno, String dname, String loc) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DriverManager.getConnection(url,userid,passwd);
			
			String sql = "update dept set dname = ?, loc = ? where deptno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, Integer.parseInt(deptno));
			int n = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				con.close();
			} catch (SQLException se) {

				se.printStackTrace();
				
			}
		}
		
		
	}//end update()
	*/
}
	
	
	
	