package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws Exception {
		 search();
		//update();
		// add();

	}

	private static void add() throws Exception {

		String dob = "2004-04-06";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		bean.setId(6);
		bean.setFirstName("lalit");
		bean.setLastName("dudhe");
		bean.setLoginId("@gmail.com");
		bean.setPassword("@lalit123");
		bean.setDob(sdf.parse(dob));
		bean.setAddress("mushakhedi");

		UserModel model = new UserModel();
		model.add(bean);

	}

	private static void update() throws Exception {

		String dob = "1999-08-19";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = model.findbypk(8);

		if (bean != null) {
			bean.setFirstName("yogesh");
			bean.setLastName("dudhe");
			bean.setLoginId("yogeshdudhe@9190gmail.com");
			bean.setPassword("12021");
			bean.setDob(sdf.parse(dob));
			bean.setAddress("ujjain");
			model.update(bean);
			System.out.println("update and exist...!!!");
		} else {
			System.out.println("no update...!!!");
		}
	}

	private static void search() throws Exception {
		String dob = "2004-04-06";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		// bean.setFirstName("k");
		bean.setDob(sdf.parse(dob));

		UserModel model = new UserModel();
		List l = model.search(bean, 1, 3);
		Iterator it = l.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print(bean.getId() + "\t" + "\t");
			System.out.print(bean.getFirstName() + "\t" + "\t");
			System.out.print(bean.getLastName() + "\t" + "\t");
			System.out.print(bean.getLoginId() + "\t" + "\t");
			System.out.print(bean.getPassword() + "\t" + "\t");
			System.out.print(bean.getDob() + "\t" + "\t");
			System.out.println(bean.getAddress() + "\t" + "\t");

		}
	}

}
