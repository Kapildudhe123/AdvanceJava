package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {

	
	public Integer nextpk() throws Exception {
		
		int pk=0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps=
       conn.prepareStatement("select max(id) from user");
		
ResultSet rs=	ps.executeQuery();
 while (rs.next()) {
	 pk=rs.getInt(1);
 }
	return pk+1;
}
	
	
	public void add(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
          ps.setInt(1, nextpk());
          ps.setString(2, bean.getFirstName());
          ps.setString(3, bean.getLastName());
          ps.setString(4, bean.getLoginId());
          ps.setString(5, bean.getPassword());
          ps.setDate(6, new java.sql.Date(bean.getDob().getTime())); 
          ps.setString(7, bean.getAddress());
          
        int i=  ps.executeUpdate();
          System.out.println(i+"data insert");
	}

	public void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from user where id=?");
          ps.setInt(1, id);
          
          
        int i=  ps.executeUpdate();
          System.out.println(i+"data delete");
	}


	//findbypk method
	
	public UserBean findbypk(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from user where id=?");

		ps.setInt(1, id);
		UserBean bean = null;
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		}
		return bean;
	}

	// update method
	public void update(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"update user set first_name=?,last_name=?,login_id=?,password=?,dob=?,address=? where id=?");

		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());

		int i = ps.executeUpdate();
		System.out.println(i + "update");
	}

	// search method

	public List search(UserBean bean, int pageno, int pagesize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from user where 1=1");

		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and first_name like'" + bean.getFirstName() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append(" and dob like'" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}
		}
		
			if (pagesize > 0) {
				pageno = (pageno-1)*pagesize;
				sql.append(" limit " + pageno + "," + pagesize);
			}
	

		System.out.println(sql.toString());

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}
		return list;
	}
	public UserBean findbylogin(String loginId) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from user where login_id=?");

		ps.setString(1, loginId);
		UserBean bean = null;
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		}
		return bean;
	}
	public UserBean authenticate(String loginId, String password) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from user where login_id = ? and password = ?");

		ps.setString(1, loginId);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));

		}
		return bean;

	}

}