package com.koko.dataStructures.Misc;

import java.util.Random;

public class SongShuffler {

    // Q:
    /*
    Given a playlist of songs, you have to design a song shuffler.
This song shuffler is not like the normal song shuffler that shuffles the complete playlist
at the start and returns a shuffled list, but instead when asked for a next song to be played,
returns a random song from the list of songs.
The next random song to be played should satisfy a condition that
the song was not played in the last 'k' turns.
You have to make sure, that at each call, all the eligible (not played during last k turns)
songs have equal probability of being played next.
     */




    // Solution1:

    // TC O(1) SC O(1), we can just reserve first 0...k-1 indices of array as our played queue.


    /*
    class SongShuffler() {
        String[] songs;
        Random random;
        int playedIndex;
        int playIndex;
        int k;
        public SongShuffler(String[] songs, int k) {
            this.songs() = songs;
            random = new Random();
            playedIndex = 0;
            playIndex  = 0;
            this.k = k;
        }

        public String playShuffleSong() {
            int nextSong = random.nextInt(playIndex, songs.length);
            String ret = songs[nextSong];
            swap(playIndex, nextSong);
            if(playIndex<k) playIndex++;
            if(playIndex==k) {
                swap(playedIndex, playIndex);
                playedIndex++;
                if(playedIndex==k) playedIndex = 0;
            }
            return ret;
        }
    }

     */



    // Sol2:
    // A variant of RandomizedSet problem.




    // Sol3:
    // Using Queue

    // Use Queue to track last k songs played.
    //Use ArrayList to store songs (not played in last k turns).
    //Use Java Random class to get a random number (upperBound being array size),
    //Pick the song at that index in array (to return as method output and push at the end of Queue),
    //Then fill that gap (random index) with the song at the last index in the array.
    // Then remove the song at last index. (As this won't change the randomness,
    // and will guarantee equal probability for each song)
    //If Queue length was > k, remove first song and add at the end of array.


    //Time Complexity = O(1)
    //Space Complexity = O(n) at max
    //where n is number of songs, k is queue size



    /*
    def __init__(self, playList,k):
        self.playList=playList
        self.maxLast=k
        self.queue=collections.deque([])

    def playNext(self,):
        ##get random index from the current length of the playlist, so we can get our random song
        randomIdx=random.randint(0,len(self.playList)-1)
        #swap this item to the end and pop it out.
        self.playList[randomIdx],self.playList[len(self.playList)-1]=self.playList[len(self.playList)-1],self.playList[randomIdx]
        playSong=self.playList.pop()

        self.queue.append(playSong)
        if len(self.queue)>self.maxLast:
            self.playList.append(self.queue.popleft())
        ##print(self.playList,self.queue)
        return playSong
     */
}
