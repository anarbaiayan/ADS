package org.example;
import java.util.HashMap;
import java.util.Map;
public class Vertex<V> {
    private V data;
    private Map<Vertex<V> , Double> map = new HashMap<>();
    public Vertex(V data){
        this.data = data;
    }

    public Vertex(){
        this(null);
    }

    public V getData(){
        return data;
    }
    public void setData(V data){
        this.data = data;
    }

    public void addAdjacentVertex(Vertex<V> dest, Double weight){
        map.put(dest, weight);
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return map;
    }

    public Iterable<V> getAdjacentVerticesData() {
        return map.keySet().stream().map(Vertex::getData)::iterator;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> otherVertex = (Vertex<?>) o;
        return data.equals(otherVertex.data);
    }
}
