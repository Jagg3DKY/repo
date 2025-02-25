
public class ArraySum {
		
	public int sumOfArray(Integer[] a, int index) {
		
		return index == -1 ? 0: a[index] + sumOfArray(a, index-1);
	}
}
