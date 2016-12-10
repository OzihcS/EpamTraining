package ua.nure.piontkovskyi.Practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MyListImpl implements MyList, ListIterable {

    private Object[] arr;
    private int size;

    MyListImpl() {
        arr = new Object[5];
    }

    @Override
    public void add(Object e) {
        if (arr.length > size) {
            arr[size] = e;
        } else {
            Object[] tmpArray = new Object[(arr.length * 3) / 2 + 1];
            System.arraycopy(arr, 0, tmpArray, 0, arr.length);
            arr = tmpArray;
            arr[size] = e;
        }
        size++;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            return false;
        } else {
            Object[] tmp = new Object[arr.length - 1];
            if (o == null) {
                for (int i = 0; i < size; i++) {
                    if (arr[i] == null) {
                        System.arraycopy(arr, 0, tmp, 0, i);
                        System.arraycopy(arr, i + 1, tmp, i, tmp.length - i);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (arr[i] != null && arr[i].equals(o)) {
                        System.arraycopy(arr, 0, tmp, 0, i);
                        System.arraycopy(arr, i + 1, tmp, i, tmp.length - i);
                        break;
                    }
                }
            }
            arr = tmp;
            size--;
            return true;
        }
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (o == null) {
                if (arr[i] == null) {
                    flag = true;
                    break;
                }
            } else {
                if (arr[i] != null && arr[i].equals(o)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    @Override
    public boolean containsAll(MyList c) {
        for (int i = 0; i < size; i++) {
            if (!contains(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder result = new StringBuilder();
            result.append("{");
            for (int i = 0; i < size; i++) {
                if (arr[i] != null) {
                    result.append("[").append(arr[i].toString()).append("],");
                } else {
                    result.append("[null],");
                }
            }
            result.delete(result.length() - 1, result.length());
            result.append("}");
            return result.toString();
        }
    }


    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }


    private class IteratorImpl implements Iterator<Object> {

        private int currentIndex;
        private boolean isRemove;
        private boolean isNext;

        @Override
        public boolean hasNext() {
            if (isNext) {
                currentIndex++;
            }
            if (currentIndex < size) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (currentIndex == size) {
                throw new NoSuchElementException();
            }
            isNext = true;
            isRemove = false;
            return arr[currentIndex];
        }

        @Override
        public void remove() {
            if (!isNext || isRemove) {
                throw new IllegalStateException();
            } else {
                isRemove = true;
                isNext = false;
                MyListImpl.this.remove(arr[currentIndex]);
                size--;
            }
        }
    }


    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }


    private class ListIteratorImpl extends IteratorImpl implements ListIterator {

        private boolean isPrevious;

        @Override
        public boolean hasPrevious() {
            if (super.currentIndex <= size && super.currentIndex > 0) {
                super.currentIndex--;
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object previous() {
            if (super.currentIndex < 0) {
                throw new NoSuchElementException();
            } else {
                isPrevious = true;
                super.isNext = true;
                super.isRemove = false;
                return arr[super.currentIndex];
            }
        }

        @Override
        public void set(Object e) {
            arr[super.currentIndex] = e;
        }

        public void remove() {
            if (!isPrevious) {
                throw new IllegalStateException();
            } else {
                super.remove();
                super.currentIndex--;
                isPrevious = false;
            }

        }
    }
}
