package test;

/**
 * Created by Qi on 2017/8/26.
 */
public class Kth {


        /**
         * @param args
         */
        public static void main(String[] args) {
            int[] arrs = new int[]{32,21,54,88,64,32,43,54,76,87,98,8723};

            for(int n = arrs.length/2 - 1;n>=0;n--){
                create(arrs,n,arrs.length);
            }
            for(int i = arrs.length-1; i>0 ; i--){
                getMax(arrs, i);
            }


            for (int i : arrs) {
                System.out.print(i+"_");
            }

        }

        public static void create(int[] arrs, int root, int all){
            int m = 2*root+1;

            //判断有没有子节点
            if(m<all){
                //有左子节点

                if((m+1)<all){
                    //有右子节点

                    if(arrs[m] < arrs[m+1]){
                        //那么右子节点大，标记右
                        m = m+1;
                    }
                }
                //判断父节点和左或者右子节点谁大
                if(arrs[root] < arrs[m]){
                    int temp = arrs[root];
                    arrs[root] = arrs[m];
                    arrs[m] = temp;

                    //这块的核心便是最开始传递进来的时候，进行比较，但是在这里交换完成了，那么root子节点的值发生的变化
                    //那么有可能子节点原来可以大于它自身的子节点，但现在数据变小，所以需要重新判断，递归
                    create(arrs, m, all);//递归的目的是让数据再从当前节点再次执行一下，重新对下面的节点进行排序。
                    //递归是让当前节点下面的节点按照顺序排列
                    //n--是遍历每一个节点，对每一个节点都进行处理，

                }
            }else{
                return;
            }
        }

        public static void getMax(int[] arrs, int all){
            //将第一个和最后一个互换
            int temp = arrs[all];
            arrs[all] = arrs[0];
            arrs[0] = temp;

            //此时因为数组中顺序基本上是已经属于堆，所以直接从0开始向下找寻即可
            create(arrs, 0, all);

        }

    }

