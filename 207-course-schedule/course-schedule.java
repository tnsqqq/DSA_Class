class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        // build a graph
        for(int[] p : prerequisites){
            graph.get(p[1]).add(p[0]);
        }


        
        boolean[] visited = new boolean[numCourses];
        boolean[] restack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(dfs(graph, visited, restack, i)){
                return false; // cycle found
            }
        }
    }
    return true;
}

    public boolean dfs(List<List<Integer>> graph, boolean[] visited, boolean[] restack, int curr){
        visited[curr] = true;
        restack[curr] = true;

        for(int neigh : graph.get(curr)){
            if(!visited[neigh]){
               if(dfs(graph, visited, restack, neigh)){
                    return true;
                }
            } else if(restack[neigh]){
                return true;  // cycle detect
            }
        }
        restack[curr] = false; // backtrack
        return false;
    }
}