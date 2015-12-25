# MyCollections
My implementation of the main data structures in Java (ArrayList, LinkedList, HashMap, HashSet and Queue)

![alt tag](https://github.com/SayidJarrah/MyCollections/blob/master/MyCollectionsUML.png)

What is it?
-----------
"MyCollections" is a my implementation of the most important data structures in Java : 
 - ArrayList based on array structure.
 - LinkedList based on doubly linked list which saved first and last nodes and links on next and previous nodes.
 - HashMap - structure "key-value", based on array that contains list structure as elements (in my case - ArrayList implementation). All of these lists contains Entry class instanse(key-value). For definition number of bucket I use simple formula : Math.abs(entry.getKey().hashCode() % BUCKETS_AMOUNT)
 - HashSet based on HashMap structure. Elements in HashSet stored as key in map which HashSet incapsulate. Because of this Set structure contains only unique elements.
 - Queue - based on single linked list and FIFO algorithm.
 
