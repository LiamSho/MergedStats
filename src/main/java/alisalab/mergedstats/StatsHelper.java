package alisalab.mergedstats;

import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.StatHandler;
import net.minecraft.stat.Stats;

public final class StatsHelper {

    public static void updatePlayerData(ServerPlayerEntity p) {
        var handler = p.getStatHandler();

        var minedStonesOverworld = getMinedStones(handler)
                + getMinedCobblestones(handler)
                + getMinedDeepslate(handler)
                + getMinedCobbledDeepslate(handler)
                + getMinedSandstone(handler)
                + getMinedRedSandstone(handler)
                + getMinedGranite(handler)
                + getMinedDiorite(handler)
                + getMinedDiorite(handler)
                + getMinedAndesite(handler)
                + getMinedCalcite(handler)
                + getMinedTuff(handler);
        var minedStonesNether = getMinedNetherrack(handler)
                + getMinedCrimsonNylium(handler)
                + getMinedWarpedNylium(handler)
                + getMinedSoulSand(handler)
                + getMinedSoulSoil(handler)
                + getMinedBlackstone(handler)
                + getMinedBasalt(handler)
                + getMinedSmoothBasalt(handler)
                + getMinedGlowstone(handler);
        var minedStonesTotal = minedStonesOverworld + minedStonesNether;
        var playTimeMinutes = getPlayTime(handler) / 20 / 60;
        var travelSelfGroundDistance = getWalkDistance(handler)
                + getSprintDistance(handler);
        var travelSelfWaterDistance = getSwimDistance(handler)
                + getWalkOnWaterDistance(handler)
                + getWalkUnderWaterDistance(handler);
        var travelSelfDistance = travelSelfGroundDistance + travelSelfWaterDistance;
        var travelRideAnimalDistance = getHorseDistance(handler)
                + getPigDistance(handler)
                + getStriderDistance(handler);
        var travelRideTransportationDistance = getElytraDistance(handler)
                + getBoatDistance(handler)
                + getMinecartDistance(handler);
        var travelRideDistance = travelRideAnimalDistance + travelRideTransportationDistance;
        var travelAllDistance = travelSelfDistance + travelRideDistance;

        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.MINED_STONES_OVERWORLD), minedStonesOverworld);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.MINED_STONES_NETHER), minedStonesNether);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.MINED_STONES_TOTAL), minedStonesTotal);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.PLAY_TIME_MINUTES), playTimeMinutes);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_SELF_GROUND_DISTANCE), travelSelfGroundDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_SELF_WATER_DISTANCE), travelSelfWaterDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_SELF_DISTANCE), travelSelfDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_RIDE_ANIMAL_DISTANCE), travelRideAnimalDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_RIDE_TRANSPORTATION_DISTANCE), travelRideTransportationDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_RIDE_DISTANCE), travelRideDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_ALL_DISTANCE), travelAllDistance);
    }

    public static int getMinedStones(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.STONE));
    }

    public static int getMinedCobblestones(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.COBBLESTONE));
    }

    public static int getMinedDeepslate(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE));
    }

    public static int getMinedCobbledDeepslate(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.COBBLED_DEEPSLATE));
    }

    public static int getMinedSandstone(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SANDSTONE));
    }

    public static int getMinedRedSandstone(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.RED_SANDSTONE));
    }

    public static int getMinedGranite(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.GRANITE));
    }

    public static int getMinedDiorite(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DIORITE));
    }

    public static int getMinedAndesite(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.ANDESITE));
    }

    public static int getMinedCalcite(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.CALCITE));
    }

    public static int getMinedTuff(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.TUFF));
    }

    public static int getMinedNetherrack(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.NETHERRACK));
    }

    public static int getMinedCrimsonNylium(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.CRIMSON_NYLIUM));
    }

    public static int getMinedWarpedNylium(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.WARPED_NYLIUM));
    }

    public static int getMinedSoulSand(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SOUL_SAND));
    }

    public static int getMinedSoulSoil(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SOUL_SOIL));
    }

    public static int getMinedBlackstone(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.BLACKSTONE));
    }

    public static int getMinedBasalt(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.BASALT));
    }

    public static int getMinedSmoothBasalt(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SMOOTH_BASALT));
    }

    public static int getMinedGlowstone(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.GLOWSTONE));
    }

    public static int getPlayTime(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.PLAY_TIME));
    }

    public static int getWalkDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.WALK_ONE_CM));
    }

    public static int getSprintDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.SPRINT_ONE_CM));
    }

    public static int getSwimDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.SWIM_ONE_CM));
    }

    public static int getWalkOnWaterDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.WALK_ON_WATER_ONE_CM));
    }

    public static int getWalkUnderWaterDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.WALK_UNDER_WATER_ONE_CM));
    }

    public static int getHorseDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.HORSE_ONE_CM));
    }

    public static int getPigDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.PIG_ONE_CM));
    }

    public static int getStriderDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.STRIDER_ONE_CM));
    }

    public static int getElytraDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.AVIATE_ONE_CM));
    }

    public static int getMinecartDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.MINECART_ONE_CM));
    }

    public static int getBoatDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.BOAT_ONE_CM));
    }
}
