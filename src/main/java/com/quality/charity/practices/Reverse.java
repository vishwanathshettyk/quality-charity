package com.quality.charity.practices;

import java.util.LinkedList;

public class Reverse {

    public static void reverseLinkedList(LinkedList<Integer> ll )
    {
        System.out.println(ll);

        LinkedList<Integer> ll1 = new LinkedList<>();
        int size = ll.size()-1;
        for(int i = size; i >=0 ; i--)
        {
            ll1.add(ll.get(i));
        }

        //ll.descendingIterator().forEachRemaining(ll1::add);

        System.out.println(ll1);
    }
}
