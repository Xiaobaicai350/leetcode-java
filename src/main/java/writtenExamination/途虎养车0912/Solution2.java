package writtenExamination.途虎养车0912;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.*;

//   6,[8, 3, 7, 5, 6, 2],[[1, 0], [2, 1], [3, 1], [4, 2]],3

import java.util.*;

public class Solution2 {
    // 计算在给定的任务数量k内，可以获得的最多点数
    public int maxPoints(int n, int[] points, int[][] dependencies, int k) {
        // 构建邻接表，用于表示任务之间的依赖关系
        List<List<Integer>> graph = new ArrayList<>();
        // 构建入度数组，用于记录每个任务有多少个依赖
        int[] inDegree = new int[n];
        // 初始化邻接表
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 填充邻接表和入度数组
        for (int[] dependency : dependencies) {
            // dependency[1]依赖dependency[0]，因此dependency[0]的入度增加
            graph.get(dependency[1]).add(dependency[0]);
            inDegree[dependency[0]]++;
        }

        // 使用优先队列来选择点数最大的任务，队列中存储数组，数组第一个元素是任务索引，第二个元素是任务点数
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // 将所有入度为0的任务加入优先队列
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                pq.offer(new int[]{i, points[i]});
            }
        }

        int sum = 0; // 记录总点数
        // 当优先队列不为空且还可以选择任务时
        while (!pq.isEmpty() && k > 0) {
            // 从优先队列中取出点数最大的任务
            int[] cur = pq.poll();
            // 将当前任务的点数加到总点数上
            sum += cur[1];
            // 减少可以选择的任务数量
            k--;
            // 遍历当前任务的所有后继任务
            for (int next : graph.get(cur[0])) {
                // 后继任务的入度减1
                inDegree[next]--;
                // 如果后继任务的入度变为0，说明它现在可以执行了，将其加入优先队列
                if (inDegree[next] == 0) {
                    pq.offer(new int[]{next, points[next]});
                }
            }
        }

        // 返回计算出的最大点数
        return sum;
    }

    public static void main(String[] args) {
        // 创建Solution的实例
        Solution2 solution2 = new Solution2();

        // 测试用例
        int n = 6;
        int[] points = {8, 3, 7, 5, 6, 2};
        int[][] dependencies = {{1, 0}, {2, 1}, {3, 1}, {4, 2}};
        int k = 3;

        // 调用maxPoints方法
        int maxPoints = solution2.maxPoints(n, points, dependencies, k);

        // 打印结果
        System.out.println("最大点数: " + maxPoints); // 应该输出18
    }
}

// 例子解释：
// 给定的任务和依赖关系如下：
// 任务0有8点，没有依赖
// 任务1有3点，依赖于任务0
// 任务2有7点，依赖于任务1
// 任务3有5点，依赖于任务1
// 任务4有6点，依赖于任务2
// 任务5有2点，没有依赖
// 我们可以选择最多3个任务。
// 选择过程如下：
// 1. 选择任务0，得到8点，任务1的入度变为0，可以执行
// 2. 选择任务1，得到3点，任务2和任务3的入度变为0，可以执行
// 3. 选择任务2，得到7点，任务4的入度变为0，可以执行
// 因此，总点数为8 + 3 + 7 = 18


