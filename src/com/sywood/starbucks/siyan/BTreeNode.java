package com.sywood.starbucks.siyan;

/**
 * Created by siyan on 2016-06-22.
 */
public class BTreeNode {

    public final int nodeNum;

    public BTreeNode leftChild;
    public BTreeNode rightChild;

    public BTreeNode(int nodeNum) {
        this.nodeNum = nodeNum;
    }
}
