public class CanPlaceFlower_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed.length == 1) {
            if (n == 1)
                return flowerbed[0] == 0;
        }

        if (n == 0)
            return true;


        int count = 0;
        for (int i = 0;i < flowerbed.length;i++) {
            if (flowerbed[i] == 0)
                count++;
        }

        if (count < n / 2)
            return false;

        count = 0;
        for (int i = 0;i < flowerbed.length;i++) {

            if (flowerbed[i] == 0 && canPlace(flowerbed, i)) {
                count++;
                flowerbed[i] = 1;
            }

            if (count >= n)
                return true;

        }

        return false;

    }

    private boolean canPlace(int[] flowerbed, int pos) {
        if (pos == 0) {
            if (flowerbed[1] == 0)
                return true;
            else
                return false;
        } else if (pos == flowerbed.length - 1) {
            if (flowerbed[pos - 1] == 0)
                return true;
            else
                return false;
        } else
            return flowerbed[pos - 1] == 0 && flowerbed[pos + 1] == 0;




    }

    public static void main(String[] args) {
        int[] flowered = {1, 0, 0, 0, 1};
        CanPlaceFlower_605 test = new CanPlaceFlower_605();
        System.out.println(test.canPlaceFlowers(flowered, 2));
    }
}
