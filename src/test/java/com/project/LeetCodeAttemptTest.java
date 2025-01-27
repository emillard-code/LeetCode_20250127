package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void courseScheduleIVTest() {

        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][]{{1,0}};
        int[][] queries1 = new int[][]{{0,1},{1,0}};
        boolean[] answer1 = new boolean[]{false,true};
        assertArrayEquals(answer1, LeetCodeAttempt.courseScheduleIV(numCourses1, prerequisites1, queries1));

        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][]{};
        int[][] queries2 = new int[][]{{1,0},{0,1}};
        boolean[] answer2 = new boolean[]{false,false};
        assertArrayEquals(answer2, LeetCodeAttempt.courseScheduleIV(numCourses2, prerequisites2, queries2));

        int numCourses3 = 3;
        int[][] prerequisites3 = new int[][]{{1,2},{1,0},{2,0}};
        int[][] queries3 = new int[][]{{1,0},{1,2}};
        boolean[] answer3 = new boolean[]{true,true};
        assertArrayEquals(answer3, LeetCodeAttempt.courseScheduleIV(numCourses3, prerequisites3, queries3));

    }

}
