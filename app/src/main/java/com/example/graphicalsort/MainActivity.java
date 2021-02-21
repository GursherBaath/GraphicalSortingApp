package com.example.graphicalsort;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int row = 40;
    int col = 12;
    ImageView pics[] = new ImageView[row * col];
    int nums[][] = new int[row][col];
    int place = -1;
    int a[] = {11, 8, 3, 12, 2, 5, 1, 6, 9, 7, 4, 10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout g = (GridLayout) findViewById(R.id.grid);
        int m = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pics[m] = new ImageView(this);
                setpicStart(pics[m], m);
                pics[m].setId(m);
                g.addView(pics[m]);
                m++;
            }
        }
    }

    public void Selection(View view) {
        clear();
        unsort();
        selectionSort(a);
        redraw();
    }

    public void selectionSort(int a[]) {
        for (int left = a.length - 1; left > 0; left--) {
            int max = 0;
            for (int i = 1; i <= left; i++) {
                if (a[max] < a[i])
                    max = i;
            }
            int temp = a[max];
            a[max] = a[left];
            a[left] = temp;
            addNewRow();
        }
    }

    public void Bubble (View view) {
        clear();
        unsort();
        bubbleSort(a);
        redraw();
    }

    public void bubbleSort(int a[]) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    addNewRow();
                }
            }
        }
    }


    public void Shaker (View view) {
        clear();
        unsort();
        shakerSort(a);
        redraw();
    }

    public void shakerSort(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            boolean swapped = false;
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                    addNewRow();
                }
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                if (array[j] > array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    swapped = true;
                    addNewRow();
                }
            }
            if (!swapped) break;
        }
    }

    public void Quick(View view) {
        clear();
        unsort();
        quicksort(a, 0, a.length - 1);
        redraw();
    }

    public void quicksort(int a[], int lo0, int hi0) {
        int lo = lo0;
        int hi = hi0;
        if (lo >= hi) {
            return;
        }
        int mid = a[(lo + hi) / 2];
        while (lo < hi) {
            while (lo < hi && a[lo] < mid) {
                lo++;
            }
            while (lo < hi && a[hi] > mid) {
                hi--;
            }
            if (lo < hi) {
                int T = a[lo];
                a[lo] = a[hi];
                a[hi] = T;
                addNewRow();
            }
        }
        if (hi < lo) {
            int T = hi;
            hi = lo;
            lo = T;
            addNewRow();
        }
        quicksort(a, lo0, lo);
        quicksort(a, lo == lo0 ? lo + 1 : lo, hi0);
    }


    public void setpicStart(ImageView i, int pos) {
        int x = pos / col;
        int y = pos % col;
        int picnum = nums[x][y];
        if (picnum == 1)
            i.setImageResource(R.drawable.p0);
        else if (picnum == 2)
            i.setImageResource(R.drawable.p1);
        else if (picnum == 3)
            i.setImageResource(R.drawable.p2);
        else if (picnum == 4)
            i.setImageResource(R.drawable.p3);
        else if (picnum == 5)
            i.setImageResource(R.drawable.p4);
        else if (picnum == 6)
            i.setImageResource(R.drawable.p5);
        else if (picnum == 7)
            i.setImageResource(R.drawable.p6);
        else if (picnum == 8)
            i.setImageResource(R.drawable.p7);
        else if (picnum == 9)
            i.setImageResource(R.drawable.p8);
        else if (picnum == 10)
            i.setImageResource(R.drawable.p9);
        else if (picnum == 11)
            i.setImageResource(R.drawable.p10);
        else if (picnum == 12)
            i.setImageResource(R.drawable.p11);
        else
            i.setImageResource(R.drawable.blank);
    }

    public void redraw() {
        int m = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nums[i][j] == 1)
                    pics[m].setImageResource(R.drawable.p0);
                else if (nums[i][j] == 2)
                    pics[m].setImageResource(R.drawable.p1);
                else if (nums[i][j] == 3)
                    pics[m].setImageResource(R.drawable.p2);
                else if (nums[i][j] == 4)
                    pics[m].setImageResource(R.drawable.p3);
                else if (nums[i][j] == 5)
                    pics[m].setImageResource(R.drawable.p4);
                else if (nums[i][j] == 6)
                    pics[m].setImageResource(R.drawable.p5);
                else if (nums[i][j] == 7)
                    pics[m].setImageResource(R.drawable.p6);
                else if (nums[i][j] == 8)
                    pics[m].setImageResource(R.drawable.p7);
                else if (nums[i][j] == 9)
                    pics[m].setImageResource(R.drawable.p8);
                else if (nums[i][j] == 10)
                    pics[m].setImageResource(R.drawable.p9);
                else if (nums[i][j] == 11)
                    pics[m].setImageResource(R.drawable.p10);
                else if (nums[i][j] == 12)
                    pics[m].setImageResource(R.drawable.p11);
                else
                    pics[m].setImageResource(R.drawable.blank);
                m++;
            }
        }
    }

    public void clear() {
        place = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                nums[i][j] = 0;
            }
        }
    }

    public void unsort() {
        for (int i = 0; i < 60; i++) {
            int c = (int) (Math.random() * col);
            int b = (int) (Math.random() * col);
            int temp = a[c];
            a[c] = a[b];
            a[b] = temp;
        }
    }

    public void addNewRow() {
        place++;
        if (place < row) {
            for (int i = 0; i < col; i++) {
                nums[place][i] = a[i];
            }
        }
    }




}
