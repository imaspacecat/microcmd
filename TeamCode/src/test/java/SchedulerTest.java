import org.firstinspires.ftc.teamcode.microcmd.*;
import org.junit.Test;

import java.util.function.BooleanSupplier;

public class SchedulerTest {
    @Test
    public void scheduler1() {
        System.out.println("hello world");
        Scheduler.schedule(new IfCmd(new InstantCmd(() -> System.out.println("hi")), () -> 1 == 1, () -> false));
        Scheduler.schedule(new IfCmd(new InstantCmd(() -> System.out.println("bruh")), () -> 1 == 1, () -> false));
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
    }

    @Test
    public void scheduler2() {
        System.out.println("hello world");
        Scheduler2.schedule(new IfCmd2(new InstantCmd(() -> System.out.println("hi")), () -> 1 == 1, () -> false));
        Scheduler2.schedule(new IfCmd2(new InstantCmd(() -> System.out.println("bruh")), () -> 1 == 1, () -> false));
        Scheduler2.schedule(new IfCmd2(new InstantCmd(() -> System.out.println("assd")), () -> 1 == 1, () -> false));
        Scheduler2.schedule(new FullCmd(() -> {}, () -> System.out.println("asdasdasd"), () -> {}, () -> false, "hi"));
//        Scheduler2.run();
//        Scheduler2.run();
//        Scheduler2.run();
        Scheduler2.schedule(new FullCmd(() -> {}, () -> System.out.println("121212"), () -> {}, () -> false, "hi"));
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.schedule(new IfCmd2(new InstantCmd(() -> System.out.println("bruh")), () -> 1 != 1, () -> false));
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();

        System.out.println(Scheduler2.getCmds());
    }

    public Cmd ifCmd(Cmd cmd, BooleanSupplier event, BooleanSupplier isFinished) {
        return new FullCmd(
                () -> {}, () -> {
            if (event.getAsBoolean()) {
                Scheduler3.schedule(cmd);
            }
        }, () -> {}, isFinished);
    }

    @Test
    public void scheduler3() {
        System.out.println("hello world");
        Scheduler3.schedule(ifCmd(new InstantCmd(() -> System.out.println("hi")), () -> 1 == 1, () -> true));
        Scheduler3.run();
        Scheduler3.run();
        Scheduler3.schedule(ifCmd(new InstantCmd(() -> System.out.println("bruh")), () -> 1 == 1, () -> false));
        Scheduler3.run();
        Scheduler3.run();
        Scheduler3.run();
        Scheduler3.run();

        Scheduler3.schedule(ifCmd(new InstantCmd(() -> System.out.println("bruh")), () -> 1 != 1, () -> true));
        Scheduler3.run();
        Scheduler3.run();
        Scheduler3.run();
        Scheduler3.run();

        Scheduler3.schedule(new InstantCmd(() -> System.out.println("asd")));
        Scheduler3.run();
        Scheduler3.run();
        Scheduler3.run();

        System.out.println(Scheduler3.getCmds());
        System.out.println(Scheduler3.getCmds().size());
    }
}
