# Composite Design Pattern Implementation

This folder contains the source code for the successful implementation of the Composite Design Pattern Implementation.
I have implemented the Composite Design Pattern using three major parts: Component, Composite & Leaf(s)

The Component of the Design implementation is 'View' interface which has three methods, namely, 
1. update() -> updates the visual of the view on the app
2. getView() -> It is of the type 'Component' and it returns the Component of the leaf
3. reset() -> resets the view 

The Leaf(s) of the Design implementation are as follows and they have update(), getView() & reset() methods:
1. AddNumberView()
2. CountView()
3. MaxView()
4. MeanView()
5. MedianView()
6. NumberListView()

Composite of the Design implementation is the 'BasicStatsGUI' class. It utilizes the different views which implements the View interface, for updating the app. It accesses these views by using an ArrayList<View> which stores the views.
