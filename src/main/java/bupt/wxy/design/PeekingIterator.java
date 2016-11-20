package bupt.wxy.design;

import java.util.*;

/**
 * Created by xiyuanbupt on 11/20/16.
 Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

 Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

 Call next() gets you 1, the first element in the list.

 Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

 You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 */

class PeekingIterator implements Iterator<Integer> {

    List<Integer> list;
    int curr;
    int len;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        len = 0;
        list = new ArrayList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
            len ++;
        }
        curr = 0;
        System.out.println(Arrays.toString(list.toArray()));
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(curr);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.get(curr++);
    }

    @Override
    public boolean hasNext() {
        return curr<len;
    }
}
