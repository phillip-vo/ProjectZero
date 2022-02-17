package com.revature.util;

public class ArrayList<T> {
    private int count=0;
    private Object objArray[];
    private T t;

    public ArrayList()
    {
        objArray = new Object[5];
    }

    /*
    Add Method:
    Insert new element t into the end of object array.
     */
    public void add(T t)
    {

        // Checks to see if current amount is not greater, if so create new array and resize the capacity by 50%
        if (this.count + 1 > objArray.length) {
            Object[] newObjArray = new Object[this.count * 2];

            // Copy elements of current array to new array
            for (int i = 0; i < this.count; i++) {
                objArray[i] = newObjArray[i];
            }

            // Current array points to new array reference
            objArray = newObjArray;
        }

        // Add new object to array
        objArray[this.count] = t;

        // Increment count to reflect the amount of objects in object array
        this.count++;
    }

    /*
    Get Method:
    Return element in the object array at the specified index
     */
    public Object get(int index)
    {
        if(objArray[index] != null)
        {
            return objArray[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Element does not exist at index:" + index);
        }
    }

    /*
    Set Method:
    Sets the element value at given at index to the new value given by element t.
     */
    public void set(int index, T t) {

        if (index < this.size()) {
            objArray[index] = t;
        } else {
            throw new IndexOutOfBoundsException("Cannot set element at index: " + index);
        }

    }

    /*
    indexOf Method:
    Returns the index of the first occurrence of element t in the array.
    If element t is not present in array, return -1.
     */
    public int indexOf(T t) {
        for (int i = 0; i < this.count; i++) {
            if (objArray[i] == t) {
                return i;
            }
        }

        return -1;
    }

    /*
    Size Method:
    Return the size of object array
     */
    public int size() {
        return this.count;
    }

    /*
    Contains Method:
    Checks if the array contains the given element t.
    Returns true if the element is present, otherwise false.
     */
    public boolean contains(T t) {
        for(int i = 0; i < this.count; i++) {
            if (t.equals(objArray[i])) {
                return true;
            }
        }
        return false;
    }

    /*
    toString Method:
    Returns a string representation of the contents of the object array.
     */
    @Override
    public String toString()
    {
        String string = "";

        for (int i = 0; i < this.count; i++) {
            string += objArray[i] + ", ";
        }

        if (string != "") {
            string = "[" + string.substring(0, string.length() - 2) + "]";
        }
        else {
            string = "[]";
        }

        return string;
    }

}
