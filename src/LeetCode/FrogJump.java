package LeetCode;

/**
 * Created by Shaun on 10/1/2016.
 */
public class FrogJump {
    public static void main(String[] args) {
        FrogJump ins = new FrogJump();
        int[] stones = {0,1};
        if(ins.canCross(stones)) {
            System.out.println("Can jump");
        }
    }

    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) {
            return false;
        }
        if(stones.length == 1) {
            return stones[0] == 0;
        }
        if(stones[1] != 1) {
            return false;
        }
        int len = stones.length;
        //the biggest speed/step to jump on stone index (len-1) is (len-1), so the col size is also len
        boolean[][] dp = new boolean[len][len];

        //The frog can jump to stone index 1(row) with last jump speed/step of 1 unit(column)
        dp[1][1] = true;
        for(int cur=2; cur<len; cur++) {
            for(int prev=1; prev<cur; prev++) {
                int units = stones[cur] - stones[prev];
                int left = Math.min(units-1, len-1);
                int right = Math.min(units+1, len-1);
                for(int index=left; index<=right; index++) {
                    if(dp[prev][index]) {
                        dp[cur][units] = true;
                        break;
                    }
                }
            }
        }

        for(int i=0; i<len; i++) {
            if(dp[len-1][i]) {
                return true;
            }
        }
        return false;
    }
}
