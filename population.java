import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by meryqing on 20/5/2017.
 */

public class population {

    static int[] allcitys = new int[] {18897109, 12828837, 9461105, 6371773, 5965343, 5946800, 5582170, 5564635, 5268860, 4552402, 4335391, 4296250, 4224851, 4192887, 3439809, 3279833, 3095313, 2812896, 2783243, 2710489, 2543482, 2356285, 2226009, 2149127, 2142508,  2134411};
    static int[] test = new int[]{1,2,3};
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
      population pop = new population();
      pop.getsubsetcitys(allcitys);
    }

    public void getsubsetcitys(int[] allcitys) {
        List<Integer> subset = new ArrayList<Integer>();
        int totalPeople = 0;
        int threshold = 100000000;
//        for (int population : allcitys){
//            totalPeople += population;
//        }
//        int avgPopulation = totalPeople/26;
//        int citiesNum = threshold/avgPopulation;
        //C26 20
//        int offset = totalPeople - threshold;
//        Log.i("getcitys", "total 26 citys = " + totalPeople + "offset ="+offset);
//        threshold/allcitys[0] = 5.xx so at least there need 6 cites
        // subsets(allcitys);
       populateSubset(allcitys, 0, allcitys.length, 0, threshold,15,24);
    }

    public void subsets(int[] a)
    {
        calc(0,a.length, a);
    }

    private void calc(int from, int to, int[] a)
    {
        for(int i=from;i<to;i++)
        {
            // System.out.print("i = "+ i +"from "+ from+ "to "+to+"current "+ a[i]);
            // System.out.println();
            stack.push(a[i]);
            calc(i+1,to, a);
            // System.out.print("i = "+ i +"from "+ from+ "to "+to+"poped ="+stack.lastElement());
            // System.out.println();
            stack.pop();
        }
        // System.out.print("from "+ from+ "to "+to);
        // System.out.println();
        for(Integer i:stack)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    /*
    other solustion
    */

    public void populateSubset(int[] values, int begin, int end,
                               int sumInStack, int expectedSum, int minNum, int maxNum) {
        /*
         * 判断Stack中的数据和是否等于目标值，如果是则输出当前Stack中的数据
         */
        if (sumInStack == expectedSum) {

            /*
             * 只有当子集中元素个数在期望的范围内[minNum, maxNum]，才打印出结果。
             */
            if (stack.size() >= minNum && stack.size() <= maxNum) {
                print(stack, expectedSum);
                return;
            }
        }

        for (int currentIndex = begin; currentIndex < end; currentIndex++) {
            /*
             * 如果当前Stack中的和加上当前index的数据小于等于目标值， 那么将当前的index的数据添加到Stack中去，
             * 同时，将当前Stack中所有数据的和加上新添加到Stack中的数值
             */
            if (sumInStack + values[currentIndex] <= expectedSum) {
                stack.push(values[currentIndex]);
                sumInStack += values[currentIndex];
                // 当前index加上1，递归调用本身
                populateSubset(values, currentIndex + 1, end, sumInStack,
                        expectedSum, minNum, maxNum);

                sumInStack -= stack.pop();
            }

        }
    }

    private void print(Stack<Integer> stack, int expectedSum) {
        sb.setLength(0);
        sb.append(expectedSum + " = ");
        for (int element : stack) {
            sb.append(element + "+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
