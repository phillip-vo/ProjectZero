package com.revature.util;

public class ArrayList<T> {
    private int count=0;
    private Object objArray[];
    private T t;

    public ArrayList()
    {
        objArray = new Object[8];
    }

    /*
    Add Method:
    Insert new element t into the end of object array.
     */
    public void add(T t)
    {
        this.t = t;

        // Checks to see if current amount is not greater, if so create new array and resize the capacity by 50%
        if (this.count + 1 > this.objArray.length) {
            Object[] newObjArray = new Object[this.count * 2];

            // Copy elements of current array to new array
            for (int i = 0; i < this.count; i++) {
                this.objArray[i] = newObjArray[i];
            }

            // Current array points to new array reference
            this.objArray = newObjArray;
        }

        // Add new object to array
        this.objArray[this.count] = this.t;

        // Increment count to reflect the amount of objects in object array
        this.count++;
    }

    /*
    Get Method:
    Return element in the object array at the specified index
     */
    public Object get(int index)
    {
        if(this.objArray[index] != null)
        {
            return this.objArray[index];
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
            this.objArray[index] = t;
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
            if (this.objArray[i] == t) {
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
            if (t.equals(this.objArray[i])) {
                return true;
            }
        }
        return false;
    }


    public boolean compare(ArrayList objArrayTwo) {
        if (objArrayTwo.size() == this.count) {

            for (int i = 0; i < this.count; i++) {

                if (!objArrayTwo.get(i).equals(this.objArray[i])) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }


    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof GenericArrayList)) {
            return false;
        }

        // How to typecast o to class so that we can compare data member???

    }
    */


    /*
    toString Method:
    Returns a string representation of the contents of the object array.
     */
    @Override
    public String toString()
    {
        String string = "";

        for (int i = 0; i < this.count; i++) {
            string += this.objArray[i] + ", ";
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
