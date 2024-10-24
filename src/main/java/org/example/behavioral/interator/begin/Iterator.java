package org.example.behavioral.interator.begin;

//Iterator interface allowing to iterate over 
//values of an aggregate
public interface Iterator<T> {

    boolean hasNext();
    T next();
}