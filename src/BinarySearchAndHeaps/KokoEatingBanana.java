package BinarySearchAndHeaps;

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        //find the max of piles
        int max = 0;
        for(int pile : piles) {
            max = Math.max(pile, max);
        }
        //the max speed at which koko can eat all the banana is max
        //now we need to find the minimum one
        int start = 1;
        int end = max;
        int minPossibleSpeed = 0;
        while(start <= end){
            int mid = (end+start)/2;
            //check if this speed is right or not
            int totalTime = calculateTotalTime(piles, mid);
            if(totalTime>h){
                //we need to increase the speed
                start = mid+1;
            }else {
                //in this speed she can complete eating banana's find smaller than this
                minPossibleSpeed = mid;
                end = mid-1;
            }
        }
        return minPossibleSpeed;
    }

    public int calculateTotalTime(int[] piles, int speed){
        int totalTime = 0;
        for(int pile : piles){
            totalTime += (pile/speed);
            if(pile%speed!=0) {
                totalTime +=1;
            }
        }
        return  totalTime;
    }
}
