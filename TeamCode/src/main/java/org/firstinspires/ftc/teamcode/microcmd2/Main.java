package org.firstinspires.ftc.teamcode.microcmd2;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        Scheduler.scheduleIf(new InstantCmd(() -> System.out.println("hi")), () -> 1 == 1);
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.scheduleIf(new InstantCmd(() -> System.out.println("bye")), () -> 1 != 1);
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
    }
}
