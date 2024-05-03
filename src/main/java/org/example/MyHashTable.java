package org.example;

public class MyHashTable<K, V> {
    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return key + " : " + value;
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    private Double loadFactor = 0.75;

    public MyHashTable(){
        this.chainArray = new HashNode[M];
        size = 0;
    }
    public MyHashTable(int initialCapacity){
        this.M = (int)(initialCapacity*loadFactor);
        this.chainArray = new HashNode[M];
    }
    public int getM(){
        return M;
    }
    public int countElements(int index){
        int count = 0;
        HashNode<K, V> temp = chainArray[index];
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public void increaseSize(){
        M *= 2;
        HashNode<K, V>[] temp = chainArray;
        chainArray = new HashNode[M];
        for(int i = 0 ; i < temp.length ; i++) {
            if(temp[i] != null) {
                HashNode<K , V> node = temp[i];
                while(node != null) {
                    put(node.key , node.value);
                    node = node.next;
                }
            }
        }
    }
    public void put(K key , V value) {
        if((double) size / M > loadFactor) {
            increaseSize();
        }
        int index = hash(key);
        HashNode<K , V> newNode = new HashNode<>(key , value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public V get(K key){
        int index = hash(key);
        HashNode<K , V> node = chainArray[index];
        while (node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> temp = chainArray[index];
        HashNode<K, V> prev = null;
        while(temp != null) {
            if(temp.key.equals(key)) {
                if(prev == null) {
                    chainArray[index] = temp.next;
                }
                else {
                    prev.next = temp.next;
                }
                size--;
                return temp.value;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }
    public boolean containsKey(K key){
        int index = hash(key);
        HashNode<K , V> node = chainArray[index];
        while (node != null){
            if(node.key.equals(key)){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    public K getKey(V value){
        for(int i = 0 ; i < M ; i++) {
            HashNode<K, V> node = chainArray[i];
            while(node != null) {
                if(node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    public int size(){
        return size;
    }
}
