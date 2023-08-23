package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.StudentBean;
import in.co.rays.util.JDBCDataSource;

public class StudnetModel {

	public List search(StudentBean bean, int pageno, int pagesize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from student where 1=1");

		if (bean != null) {
			if (bean.getFirst_Name() != null && bean.getFirst_Name().length() > 0) {
				sql.append(" and first_name like'" + bean.getFirst_Name() + "%'");
			}
			if (bean.getLast_Name() != null && bean.getLast_Name().length() > 0) {
				sql.append(" and last_name like'" + bean.getLast_Name() + "%'");
			}
		}
		if (pagesize > 0) {
			pageno = (pageno - 1) * pagesize;
			sql.append(" limit " + pageno + "," + pagesize);
		}
		System.out.println(sql.toString());

		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new StudentBean();
			bean.setFirst_Name(rs.getString(1));
			bean.setLast_Name(rs.getString(2));
			bean.setDob(rs.getDate(3));
			bean.setMobile_No(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setCollege_id(rs.getInt(6));
			bean.setCollge_Name(rs.getString(7));

			list.add(bean);

		}
		return list;

	}

	public StudentBean findbypk(int college_id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from student where college_id=?");
		ps.setInt(1, college_id);
		ResultSet rs = ps.executeQuery();
		StudentBean bean = null;
		while (rs.next()) {
			bean = new StudentBean();
			bean.setFirst_Name(rs.getString(1));
			bean.setLast_Name(rs.getString(2));
			bean.setDob(rs.getDate(3));
			bean.setMobile_No(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setCollege_id(rs.getInt(6));
			bean.setCollge_Name(rs.getString(7));

		}

		return bean;

	}

	public void update(StudentBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement(
				"update student set first_name=?,last_name=?,dob=?,mobile_no=?,email=?,college_name=? where college_id=?");
		ps.setString(1, bean.getFirst_Name());
		ps.setString(2, bean.getLast_Name());
		ps.setDate(3, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(4, bean.getMobile_No());
		ps.setString(5, bean.getEmail());
		ps.setString(6, bean.getCollge_Name());
		ps.setInt(7, bean.getCollege_id());

		int i = ps.executeUpdate();
		System.out.println("update" + i);
	}

	public Integer nextpk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select max(college_id) from student ");
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(6);

		}
		return pk+1;

	}

	public void add(StudentBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
		ps.setString(1, bean.getFirst_Name());
		ps.setString(2, bean.getLast_Name());
		ps.setDate(3, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(4, bean.getMobile_No());
		ps.setString(5, bean.getEmail());
		ps.setInt(6,nextpk());
		ps.setString(7, bean.getCollge_Name());

		int i = ps.executeUpdate();
		System.out.println("data inserted" + i);
	}

}
