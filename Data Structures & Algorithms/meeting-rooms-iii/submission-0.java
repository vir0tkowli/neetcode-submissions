class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        PriorityQueue<int[]> used = new PriorityQueue<>((a, b) -> a[0]==b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            rooms.offer(i);
        }

        int[] count = new int[n];

        for(int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            while (!used.isEmpty() && used.peek()[0] <= start) {
                int room = used.poll()[1];
                rooms.offer(room);
            }

            if(rooms.isEmpty()) {
                int[] cur = used.poll();
                int room = cur[1];
                end = cur[0] + (end - start);
                rooms.offer(room);
            }

            int room = rooms.poll();
            used.offer(new int[]{end, room});
            count[room]++;

        }

        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}
