package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.util.JDBCDataSource;

public class MarksheetModel {
	public Integer nextpk() throws Exception {

		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	public List Search(MarksheetBean bean, int PageNo, int PageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like'" + bean.getName() + "%'");
			}
			if (bean.getRollNo() != 0 && bean.getRollNo() > 0) {
				sql.append(" and roll_no=" + bean.getRollNo());
			}
		}
			if (PageSize > 0) {
				PageNo = (PageNo - 1) * PageSize;
			
				sql.append(" limit " + PageNo + "," + PageSize);
			}
		

		System.out.println(sql.toString());

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysisc(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);
		}

		return list;

	}

	public MarksheetBean findbypk(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select *from marksheet where id=?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysisc(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

		}

		return bean;

	}

	public void update(MarksheetBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn
				.prepareStatement("update marksheet set name=?,roll_no=?,physisc=?,chemisty=?,maths=? where id=?");

		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getRollNo());
		ps.setInt(3, bean.getPhysisc());
		ps.setInt(4, bean.getChemistry());
		ps.setInt(5, bean.getMaths());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();

		System.out.println(i + "updated");
	}

	public void add(MarksheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");

		ps.setInt(1, nextpk());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRollNo());
		ps.setInt(4, bean.getPhysisc());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());

		int i = ps.executeUpdate();

		System.out.println("data inserted" + i);

	}


public void delete(int id) throws Exception {

	Connection conn = JDBCDataSource.getConnection();

	PreparedStatement ps = conn.prepareStatement("delete from marksheet where id=?");

	ps.setInt(1, id);
	
	int i = ps.executeUpdate();

	System.out.println("data deleted" + i);
}
}
