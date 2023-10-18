package org.firstinspires.ftc.teamcode.microcmd;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        Scheduler.schedule(new IfCmd(new InstantCmd(() -> System.out.println("hi")), () -> 1 == 1, () -> false));
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.schedule(new IfCmd(new InstantCmd(() -> System.out.println("bruh")), () -> 1 != 1, () -> false));
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();

        System.out.println(Scheduler.getCmds());

        System.out.println("hello world");
        Scheduler2.schedule(new IfCmd(new InstantCmd(() -> System.out.println("hi")), () -> 1 == 1, () -> false));
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.schedule(new IfCmd(new InstantCmd(() -> System.out.println("bruh")), () -> 1 != 1, () -> false));
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();

        System.out.println(Scheduler2.getCmds());
    }
}
