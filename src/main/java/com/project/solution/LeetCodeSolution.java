package com.project.solution;

import java.util.*;

public class LeetCodeSolution {

    public static void main(String[] args) {

        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][]{{1,0}};
        int[][] queries1 = new int[][]{{0,1},{1,0}};
        System.out.println(checkIfPrerequisite(numCourses1, prerequisites1, queries1));

        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][]{};
        int[][] queries2 = new int[][]{{1,0},{0,1}};
        System.out.println(checkIfPrerequisite(numCourses2, prerequisites2, queries2));

        int numCourses3 = 3;
        int[][] prerequisites3 = new int[][]{{1,2},{1,0},{2,0}};
        int[][] queries3 = new int[][]{{1,0},{1,2}};
        System.out.println(checkIfPrerequisite(numCourses3, prerequisites3, queries3));

    }

    // Iterate over each node and perform BFS starting from it.
    // Mark the starting node as a prerequisite to all the nodes in the BFS
    // traversal.
    private static void preprocess(int numCourses, int[][] prerequisites,
                                   Map<Integer, List<Integer>> adjList, boolean[][] isPrerequisite) {

        for (int i = 0; i < numCourses; i++) {

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);

            while (!q.isEmpty()) {

                int node = q.poll();

                for (int adj : adjList.getOrDefault(node, new ArrayList<>())) {

                    // If we have marked i as a prerequisite of adj it implies we
                    // have visited it. This is equivalent to using a visited
                    // array.
                    if (!isPrerequisite[i][adj]) {
                        isPrerequisite[i][adj] = true;
                        q.offer(adj);
                    }

                }

            }

        }

    }

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites,
                                                    int[][] queries) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        preprocess(numCourses, prerequisites, adjList, isPrerequisite);

        List<Boolean> answer = new ArrayList<>();

        for (int[] query : queries) {
            answer.add(isPrerequisite[query[0]][query[1]]);
        }

        return answer;

    }

}
