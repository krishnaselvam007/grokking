package a_windowSliding;

public class sample {

	public static void main(String[] args) {
		/*int x = 8;
		for (int i = 0, j = 9; i <= x; i++) {
			System.out.println("I :" + i +" j :: "+ j + " x :: "+x);
			if (x-i < 5) {
				System.out.println(x - i*j);
				j++;
			} else {
				System.out.println(i*j);
				j--;
			}
		}*/
		int count = 80, i,j,k = 9;
		for (i = 1,j=1; i < k && j < k; j++) {
			if (j==k-1) {
				j=0;
				i++;
			}
			count--;
		}
		System.out.println(count);
		System.out.println("Krishnan");
	}

}
