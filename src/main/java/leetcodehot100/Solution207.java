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
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 存储有向图
        List<List<Integer>> edges = new ArrayList<>();
        // 存储每个节点的入度数量
        int[] indeg = new int[numCourses];
        // 初始化有向图
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        // 构建有向图并计算每个节点的入度
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        // 创建队列
        Queue<Integer> q = new LinkedList<>();
        // 第一次先把入度为0的节点入队
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        // 已经访问的节点数量
        int visited = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;
            // 遍历当前节点的所有邻接节点
            for (int v : edges.get(u)) {
                indeg[v]--;
                // 如果邻接节点的入度为0，则加入队列
                if (indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }
        // 如果访问的节点数量等于课程数量，说明可以完成所有课程
        return visited == numCourses;
    }
}