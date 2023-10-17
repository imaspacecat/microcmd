package org.firstinspires.ftc.teamcode.microcmd2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class Scheduler {
    private static final List<Cmd> cmds = new ArrayList<>();

    public static void schedule(Cmd cmd) {
        List<Cmd> toRemove = new ArrayList<>();
        for (Cmd lCmd : cmds) {
            if (cmd.getGroup() != null && cmd.getGroup().equals(lCmd.getGroup())) {
                lCmd.terminate();
                toRemove.add(lCmd);
            }
        }
        cmds.removeAll(toRemove);

        cmd.init();
        cmds.add(cmd);
    }

    public static void run() {
        List<Cmd> toRemove = new ArrayList<>();
        for (Cmd cmd : cmds) {
            if (cmd.isFinished()) {
                cmd.terminate();
                toRemove.add(cmd);
            }
        }
        cmds.removeAll(toRemove);

        cmds.forEach(Cmd::run);
    }
}