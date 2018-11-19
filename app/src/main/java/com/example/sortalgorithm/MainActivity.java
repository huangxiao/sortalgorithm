package com.example.sortalgorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 *
 * @author
 * @description 几种常用的排序算法
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_INFO = "loginfo";
    int[] ids = {R.id.btn_bubbleSort,R.id.btn_quickSort,
            R.id.btn_insertSort,R.id.btn_shellSort,
            R.id.btn_selectSort, R.id.btn_heapSort,
            R.id.btn_mergeSort, R.id.btn_radixSort};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int id: ids) {
            findViewById(id).setOnClickListener(this);
        }
    }

    /**
     * 冒泡排序 bubble sort
     */
    private void bubbleSort(){
        int[] toSortNums = {2,10,5,3,7};

        int len = toSortNums.length;
        for(int i = 1; i < len - 1; i++){
            for (int j = 0; j < len - i; j++){
                if(toSortNums[j]>toSortNums[j+1]){

                    int temp = toSortNums[j];
                    toSortNums[j] = toSortNums[j+1];
                    toSortNums[j+1] = temp;
                }
            }
        }
        for(int i = 0; i <= len - 1; i++){
            Log.d( LOG_INFO, "冒泡排序后:"+toSortNums[i]);
        }
    }

    /**
     * 打印数组
     * @param array
     */
    private void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            Log.d(LOG_INFO, "排序前："+array[i]);
        }
    }

    //快速排序 quick sort
    private void quickSort(){
//        int[] unsorted = {2,10,5,3,7};
        int[] unsorted = {12,10,5,3,17, 6, 1};
        printArray(unsorted);
        quicksortImpl(unsorted, 0, unsorted.length-1);
        for (int i: unsorted ) {
            Log.d(LOG_INFO, "排序后："+i);
        }
    }

    /**
     * 快速排序具体实现方法
     */
    private void quicksortImpl(int[] unsorted, int left, int right){
        int partition = 0;
        if(left<right){
            partition = partition(unsorted, left, right);
            quicksortImpl(unsorted, left, partition-1);
            quicksortImpl(unsorted, partition+1, right);
        }
    }

    //找到分区点
    private int partition(int[] unsorted, int low, int high){

        int pivot = unsorted[low];

        while (low < high){
            while (low<high && unsorted[high]>pivot)
                high--;
            unsorted[low] = unsorted[high];
            while(low<high && unsorted[low]<=pivot)
                low++;
            unsorted[high] = unsorted[low];
        }
        unsorted[low] = pivot;
        return low;
    }



    /**
     * 插入排序 insert sort
     */
    private void insertSort(){

    }

    /**
     *  希尔排序
     */
    private void shellSort(){

    }

    /**
     * 选择排序
     */
    private void selectSort(){

    }

    /**
     * 堆排序 heap sort
     */
    private void heapSort(){

    }
    /**
     *  归并排序
     */
    private void mergeSort(){

    }

    /**
     * 基数排序
     */
    private void radixSort(){

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.btn_bubbleSort:{
                bubbleSort();
                Toast.makeText(MainActivity.this, "冒泡排序", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.btn_quickSort:{
                Toast.makeText(MainActivity.this, "quick sort", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        quickSort();
                    }
                }).start();

            }
            break;
            case R.id.btn_insertSort:{
                Toast.makeText(MainActivity.this, "insert sort", Toast.LENGTH_SHORT).show();
                insertSort();
            }
            break;
            case R.id.btn_shellSort:{
                Toast.makeText(MainActivity.this, "shell sort", Toast.LENGTH_SHORT).show();
                shellSort();
            }
            break;
            case R.id.btn_selectSort:{
                Toast.makeText(MainActivity.this, "select sort", Toast.LENGTH_SHORT).show();
                selectSort();
            }
            break;
            case R.id.btn_heapSort:{
                Toast.makeText(MainActivity.this, "heap sort", Toast.LENGTH_SHORT).show();
                heapSort();
            }
            break;
            case R.id.btn_mergeSort:{
                Toast.makeText(MainActivity.this, "merge sort", Toast.LENGTH_SHORT).show();
                mergeSort();
            }
            break;
            case R.id.btn_radixSort:{
                Toast.makeText(MainActivity.this, "radix sort", Toast.LENGTH_SHORT).show();
                radixSort();
            }
            break;
        }
    }


}
