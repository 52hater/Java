package Practice;

public class GugudanTest {

	public static void main(String[] args) {

		Gugudan ggd = new Gugudan();


		//      ggd.print(2);
		//      System.out.println(" - ".repeat(15));
		//      ggd.print(3);
		//      System.out.println(" - ".repeat(15));
		//      ggd.print(4);
		//      System.out.println(" - ".repeat(15));
		//      ggd.print(5);
		//      System.out.println(" - ".repeat(15));
		//      ggd.print(6);
		//      System.out.println(" - ".repeat(15));
		//      ggd.print(7);
		//      System.out.println(" - ".repeat(15));
		//      ggd.print(8);
		//      System.out.println(" - ".repeat(15));
		//      ggd.print(9);

//		for (int i = 2; i <= 9; i++) {
//			ggd.printVertical(i);
//			System.out.println(" - ".repeat(15));
//
//		}
//
//
//		ggd.printHorizontal();
//		System.out.println();

		ggd.printColumn(3);
		System.out.println();
		ggd.printColumn(4);
		System.out.println();


		System.out.println("End");

	}

}