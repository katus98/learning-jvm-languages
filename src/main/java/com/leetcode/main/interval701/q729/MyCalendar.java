package com.leetcode.main.interval701.q729;

/**
 * 我的日程安排表 I
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-10
 */
public class MyCalendar {
    private final Task dummyHead;

    public MyCalendar() {
        this.dummyHead = new Task(-1, -1);
    }

    public boolean book(int start, int end) {
        Task before = dummyHead;
        while (before.next != null) {
            Task tmp = before.next;
            if (start < tmp.start) {
                if (end <= tmp.start && start >= before.end) {
                    before.next = new Task(start, end, tmp);
                    return true;
                } else return false;
            }
            before = before.next;
        }
        if (before.end <= start) {
            before.next = new Task(start, end);
            return true;
        }
        return false;
    }

    public static class Task {
        int start;
        int end;
        Task next;

        public Task(int start, int end) {
            this(start, end, null);
        }

        public Task(int start, int end, Task next) {
            this.start = start;
            this.end = end;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
    }
}
