package Stacks;

public class indexSort {
    public static int[] indexSort(int []x){
        int [ ]y = new int[x.length];

        for (int i = 0; i < x.length; i++)
        {
            int index = 0;
            for (int j = 0; j < x.length; j++)
            {
                if(x[j] < x[i] || (x[j] ==x[i]) && (j < i)){
                    index++;
                }
            }
            y[index] = x[i];
        }
        return y;
    }
}
