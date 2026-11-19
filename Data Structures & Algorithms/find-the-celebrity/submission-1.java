/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        HashSet<Integer> probableCelebs = new HashSet<>();
        for(int i = 0; i < n; i++) {
            probableCelebs.add(i);
        }

        int candidate = 0;
        for(int i = 0; i < n; i++) {
            if(i != candidate && knows(i, candidate)) {
                probableCelebs.remove(i);
            } else {
                probableCelebs.remove(candidate);
                candidate = i;
            }
        }
        // The set now has one possible celebrity: candidate.
        // Check whether they actually satisfy both conditions.
        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }

            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }
}
