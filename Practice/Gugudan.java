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

	public void printColumn(int col) {
		if (9 < col) {
			System.out.println("col is not valid![1~9]");
			return;
		}

		for (int i = 2; i <= 9; i+=col) {
			for (int j = 1; j <= 9; j++) {
				for (int k = 0; k < col; k++) {

					if(10 <= i+k) {
						System.out.println("\n");
						break;
					}

					System.out.printf("%d * %d = %d", (i+k), j, (i+k)*j);

					if(k < col-1)
						System.out.println("\t");
					else
						System.out.println("\n");
				}
			}
			System.out.println();
		}
	}
}
