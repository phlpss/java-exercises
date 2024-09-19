public class СanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;

        for(int i = 0; i < length; i++) {
            if(flowerbed[i] == 0) {
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == length - 1) || (flowerbed[i + 1] == 0);

                if(emptyLeftPlot & emptyRightPlot) {
                    flowerbed[i] = 1;
                    count++;

                    if(count >= n) return true;
                    i++;
                }
            }
        }
        return count >= n;
    }
}
