package com.project.attempt;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][]{{1,0}};
        int[][] queries1 = new int[][]{{0,1},{1,0}};
        System.out.println(Arrays.toString(courseScheduleIV(numCourses1, prerequisites1, queries1)));

        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][]{};
        int[][] queries2 = new int[][]{{1,0},{0,1}};
        System.out.println(Arrays.toString(courseScheduleIV(numCourses2, prerequisites2, queries2)));

        int numCourses3 = 3;
        int[][] prerequisites3 = new int[][]{{1,2},{1,0},{2,0}};
        int[][] queries3 = new int[][]{{1,0},{1,2}};
        System.out.println(Arrays.toString(courseScheduleIV(numCourses3, prerequisites3, queries3)));

    }

    public static boolean[] courseScheduleIV(int numCourses, int[][] prerequisites, int[][] queries) {

        HashSet<Integer>[] prerequisiteCourses = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            prerequisiteCourses[i] = new HashSet<>();
        }

        boolean[] answer = new boolean[queries.length];

        for (int i = 0; i < prerequisites.length; i++) {
            prerequisiteCourses[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        while (true) {

            boolean escape = false;

            for (int i = 0; i < prerequisiteCourses.length; i++) {

                if (!prerequisiteCourses[i].isEmpty()) {

                    for (int prerequisites1 : prerequisiteCourses[i]) {

                        int originalSize = prerequisiteCourses[i].size();

                        for (int prerequisites2 : prerequisiteCourses[prerequisites1]) {
                            prerequisiteCourses[i].add(prerequisites2);
                        }

                        if (originalSize == prerequisiteCourses[i].size()) { escape = true; }

                    }

                }

            }

            if (prerequisites.length == 0) { break; }
            if (escape) { break; }

        }

        for (int i = 0; i < queries.length; i++) {

            if (prerequisiteCourses[queries[i][1]].contains(queries[i][0])) {
                answer[i] = true;
            }

        }

        return answer;

    }

}
