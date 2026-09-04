class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;
        int[] courses = new int[numCourses];

        for(int[] i : prerequisites){
            courses[i[0]]++;
            List<Integer> l = map.getOrDefault(i[1], new ArrayList<>());
            l.add(i[0]);
            map.put(i[1], l);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(courses[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            ans[index++] = current;
            if(map.containsKey(current)){
                for(int i : map.get(current)){
                    courses[i]--;
                    if(courses[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }

        return index == numCourses ? ans : new int[0];
    }
}
