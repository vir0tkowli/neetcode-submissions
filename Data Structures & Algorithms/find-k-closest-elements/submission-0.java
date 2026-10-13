class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Pair<Integer, Integer> search = closestIndex(arr, x);
        int searchIdx = search.getValue();
        int i = searchIdx - 1;
        int j = searchIdx + 1;
        List<Integer> res = new ArrayList<>();
        System.out.printf("search.getKey() %d \n", search.getKey());
        res.add(search.getKey()); k--;
        while(k > 0) {
            if (i < 0) {
                // No elements left on the left side.
                res.add(arr[j]);
                j++;
            } else if (j >= arr.length) {
                // No elements left on the right side.
                res.add(arr[i]);
                i--;
            } else if(Math.abs(arr[j] - x) < Math.abs(arr[i] -x)) {
                res.add(arr[j]);
                j++;
            } else {
                res.add(arr[i]);
                i--;
            }
            k--;
        }
        Collections.sort(res);
        return res;
    }
    private Pair<Integer, Integer> closestIndex(int[] arr, int x) {
        int i = 0; int j = arr.length -1;
        int minDelta = Integer.MAX_VALUE;
        while (i < j) {
            if(arr[i]==x) {
                return new Pair(x, i);
            }
            if(arr[j]==x) {
                return new Pair(x, j);
            }
            if(Math.abs(arr[j] - x) < Math.abs(arr[i] -x)) {
                minDelta = Math.min(minDelta, Math.abs(arr[j] - x));
                i++;
            } else {
                minDelta = Math.min(minDelta, Math.abs(arr[i] - x));
                j--;
            }
        }
        return new Pair<>(arr[i], i);
    }
}