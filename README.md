# MyCollections
My implementation of the main data structures in Java (ArrayList, LinkedList, HashMap, HashSet and Queue)

![alt tag](https://github.com/SayidJarrah/MyCollections/blob/master/MyCollectionsUML.png)

What is it?
-----------
"MyCollections" is a my implementation of the most important data structures in Java : 
 - ArrayList is based on array structure.
 - LinkedList is based on doubly linked list which saved first and last nodes and links on next and previous nodes.
 - HashMap - structure "key-value", is based on array that contains list structure as elements (in my case - ArrayList implementation). All of these lists contains Entry class instanse(key-value). For definition number of bucket I use simple formula :   Math.abs(entry.getKey().hashCode() % BUCKETS_AMOUNT)
 - HashSet is based on HashMap structure. Elements in HashSet stored as key in map which HashSet incapsulate. Because of this Set structure contains only unique elements.
 - Queue is based on single linked list and FIFO algorithm.
 
For all methods created unit tests which is confirmed working ability of code.
 
