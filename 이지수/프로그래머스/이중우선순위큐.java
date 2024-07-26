import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations) {
            String[] tmp = op.split(" ");
            int n = Integer.parseInt(tmp[1]);
            
            if(tmp[0].equals("I")) {
                minPq.offer(n);
                maxPq.offer(n);
            } else {
                if(minPq.isEmpty()) continue;
                
                if(tmp[1].charAt(0) == '1') {
                    int max = maxPq.poll();
                    minPq.remove(max);
                } else {
                    int min = minPq.poll();
                    maxPq.remove(min);
                }
            }
        }
        
        if(minPq.isEmpty()) return new int[] {0, 0};
        
        return new int[] {maxPq.poll(), minPq.poll()};
    }
}
