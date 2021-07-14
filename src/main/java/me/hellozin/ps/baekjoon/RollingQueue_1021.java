package me.hellozin.ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class RollingQueue_1021 {

    public static void main(String[] args) throws IOException {
        // ========== get input data ==========
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int queueSize = Integer.parseInt(firstLine[0]);
        int targetCount = Integer.parseInt(firstLine[1]);

        String[] secondLine = reader.readLine().split(" ");
        int[] targets = new int[targetCount];
        for (int i = 0; i < targetCount; i++) {
            targets[i] = Integer.parseInt(secondLine[i]);
        }
        // ========== get input data ==========

        // divide queue
        Deque<Integer> leftQueue = new LinkedList<>();
        Deque<Integer> rightQueue = new LinkedList<>();
        for (int i = 1; i < queueSize/2 + 1; i++) {
            leftQueue.add(i);
        }
        for (int i = queueSize/2 + 1; i <= queueSize; i++) {
            rightQueue.add(i);
        }

        int rollingOperationCount = 0;

        // for each target
        for (int target : targets) {

            // when left.size == 0 && right.size == 1
            if (leftQueue.isEmpty()) {
                leftQueue.offerLast(rightQueue.pollFirst());
            }

            // rolling
            if (leftQueue.peekFirst() != target) {

                boolean leftQueueContainsBorder = leftQueue.peekFirst() > leftQueue.peekLast();
                boolean targetLocatedAtLeftQueue = true;

                // if left.size < right.size, left rolling is better even target located at right.
                if (rightQueue.peekFirst() == target) {
                    targetLocatedAtLeftQueue = true;
                } else if (leftQueueContainsBorder) {
                    // example) left: [12, 15, 2, 3] right: [4, 5, 6, 7]
                    targetLocatedAtLeftQueue = (leftQueue.peekFirst() < target) || (target <= leftQueue.peekLast());
                } else {
                    targetLocatedAtLeftQueue = (leftQueue.peekFirst() < target) && (target <= leftQueue.peekLast());
                }

                // left rolling
                if (targetLocatedAtLeftQueue) {
                    while (leftQueue.peekFirst() != target) {
                        rollingOperationCount++;
                        rightQueue.offerLast(leftQueue.pollFirst());
                        leftQueue.offerLast(rightQueue.pollFirst());
                    }
                // right rolling
                } else {
                    while (leftQueue.peekFirst() != target) {
                        rollingOperationCount++;
                        leftQueue.offerFirst(rightQueue.pollLast());
                        rightQueue.offerFirst(leftQueue.pollLast());
                    }
                }
            }

            // poll target
            leftQueue.pollFirst();

            // keep valance between left and right
            if (leftQueue.size() < rightQueue.size() - 1) {
                leftQueue.offerLast(rightQueue.pollFirst());
            }
        }
        System.out.println(rollingOperationCount);
    }

}
