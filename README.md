# triangle-testing
### By: Colby Kuhnel
## Usage
### JUnit tests
* Main has all information for testing
* Exact input:
    * num -> `f`
    * num -> `1`
    * Enter Side 1 of Triangle -> `f`
    * Enter Side 1 of Triangle -> `2`
    * Enter Side 2 of Triangle -> `3`
    * Enter Side 3 of Triangle -> `4`
    * num -> `2`
    * Enter X Position of Point A of Triangle -> `0`
    * Enter Y Position of Point A of Triangle -> `0`
    * Enter X Position of Point B of Triangle -> `0`
    * Enter Y Position of Point B of Triangle -> `1`
    * Enter X Position of Point C of Triangle -> `1`
    * Enter Y Position of Point C of Triangle -> `0`
## Results
* Summary: https://i.imgur.com/uS62A6x.png
* 99.4% coverage
### Notes
* Main.java line 9: `public class Main {` not covered.
* Main.java line 87: `return null;` not covered.
* These are the only lines not covered in the assignment based on instructions and assertions in main

## Assignment 6 Deviation
* Instead of Jacoco, EclEmma is used since project is build on Eclipse
* Due to manual input being required for coverage, main has instructions for running tests
