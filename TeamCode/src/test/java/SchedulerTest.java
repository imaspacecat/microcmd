
import org.firstinspires.ftc.teamcode.microcmd.*;
import org.firstinspires.ftc.teamcode.microcmd.example.BindCmd;
import org.junit.Test;

import java.util.function.BooleanSupplier;
import static org.firstinspires.ftc.teamcode.microcmd.Cmds.*;

public class SchedulerTest {
    @Test
    public void scheduler1() {
        System.out.println("hello world");
        Scheduler.schedule(new FullCmd(() -> {}, () -> System.out.println("a"), () -> {}, () -> false, "idk"));
        Scheduler.run();
        Scheduler.schedule(new FullCmd(() -> {}, () -> System.out.println("b"), () -> {}, () -> false, "idk"));
        Scheduler.schedule(new FullCmd(() -> {}, () -> System.out.println("c"), () -> {}, () -> false, "idk"));
        Scheduler.run();

        Scheduler.schedule(new BindCmd(instant(() -> System.out.println("hi")), () -> 1 == 1, () -> true));
        Scheduler.run();
        Scheduler.run();
        Scheduler.schedule(new BindCmd(instant(() -> System.out.println("bruh")), () -> 1 == 1, () -> false));
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();

        Scheduler.schedule(new BindCmd(instant(() -> System.out.println("bruh")), () -> 1 != 1, () -> true));
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();

        Scheduler.schedule(instant(() -> System.out.println("asd")));
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();

        System.out.println(Scheduler.getCmds());
        System.out.println(Scheduler.getCmds().size());

        Scheduler.schedule(instant(() -> System.out.println("hi")));
    }

    public Cmd ifCmd(Cmd cmd, BooleanSupplier event, BooleanSupplier isFinished) {
        return new FullCmd(() -> {}, () -> {
            if (event.getAsBoolean()) {
                Scheduler2.schedule(cmd);
            }
        }, () -> {}, isFinished);
    }

    @Test
    public void scheduler2() {
        System.out.println("hello world");
        Scheduler2.schedule(new FullCmd(() -> {}, () -> System.out.println("a"), () -> {}, () -> false, "idk"));
        Scheduler2.run();
        Scheduler2.schedule(new FullCmd(() -> {}, () -> System.out.println("b"), () -> {}, () -> false, "idk"));
        Scheduler2.schedule(new FullCmd(() -> {}, () -> System.out.println("c"), () -> {}, () -> false, "idk"));
        Scheduler2.run();

        Scheduler2.schedule(ifCmd(instant(() -> System.out.println("hi")), () -> 1 == 1, () -> true));
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.schedule(ifCmd(instant(() -> System.out.println("bruh")), () -> 1 == 1, () -> false));
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();

        Scheduler2.schedule(ifCmd(instant(() -> System.out.println("bruh")), () -> 1 != 1, () -> true));
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();

        Scheduler2.schedule(instant(() -> System.out.println("asd")));
        Scheduler2.run();
        Scheduler2.run();
        Scheduler2.run();

        System.out.println(Scheduler2.getCmds());
        System.out.println(Scheduler2.getCmds().size());
    }
}
