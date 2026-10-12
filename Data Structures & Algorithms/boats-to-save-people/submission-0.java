class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0; int j = people.length-1;
        int nan = 0; int minBoat = 0;
        while(i <= j) {
            minBoat++;
            if(people[i] + people[j] <= limit) {
                i++; j--;
            } else {
                j--;
            }
        }
        return minBoat;
    }
}