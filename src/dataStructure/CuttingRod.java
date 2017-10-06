package dataStructure;

public class CuttingRod {
    public static void main(String[] args) {
        int n = 8;
        int price[] = {1,5,8,9,10,17,17,20};
        int len = price.length;
        int dp[] = new int[len+1];
        for(int i = 0; i < dp.length;i++)
            dp[i] = 0;
        dp[0] = 0;//price[0];
        for(int i = 0; i < len; i++){
            int arr[] = new int[i+1];
            for(int j = 0; j <= i;j++){
                arr[j] = price[j] + dp[i-j];
            }
            dp[i] = findMax(arr);
        }
        System.out.println(findMax(dp));
        for(int i = 0; i < price.length;i++)
            System.out.println(dp[i]);
    }
    public static int findMax(int a[]){
        if(a.length == 0) return 0;
        int max = a[0];
        for(int i = 0; i < a.length; i++){
            if(max < a[i]) max = a[i];
        }
        return max;
    }
}
