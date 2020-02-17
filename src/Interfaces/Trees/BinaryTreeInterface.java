package Interfaces.Trees;

public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T>
{
    public void setTree(T rootData);

    public void SetTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}
