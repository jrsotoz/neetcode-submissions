class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int coursed = 0;

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
            int aux = queue.remove();
            coursed++;
            if(map.containsKey(aux)){
                for(int i : map.get(aux)){
                    courses[i]--;
                    if(courses[i] == 0){
                        queue.add(i);
                    }
                }
            }
            if(numCourses == coursed){
                return true;
            }
        }

        return false;
    }
}
