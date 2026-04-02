package Submission_of_Stacks_Queues_Hash_Maps;

public class circular_tour_problem {
    public static int printTour(int[] petrol, int[] distance) {
        int start = 0;
        int end = 1;
        int curr_petrol = petrol[start] - distance[start];

        while (end != start || curr_petrol < 0) {
            while (curr_petrol < 0 && start != end) {
                curr_petrol -= petrol[start] - distance[start];
                start = (start + 1) % petrol.length;
                if (start == 0) return -1;
            }
            curr_petrol += petrol[end] - distance[end];
            end = (end + 1) % petrol.length;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println("Start Index: " + printTour(petrol, distance));
    }
}