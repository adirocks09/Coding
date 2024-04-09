package com.dell.inheritance;

    class Parent {

        // data member
        int num = 10;

        //static method
        static void display(){
            System.out.println(" parent static method ");

        }

        // instance method
        void print()
        {
            System.out.println(" parent instance method ");
        }

    }

    // Class 2
// Helper class
    class Subclass1 extends Parent {
        // data member
        int num = 20;

        //static method
        static void display(){
            System.out.println(" subclass1 static method ");

        }

        // instance method
        void print()
        {
            System.out.println(" subclass1 instance method ");
        }
    }

    // Class 3
// Helper class
    class Subclass2 extends Parent {
        // data member
        int num = 30;

        //static method
        static void display(){
            System.out.println(" subclass2 static method ");

        }

        // instance method
        void print()
        {
            // Print statement
            System.out.println(" subclass2 instance method ");
        }
    }

    // Class 4
// Main class
    class ParentChildApp {

        // Main driver method
        public static void main(String[] args)
        {

            // Creating object of class 1
            Parent a;

            // Now we will be calling print methods
            // inside main() method

            a = new Subclass1();
            a.print(); // polymorphism -> child method gets called (method overriding -> instance method)
            a.display(); // parent method gets called (method hiding -> static method)
            System.out.println(a.num); // parent data member gets accessed

            a = new Subclass2();
            a.print(); // polymorphism -> child method gets called (method overriding -> instance method)
            a.display(); // parent method gets called (method hiding -> static method)
            System.out.println(a.num); // parent data member gets accessed

        }
    }
