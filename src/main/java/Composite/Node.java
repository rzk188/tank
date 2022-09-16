package Composite;

import java.util.ArrayList;
import java.util.List;

abstract class Node {
    abstract public void p();
}
class LeafNode extends Node{
    String content;
    public LeafNode(String content){
        this.content=content;
    }
    @Override
    public void p() {
        System.out.println(content);
    }
}
class BranchNode extends Node{
    List<Node> nodes=new ArrayList<>();
    String name;

    public BranchNode(String name){
        this.name=name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }
    public void add(Node n){
        nodes.add(n);
    }
}
