package fr.papillonlut.radio.rpc;

import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import club.minnced.discord.rpc.DiscordEventHandlers;

public class DiscordStatusManager {
    private static final DiscordRPC lib = DiscordRPC.INSTANCE;
    private static final DiscordRichPresence presence = new DiscordRichPresence();

    public static void init() {
        String applicationId = "1209294961917296650";
        String steamId = "";

        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> System.out.println("Ready!");

        lib.Discord_Initialize(applicationId, handlers, true, steamId);

        // Set initial presence
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        presence.details = "Radio is a Minecraft Mod";
        presence.largeImageKey = "pp-mod";
        presence.largeImageText = "Radio";
        lib.Discord_UpdatePresence(presence);

        // Start a thread for callbacks
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    lib.Discord_Shutdown();
                    break;
                }
            }
        }, "RPC-Callback-Handler");
        t.start();
    }
}

