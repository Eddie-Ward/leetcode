package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Topological Sort solution
 * 
 * Uses a directed acyclic graph to represent the dependencies of each item /
 * group
 * Must consider item dependencies across groups
 */

class Solution {

    Map<Integer, List<Integer>> groupGraph;
    Map<Integer, List<Integer>> itemGraph;

    int[] groupsInDegree;
    int[] itemsInDegree;

    /**
     * fromGroup: {toGroups...}
     * 
     * Creates map where a group node will point to other nodes that it is meant to
     * come before based on beforeItems
     */
    private void buildGraphOfGroups(int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < group.length; ++i) {
            int toGroup = group[i];
            List<Integer> fromItems = beforeItems.get(i);

            // Gets all items that are meant to come before this current item.
            // Looks at their groups and determines if a group is meant to come before
            // another group based on this dependency.
            for (int fromItem : fromItems) {
                int fromGroup = group[fromItem];
                if (fromGroup != toGroup) {
                    groupGraph.computeIfAbsent(fromGroup, x -> new ArrayList<Integer>()).add(toGroup);
                    groupsInDegree[toGroup]++;
                }
            }
        }
    }

    /**
     * fromItem: {toItems...}
     *
     * Similar to buildGraphOfGroups function except for itemGraph
     */

    private void buildGraphOfItems(List<List<Integer>> beforeItems, int numItems) {
        for (int i = 0; i < numItems; ++i) {
            List<Integer> items = beforeItems.get(i);

            for (int item : items) {
                itemGraph.computeIfAbsent(item, x -> new ArrayList<Integer>()).add(i);
                itemsInDegree[i]++;
            }

        }
    }

    private List<Integer> topologicalSortUtil(Map<Integer, List<Integer>> graph, int[] inDegree, int numItems) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int key : graph.keySet()) {
            if (inDegree[key] == 0) {
                queue.add(key); // Adds nodes to queue that are do not have nodes coming before them
            }
        }

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            numItems--;
            list.add(curNode);
            for (int neighbor : graph.get(curNode)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return numItems == 0 ? list : new ArrayList<Integer>();

    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        groupGraph = new HashMap<>();
        itemGraph = new HashMap<>();

        // If item does not already belond to a group, form a new group for it
        for (int i = 0; i < group.length; ++i) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        for (int i = 0; i < m; ++i) {
            groupGraph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            itemGraph.put(i, new ArrayList<>());
        }

        groupsInDegree = new int[m];
        itemsInDegree = new int[n];

        buildGraphOfGroups(group, beforeItems);
        buildGraphOfItems(beforeItems, n);

        List<Integer> groupsList = topologicalSortUtil(groupGraph, groupsInDegree, m);
        List<Integer> itemsList = topologicalSortUtil(itemGraph, itemsInDegree, n);

        if (groupsList.size() == 0 || itemsList.size() == 0) {
            return new int[0]; // If there are any cycles, just return an empty array (no solution)
        }

        Map<Integer, List<Integer>> groupsToItems = new HashMap<>();

        // Will get the items in sorted order of dependencies
        // The map of group-to-items will have the items in sorted order
        for (int item : itemsList) {
            groupsToItems.computeIfAbsent(group[item], x -> new ArrayList<>()).add(item);
        }

        int[] ans = new int[n];
        int index = 0;
        // Will get the groups in sorted order of dependencies
        // Since the map of group-to-items is sorted already, all items will be added to
        // the flat array ans in sorted order
        for (int curGroup : groupsList) {
            List<Integer> items = groupsToItems.getOrDefault(curGroup, new ArrayList<>());
            for (int item : items) {
                ans[index++] = item;
            }
        }

        return ans;

    }
}
