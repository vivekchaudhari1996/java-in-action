package com.koko.dataStructures.Misc;

import java.util.Arrays;

public class MusicPlaylists {

    // Q:
    /*
    Your music player contains n different songs. You want to listen to goal songs
    (not necessarily different) during your trip.
    To avoid boredom, you will create a playlist so that:

Every song is played at least once.
A song can only be played again only if k other songs have been played.
Given n, goal, and k, return the number of possible playlists that you can create.
Since the answer can be very large, return it modulo 109 + 7.
     */




    // Example:
    /*
    Input: n = 2, goal = 3, k = 1
Output: 2
Explanation: There are 2 possible playlists: [1, 2, 1] and [2, 1, 2].
     */




    // Solution1:
    // DP
    // https://leetcode.com/problems/number-of-music-playlists/solution/


    // Let dp[i][j] be the number of playlists of length i that have exactly j unique songs.
    // We want dp[L][N], and it seems likely we can develop a recurrence for dp.
    // Consider dp[i][j]. Last song, we either played a song for the first time or we didn't.
    // If we did, then we had dp[i - 1][j - 1] * (N - j + 1) ways to choose it.
    // If we didn't, then we repeated a previous song in dp[i-1][j] * max(j-K, 0) ways
    // (j of them, except the last K ones played are banned.)


    // TC: O(NL), SC: O(NL)

    public int numMusicPlaylists(int N, int L, int K) {
        int MOD = 1_000_000_007;

        long[][] dp = new long[L+1][N+1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; ++i)
            for (int j = 1; j <= N; ++j) {
                dp[i][j] += dp[i-1][j-1] * (N-j+1);
                dp[i][j] += dp[i-1][j] * Math.max(j-K, 0);
                dp[i][j] %= MOD;
            }

        return (int) dp[L][N];
    }




    // Sol2:
    // Partitions + DP

    // TC: O(NL), SC: O(L)

    public int numMusicPlaylists2(int N, int L, int K) {
        int MOD = 1_000_000_007;

        // dp[S] at time P = <S, P> as discussed in article
        long[] dp = new long[L-N+1];
        Arrays.fill(dp, 1);
        for (int p = 2; p <= N-K; ++p)
            for (int i = 1; i <= L-N; ++i) {
                dp[i] += dp[i-1] * p;
                dp[i] %= MOD;
            }

        // Multiply by N!
        long ans = dp[L-N];
        for (int k = 2; k <= N; ++k)
            ans = ans * k % MOD;
        return (int) ans;
    }





    // Sol3:
    // Functions


    // O(NlogL), SC: O(1)

    /*
    def numMusicPlaylists(self, N, L, K):
        MOD = 10**9 + 7
        def inv(x):
            return pow(x, MOD-2, MOD)

        C = 1
        for x in xrange(1, N-K):
            C *= -x
            C %= MOD
        C = inv(C)

        ans = 0
        for k in xrange(1, N-K+1):
            ans += pow(k, L-K-1, MOD) * C
            C = C * (k - (N-K)) % MOD * inv(k) % MOD

        for k in xrange(1, N+1):
            ans = ans * k % MOD
        return ans
     */
}
