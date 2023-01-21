package alisalab.mergedstats;

import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;

public final class StatsUpdater {

    public static void update(PlayerManager playerManager) {

        var playerList = playerManager.getPlayerList();

        for (ServerPlayerEntity p : playerList) {
            StatsHelper.updatePlayerData(p);
        }

    }
}
