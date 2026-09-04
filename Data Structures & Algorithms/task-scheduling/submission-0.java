class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] repeated = new int[26];
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        Deque<int[]> queue = new ArrayDeque<>();
        int time = 0;

        for(char c : tasks){
            repeated[c - 'A']++;
        }

        for(int i : repeated){
            if(i > 0){
                heap.add(i);
            }
        }

        while(!heap.isEmpty() || !queue.isEmpty()){
            time++;
            int temp = 0;

            if(!heap.isEmpty())
                temp = heap.poll() - 1;
            
            if(temp > 0 )
                queue.add(new int[]{temp, time + n});

            if(!queue.isEmpty() && time >= queue.peek()[1]){
                heap.add(queue.pop()[0]);
            }
        }

        return time;
    }
}