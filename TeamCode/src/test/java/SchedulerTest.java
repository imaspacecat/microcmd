
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
}
