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
		//두개로 갈라진 배열 합쳐지는 임시배열 //두개를 또 두개로
		//PhyscData[] temp = new PhyscData[(righta+1) + (rightb+1)]; //length 니까 +1 //이거 왜 안돼?
		PhyscData[] temp = new PhyscData[(righta-lefta+1) + (rightb-leftb+1)]; //length 니까 +1
		
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
		
//		for (int i = lefta; i <= rightb; i++) { //0~temp.len으로 하면
//			a[i] = temp[i-lefta]; //이게 왜 이런지 이해해보자
		
		//이건 내가 한 거 아님
		for (int i = 0; i <= rightb-lefta; i++) { //0~temp.len으로 하면
			a[lefta + i] = temp[i];//temp 는 idx 0부터 시작
			//두개로 나눈 배열을 또 두개로 나눴을때도 왼쪽배열 오른쪽배열, 그걸 최종적으로 하나의 배열로 머지하는 과정
			//예를들어 52457349가 a 배열이면
			//5245 / 7349
			//52 45 / 73 49
			//오른쪽 배열을 보자
			//sort 되면 [3,4,7,9]가 되겠지
			//그러면 그걸 이제 다시 a 에 넣어야하잖아
			//그러면 3은 4번 인덱스에 들어가야하잖아
			//그래서 a[lefta(4)+i(0)] = temp[i(0)]
			//오른쪽항이 왼쪽항에 대입되니까
			//temp[i] 배열이 a 배열로 들어갈때 4번인덱스부터 들어가지
			//그렇다면 4는 어떻게 될까
			//4는 []a 의 5번인덱스로 들어가야지 그런데 현재는 []temp 의 1번인덱스지
			//a[lefta + 1] = temp[1]이 되는거지
			//a[lefta]는 4부터니까 거기에 temp의 0부터 시작하는 인덱스를 더해서 차례대로 넣으면
			//a[lefta + i++] = temp[i++]하면서 4(+0) 5(+1) 6(+2) 7(+3) 인덱스에 착착착 복사가 된다는 것!
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
