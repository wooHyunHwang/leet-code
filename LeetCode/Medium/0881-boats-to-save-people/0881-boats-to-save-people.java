class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int boat = 0;
        int main = people.length -1;
        
        while (main > -1) {
            int stack = limit;
            
            // System.out.println(main + "===========");
            while (main > -1 && people[main] == -1) main--;

            if (main == -1) break;

            boat++;
            stack -= people[main];
            people[main--] = -1;

            for (int left = 0; left <= main; ++left) {
                if (people[left] == -1) continue;
                if (people[left] > stack) break;
                people[left] = -1;
                break;
            }

            // System.out.println(" stack " + stack);
        }

        return boat;
    }
}
// 1 2 4 4 5 7