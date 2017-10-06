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
        String str = "gghgghh";
        int len = str.length();
        int arr[][] = new int[len][len];
        for(int i = 0;i<str.length();i++){
            for(int j=i; j>=0; j--){
                if(i == j)
                    arr[j][i] = 1;
                else if(i == j+1 && str.charAt(i) != str.charAt(j))
                    arr[j][i] = 1;
                else if(i == j+1 && str.charAt(i) == str.charAt(j))
                    arr[j][i] = 2;
                else if(str.charAt(j) == str.charAt(i) && i>0 && j < len-1)
                    arr[j][i] = arr[j+1][i-1] + 2;
                else
                    arr[j][i] = Math.max(arr[j+1][i],arr[j][i-1]);
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
