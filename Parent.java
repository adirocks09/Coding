package com.dell;

    class Parent {

        // Method of parent class
        int num = 10;
        void Print()
        {
            // Print statement
            System.out.println("parent class");
        }
    }

    // Class 2
// Helper class
    class subclass1 extends Parent {
        int num = 20;

        // Method
        void Print() { System.out.println("subclass1"); }
    }

    // Class 3
// Helper class
    class subclass2 extends Parent {
        int num = 30;

        // Method
        void Print()
        {

            // Print statement
            System.out.println("subclass2");
        }
    }

    // Class 4
// Main class
    class GFG {

        // Main driver method
        public static void main(String[] args)
        {

            // Creating object of class 1
            Parent a;

            // Now we will be calling print methods
            // inside main() method

            a = new subclass1();
            a.Print(); // polymorphism -> child method
            System.out.println(a.num); // parent data member

            a = new subclass2();
            a.Print();  // polymorphism -> child method
            System.out.println(a.num); // parent data member

        }
    }
