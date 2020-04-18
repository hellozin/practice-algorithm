package me.hellozin.ps.programmers.hash;

/*
 * 제목 : 전화번호 목록
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42577
 * */

public class PhoneBook {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean actual = solution(phone_book);
        System.out.println("result : " + actual);
    }

    public static boolean solution(String[] phone_book) {
        int length = phone_book.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                switch (Integer.compare(phone_book[i].length(), phone_book[j].length())) {
                    case  1: if (phone_book[i].startsWith(phone_book[j])) return false; break;
                    case -1: if (phone_book[j].startsWith(phone_book[i])) return false; break;
                    case  0: if (phone_book[i].equals(phone_book[j])) return false; break;
                }
            }
        }
        return true;
    }

}
