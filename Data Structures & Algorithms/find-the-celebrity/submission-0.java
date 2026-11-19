/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Map<Integer, Integer> adjMap = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && knows(i, j)) {
                    adjMap.put(i, adjMap.getOrDefault(i, 0) + 1);
                    indegree.put(j, indegree.getOrDefault(j, 0) + 1);
                }
            }
        }

        for(int person = 0; person < n; person++) {
            if(adjMap.getOrDefault(person, 0) == 0 && indegree.getOrDefault(person, 0) == n-1) {
                return person;
            }
        }
        return -1;
    }


}
