package DataStructure.Ch06.Homeworks;
/*
 * 6장 구현 실습과제1 
 */
class PhyscData implements Comparable<PhyscData>{
	String name;              // 이름
	int    height;            // 키
	double vision;            // 시력

	public PhyscData(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	@Override
	public String toString() {
		return ("name="+name + ", height = " + height + ", vision = " + vision);
	}
	@Override
	public int compareTo(PhyscData p) {
		// TODO Auto-generated method stub
		return this.name.compareTo(p.name);
		//return this.height - p.height;//현재객체 this의 키에서 비교객체키를 빼서 비교
	}

}



public class Test_객체merge정렬 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(PhyscData[] a, int lefta, int righta, int leftb, int rightb ) {
		//두개로 갈라진 배열 합쳐지는 임시배열
		//PhyscData[] temp = new PhyscData[(righta+1) + (rightb+1)]; //length 니까 +1 //이거 왜 안돼?
		PhyscData[] temp = new PhyscData[(righta-lefta+1)+ (rightb-leftb+1)]; //length 니까 +1
		
		int tempI = 0;
		int la = lefta, lb = leftb;

		while (la <= righta && lb <= rightb) {
			if ((a[la].compareTo(a[lb])) < 0) {
				temp[tempI++] = a[la++];
			}
			else if (a[la].compareTo(a[lb]) == 0) {
				temp[tempI++] = a[la++];
				temp[tempI++] = a[lb++];
			}
			else {
				temp[tempI++] = a[lb++];
			}
		}


		while (la <= righta) {
			temp[tempI++] = a[la++];
		}
		while (lb <= rightb) {
			temp[tempI++] = a[lb++];
		}
// 이렇게하면 두명씩 출력되는데 왜 그런건지
//		for (int i = 0; i <= temp.length; i++) {
//			a[i] = temp[i];
//		}
		
		//이건 내가 한 거 아님
		for (int i = lefta; i <= rightb; i++) { //0~temp.len으로 하면
			a[i] = temp[i-lefta]; //이게 왜 이런지 이해해보자
		}
	}
	

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(PhyscData[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}


	public static void main(String[] args) {

		PhyscData[] x = {
				new PhyscData("이수연", 168, 0.4),
				new PhyscData("유서범", 171, 1.5),
				new PhyscData("김찬우", 173, 0.7),
				new PhyscData("황지안", 169, 0.8),
				new PhyscData("강민하", 162, 0.3),
				new PhyscData("박준서", 176, 2.0),
				new PhyscData("유서범", 174, 1.5),
				new PhyscData("장경오", 181, 1.2),

		};

		int nx = x.length;

		MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
		System.out.println("수정후  정렬했습니다.");
		System.out.println("■ 신체검사 리스트 ■");
		System.out.println(" 이름     키  시력");
		System.out.println("------------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}
}
