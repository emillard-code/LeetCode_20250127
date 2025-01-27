package com.project;

import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class LeetCodeSolutionTest {

    @Test
    public void courseScheduleIVTest() {

        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][]{{1,0}};
        int[][] queries1 = new int[][]{{0,1},{1,0}};
        ArrayList<Boolean> answer1 = new ArrayList<>();
        answer1.add(false);
        answer1.add(true);
        assertTrue(LeetCodeSolution.checkIfPrerequisite(numCourses1, prerequisites1, queries1).equals(answer1));

        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][]{};
        int[][] queries2 = new int[][]{{1,0},{0,1}};
        ArrayList<Boolean> answer2 = new ArrayList<>();
        answer2.add(false);
        answer2.add(false);
        assertTrue(LeetCodeSolution.checkIfPrerequisite(numCourses2, prerequisites2, queries2).equals(answer2));

        int numCourses3 = 3;
        int[][] prerequisites3 = new int[][]{{1,2},{1,0},{2,0}};
        int[][] queries3 = new int[][]{{1,0},{1,2}};
        ArrayList<Boolean> answer3 = new ArrayList<>();
        answer3.add(true);
        answer3.add(true);
        assertTrue(LeetCodeSolution.checkIfPrerequisite(numCourses3, prerequisites3, queries3).equals(answer3));

    }

}
