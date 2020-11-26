import org.apache.commons.lang3.ArrayUtils;
public class List {
    private int[] array;
    public static void main(String[] args) {
        int[] a = {3,4,43,2,5,87,32,11,13,10,1,2};
        List list = new List();
        list.setArray(new int[]{3,4,43,2,5,87,32,11,13,10,1,2});
        list.sort();
        int[] b = list.getArray();
        System.out.println("array:"+ArrayUtils.toString(b));

    }
    public int[] getArray(){
        return array;
    }

    public void setArray(int[] a){
        array = ArrayUtils.clone(a);
    }
    public void add(int a){
        ArrayUtils.add(array, a);
    }
    public void sort(){
        array = mergeSort(array);
    }
    public void printArray(){
        System.out.println("array:"+ArrayUtils.toString(array));
    }
    public int[] mergeSort(int[] array){ //归并排序
        int len = ArrayUtils.getLength(array);
        if( len > 3){ //若array长度大于1 //*****将len>1改为>3
            int mid = len/2;
            int[] temp1 = ArrayUtils.subarray(array, 0, mid); //截取array[0]-array[mid]
            int[] temp2 = ArrayUtils.subarray(array, mid, len);//截取array[mid+1]-array[len-1]
            temp1 = mergeSort(temp1); //递归调用
            temp2 = mergeSort(temp2);
            array = merge(temp1, temp2); //合并两段有序数列
        }
        return array;
    }

    public int[] merge(int[] a1, int[] a2){ //合并有序数列
        int len1 = ArrayUtils.getLength(a1);
        int len2 = ArrayUtils.getLength(a2);
        int[] temp = new int[len1+len2];
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        while(n1 < len1 && n2 < len2 ){
            if( a1[n1] >= a2[n2]){ //改动：<=改为>=
                temp[n++] = a1[n1++];
            }
            else{
                temp[n++] = a2[n2++];
            }
        }
        for(int i = n1; i < len1; i++){
            temp[n++] = a1[n1++];
        }
        for(int i = n2; i < len2; i++){
            temp[n++] = a2[n2++];
        }
        //System.out.println(ArrayUtils.toString(temp));
        return temp;
    }
}