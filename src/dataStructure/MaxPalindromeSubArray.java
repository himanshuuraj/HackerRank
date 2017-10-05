package dataStructure;

/*

LP(i,j) = 1 if j = i
        = 1 if j = i+1 AND X[j] != X[i+1]
        = 2 if j = i+1 AND X[j] = X[i+1]
        = LP(i+1,j-1) + 2 if X[i] = X[j]
        = max{LP(i+1,j),LP(i,j-1)}

 */

public class MaxPalindromeSubArray {
    public static void main(String[] args) {
        String str = "ghnnitinywr";
        int len = str.length();
        int arr[][] = new int[len][len];
        for(int i = 0;i<str.length();i++){
            for(int j=i; j>=0; j--){
                if(j == i) arr[i][j] = 1;
                else if(j == i+1 && str.charAt(j) != str.charAt(i+1)) arr[i][j] = 1;
                else if(j == i+1 && str.charAt(j) == str.charAt(i+1)) arr[i][j] = 2;
                else if(str.charAt(j) == str.charAt(i) && j>0 && i < len-1) arr[i][j] = arr[i+1][j-1] + 2;
                else if(j > 0 && i < len-1)
                    arr[i][j] = Math.max(arr[i+1][j],arr[i][j-1]);
            }
        }
        for(int i = 0;i<str.length();i++)
        {
            for(int j = 0; j < str.length();j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("\n");
        }

    }
}
