package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (this == n) return true;
        if (n == null) return false;
        if (this.getClass() != n.getClass()) return false;

        Solution s = (Solution) n;

        return (first == s.first || (first != null && first.equals(s.first))) &&
            last == s.last || (last != null && last.equals(s.last));

    }

    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) / 2 + (last == null ? 0 : last.hashCode()) / 2;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
