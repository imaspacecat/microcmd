package org.firstinspires.ftc.teamcode.microcmd;

public class InstantCmd extends FullCmd {
    public InstantCmd(Runnable runnable) {
        super(runnable, () -> {}, () -> {}, () -> true);
    }
}
