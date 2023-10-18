package org.firstinspires.ftc.teamcode.microcmd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scheduler {
    private static final List<Cmd> cmds = new ArrayList<>();
    private static final List<Cmd> toSchedule = new ArrayList<>();

    public static void schedule(Cmd cmd) {
        Iterator<Cmd> iter = cmds.iterator();
        while (iter.hasNext()) {
            Cmd next = iter.next();
            if (cmd.getGroup() != null && cmd.getGroup().equals(next.getGroup())) {
                next.terminate();
                iter.remove();
            }
        }
//        List<Cmd> toRemove = new ArrayList<>();
//        for (Cmd lCmd : cmds) {
//            if (cmd.getGroup() != null && cmd.getGroup().equals(lCmd.getGroup())) {
//                lCmd.terminate();
//                toRemove.add(lCmd);
//            }
//        }
//        cmds.removeAll(toRemove);

        cmd.init();
//        cmds.add(cmd);
        toSchedule.add(cmd);
    }

    public static void run() {
        cmds.addAll(toSchedule);
        toSchedule.clear();

        Iterator<Cmd> iter = cmds.iterator();
        while (iter.hasNext()) {
            Cmd next = iter.next();
            if (next.isFinished()) {
                next.terminate();
                iter.remove();
            }
        }

//        List<Cmd> toRemove = new ArrayList<>();
//        for (Cmd cmd : cmds) {
//            if (cmd.isFinished()) {
//                cmd.terminate();
//                toRemove.add(cmd);
//            }
//        }
//        cmds.removeAll(toRemove);

        cmds.forEach(Cmd::run);
    }

    public static List<Cmd> getCmds() {
        return cmds;
    }
}