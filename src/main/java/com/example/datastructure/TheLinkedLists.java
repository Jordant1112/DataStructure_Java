package com.example.datastructure;

import java.util.LinkedList;
import java.util.ListIterator;

public class TheLinkedLists {
    public static void main(String[] args) {
        LinkedList<TheStacksandQueues.Person> linkedList = new LinkedList<>();
        linkedList.add(new TheStacksandQueues.Person("Aledx", 21));
        linkedList.add(new TheStacksandQueues.Person("Ben", 30));
        ListIterator<TheStacksandQueues.Person> personListIterator = linkedList.listIterator();
        while (personListIterator.hasNext()){
            System.out.println(personListIterator.next());
        }
        while (personListIterator.hasPrevious()){
            System.out.println(personListIterator.previous());
        }
    }
}
