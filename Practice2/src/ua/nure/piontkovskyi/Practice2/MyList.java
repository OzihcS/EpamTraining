package ua.nure.piontkovskyi.Practice2;


interface MyList extends Iterable<Object> {

    void add(Object e);

    void clear();

    boolean remove(Object o);

    Object[] toArray();

    int size();

    boolean contains(Object o);

    boolean containsAll(MyList c);
}
