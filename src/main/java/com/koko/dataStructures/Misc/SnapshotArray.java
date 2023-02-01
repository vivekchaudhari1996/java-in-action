package com.koko.dataStructures.Misc;

import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {

    // Q:
    /*
    Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length.
Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the
snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index,
at the time we took the snapshot with the given snap_id
     */



    // Example:
    /*
    Input: ["SnapshotArray","set","snap","set","get"]

            [[3],[0,5],[],[0,6],[0,0]]
    Output: [null,null,0,null,5]
    Explanation:
    SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5


     */




    // Solution1:
    // Using history and delta map.


    //map <Snap_id , Value> for each index (array of maps)
    HashMap<Integer,Integer>[] snapShotHistory;

    //totalSnaps taken
    int totalSnaps;

    //map of delta updates made <index, value>
    HashMap<Integer,Integer> deltaUpdate;

    public SnapshotArray(int length) {
        //keep track of the delta updates made in each iteration
        deltaUpdate=new HashMap<>();

        //initialize a snapshot history
        snapShotHistory=new HashMap[length];
        for(int i=0; i<length; i++){
            snapShotHistory[i]=new HashMap<>();
        }
    }

    public void set(int index, int val) {
        //add a delta update for this index, value pair
        deltaUpdate.put(index,val);
    }

    public int snap() {
        //add the current mapping at each index, value pair
        for (int key: deltaUpdate.keySet()){
            HashMap<Integer, Integer> snapHistoryAtIndex = snapShotHistory[key];
            //add a snapshot of the <snapId, value> to the index updated
            snapHistoryAtIndex.put(totalSnaps, deltaUpdate.get(key));
        }

        //reset out delta update map
        deltaUpdate=new HashMap<>();

        //incremement our total snaps and return the snap id
        totalSnaps++;
        return totalSnaps-1;
    }

    public int get(int index, int snap_id) {
        //find the most recent update to that index from the snapId specified and before
        while(snap_id>=0){
            if(snapShotHistory[index].containsKey(snap_id))
                return snapShotHistory[index].get(snap_id);
            snap_id--;
        }

        //if there was never an update to that index, it will just be equal to 0
        return 0;
    }




    // Sol2:
    // Using just one map.


    private int currentSnapshot;

    private Map<Integer, Integer>[] snapshotMap;

    public void SnapshotArray2(int length) {
        this.snapshotMap = new HashMap[length];
        for(int i = 0 ; i < length ; i++){
            this.snapshotMap[i] = new HashMap<>();
        }
        this.currentSnapshot = 0;
    }

    public void set2(int index, int val) {
        this.snapshotMap[index].put(this.currentSnapshot,val);
    }

    public int snap2() {
        this.currentSnapshot++;
        return this.currentSnapshot-1;
    }

    public int get2(int index, int snap_id) {
        Map<Integer,Integer> map  = this.snapshotMap[index];
        while(snap_id >= 0){
            if(map.containsKey(snap_id)){
                return map.get(snap_id);
            }
            snap_id--;
        }
        return 0;
    }
}
