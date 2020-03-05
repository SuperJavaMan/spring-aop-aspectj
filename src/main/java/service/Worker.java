package service;

public class Worker implements Workable {

    public void doWork0() {
        System.out.println("Worker do work 0");
    }

    public String doWork1() {
        System.out.println("Worker do work 1");
        return "work 1";
    }

    public void doWork2() throws Exception {
        System.out.println("Worker do work 2");
        throw new Exception("Work 2 exception");
    }

    public void doWork3(String msg) {
        System.out.printf("Worker do work 3 with command '%s'!", msg);
    }
}
