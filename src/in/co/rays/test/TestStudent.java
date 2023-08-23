package in.co.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudnetModel;

public class TestStudent {

	public static void main(String[] args) throws Exception {

		 add();
	//update();
		//search();
	}

	private static void search() throws Exception {
		StudentBean bean = new StudentBean();
		//bean.setFirst_Name("s");
//bean.setLast_Name("d");
		StudnetModel model = new StudnetModel();
		List l = model.search(bean,1,2);
		Iterator it = l.iterator();
		while (it.hasNext()) {
			bean = (StudentBean) it.next();

			System.out.print(bean.getFirst_Name()+"\t");
			System.out.print(bean.getLast_Name()+"\t");
			System.out.print(bean.getDob()+"\t");
			System.out.print(bean.getMobile_No()+"\t");
			System.out.print(bean.getEmail()+"\t");
			System.out.print(bean.getCollege_id()+"\t");
			System.out.println(bean.getCollge_Name()+"\t");
		}
	}

	private static void update() throws Exception {
		StudnetModel model = new StudnetModel();
		StudentBean bean = model.findbypk(0);

		if (bean != null) {

			//bean.setLast_Name("patil");
			//bean.setCollge_Name("Medicaps University Rau");
				bean.setCollege_id(8);		
			model.update(bean);
			System.out.println("update success");
		} else {
			System.out.println("exist...!!!");
		}

	}

	private static void add() throws Exception {

		String dob = "2005-05-18";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StudentBean bean = new StudentBean();
		bean.setFirst_Name("deepak");
		bean.setLast_Name("gayke");
		bean.setDob(sdf.parse(dob));

		bean.setMobile_No("6265272809");
		bean.setEmail("deepakgayke20@gmail.com");
		//bean.setCollege_id(07);
		
		bean.setCollge_Name("Rahat College khargone");

		StudnetModel model = new StudnetModel();
		model.add(bean);

	}

}
