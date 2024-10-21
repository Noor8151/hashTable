package Hash;

import java.util.Arrays;

public class HashTable {
    private int size;
    private Entry[] table;

    private static class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        this.size = 10;
        this.table = new Entry[size];
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key, String value) {
        int index = hashFunction(key);
        while (table[index] != null) {
            index = (index + 1) % size;
        }
        table[index] = new Entry(key, value);
    }

    public String search(int key) {
        int index = hashFunction(key);
        while (table[index] != null) {
            if (table[index].key == key) {
                return table[index].value;
            }
            index = (index + 1) % size;
        }
        return null;
    }

    public void delete(int key) {
        int index = hashFunction(key);
        while (table[index] != null) {
            if (table[index].key == key) {
                table[index] = null;
                return;
            }
            index = (index + 1) % size;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : table) {
            if (entry != null) {
                sb.append("Key ").append(entry.key)
                  .append(" Value: ").append(entry.value).append("\n");
            } else {
                sb.append("null\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       HashTable obj = new HashTable();
        obj.insert(34, "Sahil");
        obj.insert(26, "Yash");
        obj.insert(78, "bob");
        obj.insert(45, "siddhant");
        obj.insert(67, "tom");

        System.out.println("Search for key 34 " + obj.search(34)); 
        System.out.println("Search for key 78 " + obj.search(78));
        System.out.println("Search for key 67 " + obj.search(67));
        obj.delete(30);
        System.out.println("Search for key 30 after deletion " + obj.search(30));

        System.out.println("Current table state");
        System.out.println(obj);
    }
}