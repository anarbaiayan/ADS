package org.example;

class MyGraph<V> extends WeightedGraph<V> {
    public MyGraph(boolean directed) {
        super(directed);
    }

    public void addEdge(V source, V dest) {
        super.addEdge(source, dest, 1.0);
    }

}