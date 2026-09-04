class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, Integer>> heap = new PriorityQueue<>(
            (a,b) -> {
                int comp = a.getKey().compareTo(b.getKey());
                if(comp != 0) return comp;
                return a.getValue().compareTo(b.getValue());
            }   
        );
        int[][] ans = new int[k][2];
        int pointer = 0;

        for(int i = 0 ; i < points.length ; i++){
            Double distance = Math.sqrt(Math.pow(points[i][0] - 0, 2) + Math.pow(points[i][1] - 0, 2));
            heap.add(new Pair<>(distance, i));
        }

        while(!heap.isEmpty() && k > 0){
            ans[pointer++] = points[heap.poll().getValue()];
            k--;
        }

        return ans;
    }
}