package test;


public class Ser {

        public static  int findMaxSubArray(int[] array) {
            if(array == null || array.length <= 0)
                return 0;
            int currentSum = 0;

            int greatestSum = 0;
            for(int i = 0; i < array.length; i++) {

                if(currentSum <= 0) {
                    currentSum = array[i];
                }
                else {
                    currentSum += array[i];
                }

                if(currentSum > greatestSum) {
                    greatestSum = currentSum;
                }
            }
            return greatestSum;
        }


        public static void main(String[] args) {
            int []arr={-23,17,-7,11,-2,1,-34};

            System.out.println(findMaxSubArray(arr));
    }

}
