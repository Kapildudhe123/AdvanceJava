package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {

		//add();
		// update();
		 search();
	}

	private static void search() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		// bean.setName("k");
		// bean.setRollNo(2101);
		MarksheetModel model = new MarksheetModel();
		List l = model.Search(bean, 2, 5);

		Iterator it = l.iterator();

		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();

			System.out.print(bean.getId() + "\t");
			System.out.print(bean.getName() + "\t");
			System.out.print(bean.getRollNo() + "\t");
			System.out.print(bean.getPhysisc() + "\t");
			System.out.print(bean.getChemistry() + "\t");
			System.out.println(bean.getMaths() + "\t");

		}
	}

	private static void update() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findbypk(17);
		if (bean != null) {
			bean.setName("roshan");
			bean.setRollNo(117);
			bean.setChemistry(55);
			bean.setMaths(63);
			bean.setPhysisc(60);
			model.update(bean);
			System.out.println("update and exist...!!!");
		} else {
			System.out.println("no value find...!!!");
		}

	}

	private static void add() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		// bean.setId(11);
		bean.setName("sdfg");
		bean.setRollNo(113);
		bean.setPhysisc(56);
		bean.setChemistry(55);
		bean.setMaths(53);

		MarksheetModel model = new MarksheetModel();

		model.add(bean);

	}
}
