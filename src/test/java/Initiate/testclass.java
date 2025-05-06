package Initiate;

public class testclass {

	public static void main(String[] args) {
		testclass objname = new testclass();

		System.out.println("sum is : " + objname.sum(5, 5));

		System.out.println("It is a : " + objname.ifelsevalue(11));

		System.out.println("Here : " + objname.testm1(34, 78));
		
		System.out.println("Bigger set : " + objname.testm2(6,7,14));
		objname.stringpractice();
		
		objname.reversestring("Star Model dum dam");
	}

	public int sum(int a, int b) {

		return a + b;
	}

	public String ifelsevalue(int value) {

		if (value > 10) {
			return "Big value";
		} else {
			return "Small value";
		}
	}

	public String testm1(int c, int d) {
		if (c > d) {
			return "Fisrt number is bigger";
		} else {
			return "Second number is bigger";
		}

	}
	
	public int testm2 (int e, int f, int g) {
		if (e+f>g) {
			return e+f;
		}
		else {
			return g;
		}
	}
	
	public void stringpractice () {
		 String abc = "Today Delhi is not playing as per standards";
		//abc.charAt(4);
		System.out.println(abc.charAt(4));
		
		System.out.println(abc.length());
	}
	public void reversestring (String orginal) {
		String rev="";
		for(int i=0;i<orginal.length();i++) {
			rev=orginal.charAt(i)+rev;
		}
		System.out.println(rev);
	}

}
