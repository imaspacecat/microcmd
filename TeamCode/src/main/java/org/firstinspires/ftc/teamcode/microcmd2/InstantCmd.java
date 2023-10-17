package org.firstinspires.ftc.teamcode.microcmd2;

public class InstantCmd extends FullCmd {
    public InstantCmd(Runnable runnable) {
        super(runnable, () -> {}, () -> {}, () -> true);
    }
}
