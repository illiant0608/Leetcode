import java.util.Stack;

/**
 * better solution
 * Stack<Integer> stack = new Stack<>();
 *         for (int i = 0; i < a.length; i++) {
 *             if (stack.isEmpty() || a[i] > 0) {
 *                 stack.push(a[i]);
 *                 continue;
 *             }
 *
 *             while (true) {
 *                 int prev = stack.peek();
 *                 if (prev < 0) {
 *                     stack.push(a[i]);
 *                     break;
 *                 }
 *                 if (prev == -a[i]) {
 *                     stack.pop();
 *                     break;
 *                 }
 *                 if (prev > -a[i]) {
 *                     break;
 *                 }
 *                 stack.pop();
 *                 if (stack.isEmpty()) {
 *                     stack.push(a[i]);
 *                     break;
 *                 }
 *             }
 *         }
 *
 *         int[] res = new int[stack.size()];
 *         for (int i = stack.size() - 1; i >= 0; i--) {
 *             res[i] = stack.pop();
 *         }
 *
 *         return res;
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < asteroids.length;i++) {
            if (asteroids[i] > 0)
                stack.push(asteroids[i]);
            else {
                if (stack.empty())
                    stack.push(asteroids[i]);
                else {
                    int num = stack.pop();
                    if (num < 0){
                        stack.push(num);
                        stack.push(asteroids[i]);
                    }

                    else {
                        if (num > Math.abs(asteroids[i])){
                            stack.push(num);
                            continue;
                        } else if (num < Math.abs(asteroids[i])) {
                            boolean nullFlag = false;
                            while (stack.size() > 0) {
                                int nextNum = stack.pop();
                                if (nextNum < 0){
                                    stack.push(nextNum);
                                    stack.push(asteroids[i]);
                                    break;
                                }
                                if (nextNum < Math.abs(asteroids[i]))
                                    continue;
                                else if (nextNum > Math.abs(asteroids[i])){
                                    stack.push(nextNum);
                                    break;
                                } else {
                                    nullFlag = true;
                                    break;
                                }


                            }
                            if (stack.size() == 0 && !nullFlag)
                                stack.push(asteroids[i]);
                        }
                    }
                }
            }
        }

        int[] ret = new int[stack.size()];
        for (int i = ret.length-1;i >= 0;i--) {
            ret[i] = stack.pop();
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] asteroids = {2, -1, 1, -2};
        AsteroidCollision test = new AsteroidCollision();
        test.asteroidCollision(asteroids);
    }
}
