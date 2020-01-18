import java.util.Arrays;

public class BoatsToSavePeople_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int min_ptr = 0;
        int max_ptr = people.length - 1;
        int boat_count = 0;
        while (min_ptr <= max_ptr) {
            if (people[min_ptr] + people[max_ptr] <= limit) {
                min_ptr++;
                max_ptr--;
            } else {
                max_ptr--;
            }

            boat_count++;
        }

        return boat_count;
    }

    public static void main(String[] args) {
        BoatsToSavePeople_881 test = new BoatsToSavePeople_881();
        int[] people = {1, 2};
        System.out.println(test.numRescueBoats(people, 3));
    }
}
