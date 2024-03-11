import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends  Comparable<K>,V> implements Map61B<K,V>{
    private Node root;
    private class Node{
        private K k;
        private V v;
        private Node left;
        private Node right;
        private int size;
        private Node(K k,V v,int size){
            this.k=k;
            this.v=v;
            this.size=size;
        }


    }
    public BSTMap(){
        this.clear();
    }
    private V getHelper(K k,Node p){
        if (p==null){
            throw new IllegalArgumentException();

        }
        if (p.k.compareTo(k)>0){
            return getHelper(k,p.left);
        }
        else if (p.k.compareTo(k)<0){
            return getHelper(k,p.right);
        }
        else  {
            return p.v;
        }
    }
    private Node putHelper(K k,V v,Node p){
        if (p==null){
            return new Node(k,v,1);
        }
        if (p.k.compareTo(k)>0) {
            p.left=putHelper(k,v,p.left);
        } else if (p.k.compareTo(k)<0) {
            p.right=putHelper(k,v,p.right);
        } else if (p.k.compareTo(k)==0) {
            p.v=v;
        }
        p.size=1+size(p.left)+size(p.right);
        return p;
    }

    @Override
    public void put(K key, V value) {
        root=putHelper(key,value,root);
    }

    @Override
    public V get(K key) {
        return getHelper(key,root);
    }

    @Override
    public boolean containsKey(K key) {
        if (key==null){
            throw new IllegalArgumentException();
        }
        return get(key)!=null;
    }

    @Override
    public int size() {
        return root.size;
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
    @Override
    public void clear() {
        root=null;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }


}
