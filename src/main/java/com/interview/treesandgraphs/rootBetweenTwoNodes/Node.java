package com.interview.treesandgraphs.rootBetweenTwoNodes;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Integer data;

    public List<Node> links;

    public Node prev;

    public Node(Integer value) {
        this.data = value;
    }

    public void addLink(Node newLink) {
        if (links == null) {
            links = new ArrayList<>();
        }
        this.links.add(newLink);
    }
}
