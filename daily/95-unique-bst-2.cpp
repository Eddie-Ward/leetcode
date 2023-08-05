#include <vector>

using std::vector;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

/*
    Divide and Conquer Recursive Solution

    Using a helper function with int left and right parameters
    that denote all possible trees from left to right values.

    Target = generateTrees(1, n)
*/

class Solution {
   public:
    vector<TreeNode *> generateTrees(int n) {
        return generateTrees(1, n);
    }

    vector<TreeNode *> generateTrees(int left, int right) {
        // Base cases
        if (left > right) {
            return {nullptr};  // Must return a nullptr so that the left or right node is correctly set to nullptr
        }
        if (left == right) {
            return {new TreeNode(left)};  // Just return one node
        }

        vector<TreeNode *> trees;

        for (int center = left; center <= right; ++center) {
                        // Divide and conquer part, generate all possible left and right subtrees
            auto leftSubTrees = generateTrees(left, center - 1);
            auto rightSubTrees = generateTrees(center + 1, right);

            // Use a double for loop to generate all possible root nodes with left and right trees
            for (auto &left : leftSubTrees) {
                for (auto &right : rightSubTrees) {
                    TreeNode *rootNode = new TreeNode(center, left, right);
                    trees.push_back(rootNode);
                }
            }
        }

        return trees;
    }
};