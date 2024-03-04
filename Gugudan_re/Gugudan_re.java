package Gugudan_re;

public class Gugudan_re {

	//	int m;

	//	public void print(int i) {
	//		System.out.println();
	//		for(num = 1; num < 10; num++) {
	//			m = num*i;	
	//			//				System.out.print(i +" * " + num + " = " + m + "\t");
	//			////							System.out.println(i + "단");
	//			//				System.out.print("");
	//		}
	//	}
	//	}
	//		public void horizen(int i) {
	//			System.out.println();
	//			//		// TODO Auto-generated method stub
	//			for(int num = 1 ; num < 10; num++) {
	//				m = num*i;
	//				System.out.print(num +" * " + i + " = " + m + "\t" );
	//	
	//	
	//				System.out.print("");	
	//			}
	//		}

	public void part(int i) {
		for(int s = 0; s <= 10/i; s++) {
			for (int r = 1; r < 10; r++) {
				for (int c = 2; c < i+2 && c < 10 ; c++) {
					if((s*i+c) > 9) {
						break;
					}else
					System.out.print(s*i+c + " * " + r + " = " + ((s*i+c) * r) + "\t");
				}
				System.out.println();
			}
		System.out.println();
		}
	}
}