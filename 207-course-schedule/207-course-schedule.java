class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] prereq : prerequisites){
            ArrayList<Integer> paths = graph.getOrDefault(prereq[1], new ArrayList<Integer>());
            paths.add(prereq[0]);
            graph.put(prereq[1], paths);
        }
        
        
        HashMap<Integer, Integer> incoming = new HashMap<>();
        for(int[] prereq : prerequisites){
            int freq = incoming.getOrDefault(prereq[0], 0) + 1;
            incoming.put(prereq[0], freq);
        }        
        
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int course = 0; course < numCourses; course++){
            if(!incoming.containsKey(course)){
                queue.add(course);
                count++;
            }
        }
        
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            ArrayList<Integer> paths = graph.getOrDefault(curr, new ArrayList<Integer>());
            
            for(int course : paths){
                incoming.put(course, incoming.get(course) - 1);
                
                if(incoming.get(course) == 0){
                    queue.add(course);
                    count++;
                }
            }
            
        }
        
        return numCourses == count;        
    }
}