package org.firstinspires.ftc.teamcode.microcmd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class Scheduler {
    private static final List<Cmd> cmds = new ArrayList<>();
    private static final Map<Cmd, BooleanSupplier> toSchedule = new HashMap<>();

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

    public static void scheduleIf(Cmd cmd, BooleanSupplier event) {
        toSchedule.put(cmd, event);
    }

    public static void run() {
        List<Cmd> toRemove = new ArrayList<>();
        for (Cmd cmd : toSchedule.keySet()) {
            if (toSchedule.get(cmd).getAsBoolean()) {
                schedule(cmd);
            }
        }

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
