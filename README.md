# Tree-Hierarchy
A scala project with basic binary tree hierarchy, including binary trees, binary search trees and red-black trees.
![Hierarchy Diagram](https://raw.github.com/olkinn/Tree-Hierarchy/screenshots/Pictures/pic1.png)

I needed to implement something like interfaces in Java, with the necessary methods for implementation. For example, IBinaryTree stands for "Binary Tree interface" and contains the add method and 3 different traversals (inOrder, preOrder, postOrder).
IBinarySearchTree contains the search method, whereas IRedBlackTree has a complex add mechanism with adding an element like in a ordinary BST, but then balancing the tree and recoloring the nodes.

Regarding red-black trees, big thanks to Chris Okasaki's Haskell implementation of Red-Black Trees (Functional Pearls).
Here's the link to it: http://www.ccs.neu.edu/course/cs3500wc/jfp99redblack.pdf 
