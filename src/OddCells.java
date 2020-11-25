
public class OddCells {
	
	public static void main(String[] args) {
		int[][] indices = {{0,1},{1,1}};
		System.out.println(oddCells(2,3, indices));
	}
	 public static int oddCells(int n, int m, int[][] indices) {
	int[] countRow = new int[n]; // store frequency of each number of int[i][0]
    int countEvenRow = 0; // total number of even numbers in countRow 
    int countOddRow = 0; // total number of odd numbers in countRow 
    
    int[] countCol = new int[m]; // store frequency of each number of int[i][1]
    int countEvenCol = 0; // total number of even numbers in countCol 
    int countOddCol = 0; // total number of odd numbers in countCol 
    
    for (int i = 0; i < indices.length; i++){
        countRow[indices[i][0]]++;
        countCol[indices[i][1]]++;
    }
    for (int i = 0; i < n; i++){
        if (countRow[i] % 2 == 0) countEvenRow++;
        else countOddRow++;
    }
    for (int i = 0; i < m; i++){
        if (countCol[i] % 2 == 0) countEvenCol++;
        else countOddCol++;
    }
    return countEvenRow * countOddCol + countOddRow * countEvenCol;
	 }
}
