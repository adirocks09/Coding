package com.dell.multiThreading;

class Foo {
    public void first() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i +" : first");
        }
    }

    public void second() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " : second");
        }
    }

    public void third() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " : third");
        }
    }
}

// PROBLEM STATEMENT
// The same instance of Foo will be passed to three different threads.
// Thread A will call first(), thread B will call second(), and thread C will call third().
// Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

class MultiThreadApp {

    public static void main(String args[]) {
        MultiThreadApp mainApp = new MultiThreadApp();
        mainApp.execute1();
        //mainApp.execute2();
        //mainApp.execute3();
    }

    public void execute1() {
        Foo foo = new Foo();
        // Lock on the caller object -> mainApp Object (this object -> mainApp.execute1())
        Thread t1 = new Thread(() -> {
            synchronized (this) {
                foo.first();
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (this) {
                foo.second();
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (this) {
                foo.third();
            }
        });

        try {
            t1.start();
            //t1.join();   // Method Sequence is not maintained without calling join
            t2.start();
            //t2.join();
            t3.start();
            //t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void execute2() {
        Foo foo = new Foo();
        // Lock on the foo object
        Thread t1 = new Thread(() -> {
            synchronized (foo) {
                foo.first();
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (foo) {
                foo.second();
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (foo) {
                foo.third();
            }
        });

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void execute3() {
        Foo foo = new Foo();

        Thread t1 = new Thread(() -> foo.first());
        Thread t2 = new Thread(() -> foo.second());
        Thread t3 = new Thread(() -> foo.third());

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

