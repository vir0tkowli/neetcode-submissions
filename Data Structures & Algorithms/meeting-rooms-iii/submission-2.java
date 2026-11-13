class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        // {endtime, room #}
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>(
            Comparator.comparingInt((int[] room) -> room[0]).thenComparingInt((int[] room) -> room[1]));

        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        int[] count = new int[n];

        for(int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            // release all rooms that is already free at its this start time.
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                int finishedRoom = busyRooms.poll()[1];
                availableRooms.offer(finishedRoom);
            }

            int room;

            if (!availableRooms.isEmpty()) {
                // Start on time in the smallest available room.
                room = availableRooms.poll();
            } else {
                // Wait for the earliest available room.
                int[] earliestRoom = busyRooms.poll();
                room = earliestRoom[1];
                end = earliestRoom[0] + duration;
            }

            busyRooms.offer(new int[]{end, room});
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
