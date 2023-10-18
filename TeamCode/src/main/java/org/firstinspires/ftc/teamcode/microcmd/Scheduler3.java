package org.firstinspires.ftc.teamcode.microcmd;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Scheduler3 {
    private static final Queue<Cmd> cmds = new ConcurrentLinkedQueue<>();

    public static void schedule(Cmd cmd) {
        Iterator<Cmd> iter = cmds.iterator();
        while (iter.hasNext()) {
            Cmd next = iter.next();
            if (cmd.getGroup() != null && cmd.getGroup().equals(next.getGroup())) {
                next.terminate();
                iter.remove();
            }
        }

        cmd.init();
        cmds.add(cmd);
    }

    public static void run() {
        Iterator<Cmd> iter = cmds.iterator();
        while (iter.hasNext()) {
            Cmd next = iter.next();
            if (next.isFinished()) {
                next.terminate();
                iter.remove();
            }
        }

        cmds.forEach(Cmd::run);
    }

    public static Queue<Cmd> getCmds() {
        return cmds;
    }
}