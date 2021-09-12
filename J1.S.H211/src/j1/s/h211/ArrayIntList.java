/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h211;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author giaki
 */
public class ArrayIntList {

    private int[] elementData;
    private int size;

    public ArrayIntList() {
    }

    public ArrayIntList(int[] elementData) {
        this.elementData = elementData;
    }
    
    
    public ArrayIntList(int[] elementData, int size) {
        this.elementData = elementData;
        this.size = size;
    }

    public int[] getElementData() {
        return elementData;
    }

    public void setElementData(int[] elementData) {
        this.elementData = elementData;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void fromCounts() throws Exception{
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size-1; i=i+2) {
            int d = 0;
            if(elementData[i]<0){
                throw new Exception("Quantity less than 0");
            }
            while(d<elementData[i]){
                list.add(elementData[i+1]);
                d++;
            }
        }
        elementData = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
