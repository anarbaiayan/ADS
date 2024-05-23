package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<V> {
    private boolean directed;
    private Map<V, Vertex<V>> map = new HashMap<>();

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public WeightedGraph() {
        this(false);
    }

    public void addVertex(V data) {
        map.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight){
        if(map.containsKey(source) == false){
            addVertex(source);
        }

        if(map.containsKey(dest) == false){
            addVertex(dest);
        }

        map.get(source).addAdjacentVertex(map.get(dest), weight);

        if(directed == false){
            map.get(dest).addAdjacentVertex(map.get(source), weight);
        }
    }

    public boolean hasVertex(V data){
        return map.containsKey(data);
    }

    public Vertex<V> getVertex(V data){
        return map.get(data);
    }

    public Iterable<V> getVertices() {
        return map.keySet();
    }

    public boolean hasEdge(V source, V dest){
        if(hasVertex(source) == false){
            return false;
        }

        return map.get(source).getAdjacentVertices().containsKey(map.get(dest));
    }

    public Double getWeight(V source, V dest){
        if(hasEdge(source, dest) == false){
            return Double.POSITIVE_INFINITY;
        }

        return map.get(source).getAdjacentVertices().get(map.get(dest));
    }

    public Iterable<V> getAdjacentVertices(V data) {
        return map.keySet();
    }
}
