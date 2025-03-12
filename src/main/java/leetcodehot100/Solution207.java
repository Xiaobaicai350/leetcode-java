package leetcodehot100;

import java.util.*;

/*
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。



示例 1：

输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
示例 2：

输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
示例3:
5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {3, 4}, {1, 4}}
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 存储每个节点的出度
        int[] outDegree = new int[numCourses];//要完成i这门课程前置条件有outDegree[i]门
        // 存储反向图的邻接表
        //reverseAdjList[0]中存储的是依赖0这门课程的课程
        List<List<Integer>> reverseAdjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            reverseAdjList.add(new ArrayList<>());
        }

        // 计算每个节点的出度和构建反向邻接表
        for (int[] prerequisite : prerequisites) {
            int ai = prerequisite[0];
            int bi = prerequisite[1];
            // 这里 bi 依赖于 ai，所以 ai 的出度增加
            outDegree[bi]++;
            // 反向构建邻接表，从 ai 指向 bi
            reverseAdjList.get(ai).add(bi);
        }

        /*
        outDegree: [0, 1, 1, 1, 2]
        reverseAdjList: [[1, 2], [3, 4], [], [4], []]
         */
        System.out.println("outDegree: " + Arrays.toString(outDegree));
        System.out.println("reverseAdjList: " + reverseAdjList);

        // 存储出度为 0 的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }

        //queue: [0]
        // 记录已经学习的课程数量
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            // 遍历当前课程的所有前置课程
            for (int prevCourse : reverseAdjList.get(course)) {
                // 前置课程的出度减 1
                outDegree[prevCourse]--;
                if (outDegree[prevCourse] == 0) {
                    queue.offer(prevCourse);
                }
            }
        }

        // 如果已经学习的课程数量等于总课程数量，则可以完成所有课程的学习
        return count == numCourses;
    }

    public static void main(String[] args) {
        new Solution207().canFinish(5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {3, 4}, {1, 4}});
    }
}