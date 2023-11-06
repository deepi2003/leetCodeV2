package org.example.atlassianExcercise;

/*

Problem Description
Imagine we have a system that stores files, and these files can be grouped into collections.
We are interested in knowing where our resources are being taken up.

For this system we would like to generate a report that lists:

The total size of all files stored; and

The top N collections (by file size) where N can be a user-defined value

An example input into your report generator might look like:


file1.txt (size: 100)
file2.txt (size: 200) in collection "collection1"
file3.txt (size: 200) in collection "collection1"
file4.txt (size: 300) in collection "collection2"
file5.txt (size: 10)

max size: fit in

file1.txt (size: 100)
file2.txt (size: 200) in collection "collection1"
file3.txt (size: 200) in collection "collection1"
file3.txt (size: 200) in collection "collection1"
file4.txt (size: 300) in collection "collection2"
file5.txt (size: 10)


Map<String, List<String>>

Map<String, int size>

PQ<Collection>


 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileProcessor {
    private final int topCollections;

    public FileProcessor(int topCollections){

        this.topCollections = topCollections;
    }

    Map<String, Integer> collections = new HashMap<>();
    int totalSize;

    public void add(List<Item> files) {
        for(Item file: files) {
            totalSize+= file.size;
            if(file.collectionName !=null){
                int currentSize = collections.getOrDefault(file.collectionName, 0);
                currentSize += file.size;
                collections.put(file.collectionName,currentSize);
            }
        }
    }

    public int getTotalSize() {
        return totalSize;
    }

    public List<String> topNCollection() {
        List<String> result = collections.entrySet().stream().sorted((o1, o2) -> o2.getValue()-o1.getValue())
                .map(Map.Entry::getKey).collect(Collectors.toList());
        if(result.size() < topCollections) {
            return  result;
        }
        return result.subList(0, topCollections);
    }

    static class Item {
        String collectionName;
        int size;
        String fileName;

        public Item(String fileName, int size) {
                this.fileName = fileName;
                this.size = size;
        }

        public Item(String fileName, int size, String collectionName) {
            this(fileName, size);
            this.collectionName = collectionName;
        }
    }


}