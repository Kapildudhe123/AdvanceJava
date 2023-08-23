package in.co.rays.bundle;

import java.util.ResourceBundle;

public class TestBundle {
	
	public static void main(String[] args) {
ResourceBundle rb=		 ResourceBundle.getBundle("in.co.rays.bundle.app");
		 System.out.println(rb.getString("Driver"));
		 System.out.println(rb.getString("url"));
		 System.out.println(rb.getString("user"));
		 System.out.println(rb.getString("password"));
		 System.out.println(Integer.parseInt(rb.getString("initial")));
		 System.out.println(Integer.parseInt(rb.getString("acquire")));
		 System.out.println(Integer.parseInt(rb.getString("maximum")));
		 System.out.println(rb.getString("greeting"));
	}

}
