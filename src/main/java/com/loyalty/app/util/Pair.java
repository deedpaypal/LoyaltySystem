package com.loyalty.app.util;

public class Pair<A, B> {
    private A firstElement;
    private B secondElement;

    public Pair(A first, B second) {
        super();
        this.firstElement = first;
        this.secondElement = second;
    }

    public int hashCode() {
        int hashFirst = firstElement != null ? firstElement.hashCode() : 0;
        int hashSecond = secondElement != null ? secondElement.hashCode() : 0;

        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return
                    ((  this.firstElement == otherPair.firstElement ||
                            ( this.firstElement != null && otherPair.firstElement != null &&
                                    this.firstElement.equals(otherPair.firstElement))) &&
                            (  this.secondElement == otherPair.secondElement ||
                                    ( this.secondElement != null && otherPair.secondElement != null &&
                                            this.secondElement.equals(otherPair.secondElement))) );
        }

        return false;
    }

    public String toString()
    {
        return "(" + firstElement + ", " + secondElement + ")";
    }

    public A getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(A firstElement) {
        this.firstElement = firstElement;
    }

    public B getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(B secondElement) {
        this.secondElement = secondElement;
    }
}