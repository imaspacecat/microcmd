import org.firstinspires.ftc.teamcode.microcmd.Cmd;
import org.firstinspires.ftc.teamcode.microcmd.Scheduler;
import org.junit.Test;

import static org.firstinspires.ftc.teamcode.microcmd.Cmds.*;

public class CmdTest {
    @Test
    public void parallelTest() {
        Scheduler.schedule(parallel(
                bind(instant(() -> System.out.println("hi")), () -> 1 == 1, () -> false),
                instant(() -> System.out.println("by")),
                instant(() -> System.out.println("asdasd"))
        ));

        Scheduler.getCmds().forEach(cmd -> System.out.println(cmd.isFinished()));

        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
    }

    @Test
    public void sequentialTest() {
        Scheduler.schedule(sequential(
                bind(instant(() -> System.out.println("hi")), () -> 1 != 1, () -> false),
                instant(() -> System.out.println("by")),
                instant(() -> System.out.println("asdasd"))
        ));

        Scheduler.getCmds().forEach(cmd -> System.out.println(cmd.isFinished()));

        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
    }

    @Test
    public void example() {
        Scheduler.schedule(
                sequential(
                        instant(() -> System.out.println("hi")),
                        instant(() -> System.out.println("bye")),
                        instant(() -> System.out.println("amogus")),
                        parallel(
                                instant(() -> System.out.println("i am speed")),
                                instant(() -> System.out.println("ppaaaaaaaaaaaaaaaaaaaaaaaaaralel!"))
                        )
                )
        );

        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();
        Scheduler.run();

    }
}
