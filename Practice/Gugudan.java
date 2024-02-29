package Practice;

public class Gugudan {

	public void printVertical(int i) {
		System.out.println(i + "단");
		int result;
		for (int n = 1; n <= 9; n++) {
			result = i * n;
			System.out.println(i + " * " + n + " = " + result);

		}               
	}

	public void printHorizontal() {
		//여기에 int result = i * n 하면 오류, for 문 안의 지역변수 n 을 선언을 먼저 해야
		for (int n = 1; n <= 9; n++) {
			for (int i = 2; i <= 9; i++) {
				int result = i * n;
				System.out.print(i + " * " + n + " = " + result + "\t");
			}
			System.out.println();
		}
	}

	public void printColumn() {
		int result;
		for (int n = 1; n <= 9; n++) {
			for (int i = 2; i <= 9; i++) {
				for (int col = 1; col <= 9; col++) {
				result = i * n;
				System.out.print(i + " * " + n + " = " + result + "\t");

				if (col) {
					System.out.println();
				}
			}
			System.out.println();
		}
	}
}
