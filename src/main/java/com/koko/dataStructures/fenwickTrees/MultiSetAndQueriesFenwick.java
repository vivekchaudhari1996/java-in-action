package com.koko.dataStructures.fenwickTrees;

import java.util.Arrays;
import java.util.Map;

public class MultiSetAndQueriesFenwick {

    // Q: Given a multiset of numbers from 1->N
    // Given Queries-> -ve nbr means delete the nbr at that position.
    // +ve nbr means add that number.
    // Find any nbr left at last after all queries are done.


    // Solution:
    // Using BIT or fenwick
    // Mark BIT as 1 for all positions which are present in orig array.
    // BIT is represented as an array of size equal to maximum element plus one.
    // So that elements can be used as an index.
    // Now perform -ve query: Use Binary search and sum together to find which nbr to delete.
    // And add -1 at that position.
    // TC: O(logn^2)

    // For +ve query, add 1 at that position.


    public static void main(String args[])
    {
        int freq[] = {2, 1, 1, 3, 2, 3};
        int queries[] = {-2, -1, 1, 3, -2, 3};

        int n = freq.length;
        int N = 6; // Assuming nbrs are between 1->6, So max elem = 6
        int temp[] = new int[N+1];
        Arrays.fill(temp, 0);

        BinaryIndexedTreeOrFenwick tree = new BinaryIndexedTreeOrFenwick();

        for(int i=0;i<freq.length;i++){
            temp[freq[i]]++; // this will keep track of nbr present.
        }
        tree.constructBITree(temp, N+1);

        for(int i=0;i<queries.length;i++){
            int x = queries[i];
            if(x > 0){
                tree.updateBIT(N+1, x, 1); // logN
            }else{
                x = Math.abs(x);
                int low = 0, high = N+1;
                while (low < high)   // LogN
                {
                    int mid = (low + high) / 2;
                    int val = tree.getSum(mid);

                    if (x <= val)
                        high = mid;
                    else
                        low = mid + 1;
                }
                tree.updateBIT(N+1, low, -1); // logN
            }
        }

        int nbr = -1; // this will give you any of final nbr that exists in array.
        int ans = tree.getSum(N+1);

        if (ans > 0) { // either do a Binary search
            int low = 0, high = N+1;
            while (low < high)
            {
                int mid = (low + high) / 2;
                int val = tree.getSum(mid);

                if (ans <= val)
                    high = mid;
                else
                    low = mid + 1;
            }
            nbr = low;
        }
        // Or scan from leftmost index and find where getSum gives you more than 0.
        // Thats the nbr you can take as output.
    }
}
