package dataStructure;

/*

LS(i) = 1 + max{LS(g)} where i<j && A(i) > A(j)
      = 1  if no such j is found
            0  1  2 3 4  5  6  7  8
Example :- 10,22,9,33,21,50,41,60,80
LS(0) = 1
LS(1) = 1 + max{S(0)} = 2
LS(2) = 1
LS(3) = 1 + max{S(0),S(1),S(2)} = 1 + 2 = 3
LS(4) = 1
LS(5) = 1 + max{S(0),S(1),S(3),S(4)} = 1 + 3 = 4
LS(6) = 1
LS(7) = 1 + max{S(0),S(1),S(3),S(4),S(5),S(6)} = 1 + 4 = 5
LS(8) = 1 + max{S(0),S(1),S(3),S(4),S(5),S(6)} = 1 + 5 = 6

 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {10,9,12,11,20,17,18,19,30,45,60,80};
        int len = arr.length;
        int[] maxSub = new int[len];
        for(int i=0; i<len; i++)
            maxSub[i] = 1;

        for(int i = 1; i<len; i++)
            for(int j=i-1; j>=0; j--)
                if(arr[i] > arr[j] && maxSub[i] < (maxSub[j] + 1))
                    maxSub[i] = maxSub[j] + 1;

        int max = 1;
        for(int i=0; i<len; i++)
            if(max < maxSub[i])
                max = maxSub[i];

        System.out.println(max);

    }
}
