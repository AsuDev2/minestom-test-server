package com.example.server.blocks;

import java.io.FileNotFoundException;
import java.util.List;

import net.minestom.server.MinecraftServer;
import net.minestom.server.data.Data;
import net.minestom.server.data.DataImpl;
import net.minestom.server.entity.ItemEntity;
import net.minestom.server.event.player.PlayerBlockPlaceEvent;
import net.minestom.server.gamedata.loottables.LootTable;
import net.minestom.server.gamedata.loottables.LootTableManager;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.block.BlockManager;
import net.minestom.server.instance.block.CustomBlock;
import net.minestom.server.instance.block.rule.BlockPlacementRule;
import net.minestom.server.item.ItemStack;
import net.minestom.server.network.ConnectionManager;
import net.minestom.server.utils.BlockPosition;
import net.minestom.server.utils.NamespaceID;
import net.minestom.server.utils.Position;
import net.minestom.server.utils.time.TimeUnit;

public enum VanillaBlocks {
	FURNACE(() -> {return new VanillaBlockEntity(Block.FURNACE);}),
	CHEST(() -> {return new VanillaBlockEntity(Block.CHEST);}),
	TRAPPED_CHEST(() -> {return new VanillaBlockEntity(Block.TRAPPED_CHEST);}),
	ENDER_CHEST(() -> {return new VanillaBlockEntity(Block.ENDER_CHEST);}),
	JUKEBOX(() -> {return new VanillaBlockEntity(Block.JUKEBOX);}),
	DISPENSER(() -> {return new VanillaBlockEntity(Block.DISPENSER);}),
	DROPPER(() -> {return new VanillaBlockEntity(Block.DROPPER);}),
	OAK_SIGN(() -> {return new VanillaBlockEntity(Block.OAK_SIGN);}),
	SPRUCE_SIGN(() -> {return new VanillaBlockEntity(Block.SPRUCE_SIGN);}),
	BIRCH_SIGN(() -> {return new VanillaBlockEntity(Block.BIRCH_SIGN);}),
	ACACIA_SIGN(() -> {return new VanillaBlockEntity(Block.ACACIA_SIGN);}),
	JUNGLE_SIGN(() -> {return new VanillaBlockEntity(Block.JUNGLE_SIGN);}),
	DARK_OAK_SIGN(() -> {return new VanillaBlockEntity(Block.DARK_OAK_SIGN);}),
	OAK_WALL_SIGN(() -> {return new VanillaBlockEntity(Block.OAK_WALL_SIGN);}),
	SPRUCE_WALL_SIGN(() -> {return new VanillaBlockEntity(Block.SPRUCE_WALL_SIGN);}),
	BIRCH_WALL_SIGN(() -> {return new VanillaBlockEntity(Block.BIRCH_WALL_SIGN);}),
	ACACIA_WALL_SIGN(() -> {return new VanillaBlockEntity(Block.ACACIA_WALL_SIGN);}),
	JUNGLE_WALL_SIGN(() -> {return new VanillaBlockEntity(Block.JUNGLE_WALL_SIGN);}),
	DARK_OAK_WALL_SIGN(() -> {return new VanillaBlockEntity(Block.DARK_OAK_WALL_SIGN);}),
	CRIMSON_SIGN(() -> {return new VanillaBlockEntity(Block.CRIMSON_SIGN);}),
	CRIMSON_WALL_SIGN(() -> {return new VanillaBlockEntity(Block.CRIMSON_WALL_SIGN);}),
	WARPED_SIGN(() -> {return new VanillaBlockEntity(Block.WARPED_SIGN);}),
	WARPED_WALL_SIGN(() -> {return new VanillaBlockEntity(Block.WARPED_WALL_SIGN);}),
	SPAWNER(() -> {return new VanillaBlockEntity(Block.SPAWNER);}),
	MOVING_PISTON(() -> {return new VanillaBlockEntity(Block.MOVING_PISTON);}),
	BREWING_STAND(() -> {return new VanillaBlockEntity(Block.BREWING_STAND);}),
	ENCHANTING_TABLE(() -> {return new VanillaBlockEntity(Block.ENCHANTING_TABLE);}),
	END_PORTAL(() -> {return new VanillaBlockEntity(Block.END_PORTAL);}),
	BEACON(() -> {return new VanillaBlockEntity(Block.BEACON);}),
	SKELETON_SKULL(() -> {return new VanillaBlockEntity(Block.SKELETON_SKULL);}),
	SKELETON_WALL_SKULL(() -> {return new VanillaBlockEntity(Block.SKELETON_WALL_SKULL);}),
	CREEPER_HEAD(() -> {return new VanillaBlockEntity(Block.CREEPER_HEAD);}),
	CREEPER_WALL_HEAD(() -> {return new VanillaBlockEntity(Block.CREEPER_WALL_HEAD);}),
	DRAGON_HEAD(() -> {return new VanillaBlockEntity(Block.DRAGON_HEAD);}),
	DRAGON_WALL_HEAD(() -> {return new VanillaBlockEntity(Block.DRAGON_WALL_HEAD);}),
	ZOMBIE_HEAD(() -> {return new VanillaBlockEntity(Block.ZOMBIE_HEAD);}),
	ZOMBIE_WALL_HEAD(() -> {return new VanillaBlockEntity(Block.ZOMBIE_WALL_HEAD);}),
	WITHER_SKELETON_SKULL(() -> {return new VanillaBlockEntity(Block.WITHER_SKELETON_SKULL);}),
	WITHER_SKELETON_WALL_SKULL(() -> {return new VanillaBlockEntity(Block.WITHER_SKELETON_WALL_SKULL);}),
	PLAYER_HEAD(() -> {return new VanillaBlockEntity(Block.PLAYER_HEAD);}),
	PLAYER_WALL_HEAD(() -> {return new VanillaBlockEntity(Block.PLAYER_WALL_HEAD);}),
	DAYLIGHT_DETECTOR(() -> {return new VanillaBlockEntity(Block.DAYLIGHT_DETECTOR);}),
	HOPPER(() -> {return new VanillaBlockEntity(Block.HOPPER);}),
	COMPARATOR(() -> {return new VanillaBlockEntity(Block.COMPARATOR);}),
	WHITE_BANNER(() -> {return new VanillaBlockEntity(Block.WHITE_BANNER);}),
	ORANGE_BANNER(() -> {return new VanillaBlockEntity(Block.ORANGE_BANNER);}),
	MAGENTA_BANNER(() -> {return new VanillaBlockEntity(Block.MAGENTA_BANNER);}),
	LIGHT_BLUE_BANNER(() -> {return new VanillaBlockEntity(Block.LIGHT_BLUE_BANNER);}),
	YELLOW_BANNER(() -> {return new VanillaBlockEntity(Block.YELLOW_BANNER);}),
	LIME_BANNER(() -> {return new VanillaBlockEntity(Block.LIME_BANNER);}),
	PINK_BANNER(() -> {return new VanillaBlockEntity(Block.PINK_BANNER);}),
	GRAY_BANNER(() -> {return new VanillaBlockEntity(Block.GRAY_BANNER);}),
	LIGHT_GRAY_BANNER(() -> {return new VanillaBlockEntity(Block.LIGHT_GRAY_BANNER);}),
	CYAN_BANNER(() -> {return new VanillaBlockEntity(Block.CYAN_BANNER);}),
	PURPLE_BANNER(() -> {return new VanillaBlockEntity(Block.PURPLE_BANNER);}),
	BLUE_BANNER(() -> {return new VanillaBlockEntity(Block.BLUE_BANNER);}),
	BROWN_BANNER(() -> {return new VanillaBlockEntity(Block.BROWN_BANNER);}),
	GREEN_BANNER(() -> {return new VanillaBlockEntity(Block.GREEN_BANNER);}),
	RED_BANNER(() -> {return new VanillaBlockEntity(Block.RED_BANNER);}),
	BLACK_BANNER(() -> {return new VanillaBlockEntity(Block.BLACK_BANNER);}),
	WHITE_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.WHITE_WALL_BANNER);}),
	ORANGE_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.ORANGE_WALL_BANNER);}),
	MAGENTA_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.MAGENTA_WALL_BANNER);}),
	LIGHT_BLUE_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.LIGHT_BLUE_WALL_BANNER);}),
	YELLOW_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.YELLOW_WALL_BANNER);}),
	LIME_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.LIME_WALL_BANNER);}),
	PINK_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.PINK_WALL_BANNER);}),
	GRAY_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.GRAY_WALL_BANNER);}),
	LIGHT_GRAY_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.LIGHT_GRAY_WALL_BANNER);}),
	CYAN_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.CYAN_WALL_BANNER);}),
	PURPLE_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.PURPLE_WALL_BANNER);}),
	BLUE_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.BLUE_WALL_BANNER);}),
	BROWN_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.BROWN_WALL_BANNER);}),
	GREEN_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.GREEN_WALL_BANNER);}),
	RED_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.RED_WALL_BANNER);}),
	BLACK_WALL_BANNER(() -> {return new VanillaBlockEntity(Block.BLACK_WALL_BANNER);}),
	STRUCTURE_BLOCK(() -> {return new VanillaBlockEntity(Block.STRUCTURE_BLOCK);}),
	END_GATEWAY(() -> {return new VanillaBlockEntity(Block.END_GATEWAY);}),
	COMMAND_BLOCK(() -> {return new VanillaBlockEntity(Block.COMMAND_BLOCK);}),
	CHAIN_COMMAND_BLOCK(() -> {return new VanillaBlockEntity(Block.CHAIN_COMMAND_BLOCK);}),
	REPEATING_COMMAND_BLOCK(() -> {return new VanillaBlockEntity(Block.REPEATING_COMMAND_BLOCK);}),
	SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.SHULKER_BOX);}),
	BLACK_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.BLACK_SHULKER_BOX);}),
	BLUE_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.BLUE_SHULKER_BOX);}),
	BROWN_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.BROWN_SHULKER_BOX);}),
	CYAN_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.CYAN_SHULKER_BOX);}),
	GRAY_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.GRAY_SHULKER_BOX);}),
	GREEN_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.GREEN_SHULKER_BOX);}),
	LIGHT_BLUE_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.LIGHT_BLUE_SHULKER_BOX);}),
	LIGHT_GRAY_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.LIGHT_GRAY_SHULKER_BOX);}),
	LIME_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.LIME_SHULKER_BOX);}),
	MAGENTA_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.MAGENTA_SHULKER_BOX);}),
	ORANGE_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.ORANGE_SHULKER_BOX);}),
	PINK_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.PINK_SHULKER_BOX);}),
	PURPLE_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.PURPLE_SHULKER_BOX);}),
	RED_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.RED_SHULKER_BOX);}),
	WHITE_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.WHITE_SHULKER_BOX);}),
	YELLOW_SHULKER_BOX(() -> {return new VanillaBlockEntity(Block.YELLOW_SHULKER_BOX);}),
	RED_BED(() -> {return new VanillaBlockEntity(Block.RED_BED);}),
	BLACK_BED(() -> {return new VanillaBlockEntity(Block.BLACK_BED);}),
	BLUE_BED(() -> {return new VanillaBlockEntity(Block.BLUE_BED);}),
	BROWN_BED(() -> {return new VanillaBlockEntity(Block.BROWN_BED);}),
	CYAN_BED(() -> {return new VanillaBlockEntity(Block.CYAN_BED);}),
	GRAY_BED(() -> {return new VanillaBlockEntity(Block.GRAY_BED);}),
	GREEN_BED(() -> {return new VanillaBlockEntity(Block.GREEN_BED);}),
	LIGHT_BLUE_BED(() -> {return new VanillaBlockEntity(Block.LIGHT_BLUE_BED);}),
	LIGHT_GRAY_BED(() -> {return new VanillaBlockEntity(Block.LIGHT_GRAY_BED);}),
	LIME_BED(() -> {return new VanillaBlockEntity(Block.LIME_BED);}),
	MAGENTA_BED(() -> {return new VanillaBlockEntity(Block.MAGENTA_BED);}),
	ORANGE_BED(() -> {return new VanillaBlockEntity(Block.ORANGE_BED);}),
	PINK_BED(() -> {return new VanillaBlockEntity(Block.PINK_BED);}),
	PURPLE_BED(() -> {return new VanillaBlockEntity(Block.PURPLE_BED);}),
	WHITE_BED(() -> {return new VanillaBlockEntity(Block.WHITE_BED);}),
	YELLOW_BED(() -> {return new VanillaBlockEntity(Block.YELLOW_BED);}),
	CONDUIT(() -> {return new VanillaBlockEntity(Block.CONDUIT);}),
	BARREL(() -> {return new VanillaBlockEntity(Block.BARREL);}),
	SMOKER(() -> {return new VanillaBlockEntity(Block.SMOKER);}),
	BLAST_FURNACE(() -> {return new VanillaBlockEntity(Block.BLAST_FURNACE);}),
	LECTERN(() -> {return new VanillaBlockEntity(Block.LECTERN);}),
	BELL(() -> {return new VanillaBlockEntity(Block.BELL);}),
	JIGSAW(() -> {return new VanillaBlockEntity(Block.JIGSAW);}),
	CAMPFIRE(() -> {return new VanillaBlockEntity(Block.CAMPFIRE);}),
	SOUL_CAMPFIRE(() -> {return new VanillaBlockEntity(Block.SOUL_CAMPFIRE);}),
	BEE_NEST(() -> {return new VanillaBlockEntity(Block.BEE_NEST);}),
	BEEHIVE(() -> {return new VanillaBlockEntity(Block.BEEHIVE);});

    private final VanillaBlockSupplier blockSupplier;
    private final BlockPlacementRule placementRule;
    private boolean registered;
    private VanillaBlock instance;

    private VanillaBlocks(VanillaBlockSupplier blockSupplier) {
        this(blockSupplier, null);
    }

    private VanillaBlocks(VanillaBlockSupplier blockSupplier, BlockPlacementRule placementRule) {
        this.blockSupplier = blockSupplier;
        this.placementRule = placementRule;
    }

    /**
     * Register this vanilla block to the given BlockManager, ConnectionManager is used to replace the basic block with its custom variant
     *
     * @param connectionManager
     * @param blockManager
     */
    public void register(short customBlockID, ConnectionManager connectionManager, BlockManager blockManager) {
        VanillaBlock block = this.blockSupplier.create();
        connectionManager.addPlayerInitialization(player -> {
            player.addEventCallback(PlayerBlockPlaceEvent.class, event -> {
                if (event.getBlockStateId() == block.getBaseBlockId()) {
                    short blockID = block.getVisualBlockForPlacement(event.getPlayer(), event.getHand(), event.getBlockPosition());
                    event.setBlockStateId(blockID);
                    event.setCustomBlockId(block.getCustomBlockId());
                }
            });
        });
        blockManager.registerCustomBlock(block);
        if (placementRule != null) {
            blockManager.registerBlockPlacementRule(placementRule);
        }
        instance = block;
        registered = true;
    }

    /**
     * Used to know if this block has been registered. Can be used to disable mechanics if this block is not registered (ie nether portals and nether portal blocks)
     *
     * @return
     */
    public boolean isRegistered() {
        return registered;
    }

    /**
     * Gets this block instance. 'null' if this block has not been registered
     *
     * @return
     */
    public VanillaBlock getInstance() {
        return instance;
    }

    /**
     * Register all vanilla commands into the given blockManager. ConnectionManager is used to replace the basic block with its custom counterpart
     *
     * @param blockManager
     */
    public static void registerAll(ConnectionManager connectionManager, BlockManager blockManager) {
        for (VanillaBlocks vanillaBlock : values()) {
            vanillaBlock.register((short) vanillaBlock.ordinal(), connectionManager, blockManager);
        }
    }

    @FunctionalInterface
    private interface VanillaBlockSupplier {
        VanillaBlock create();
    }

    public static void dropOnBreak(Instance instance, BlockPosition position) {
        LootTable table = null;
        LootTableManager lootTableManager = MinecraftServer.getLootTableManager();
        CustomBlock customBlock = instance.getCustomBlock(position);
        if (customBlock != null) {
            table = customBlock.getLootTable(lootTableManager);
        }
        Block block = Block.fromStateId(instance.getBlockStateId(position));
        Data lootTableArguments = new DataImpl();
        // TODO: tool used, silk touch, etc.
        try {
            if (table == null) {
                table = lootTableManager.load(NamespaceID.from("blocks/" + block.name().toLowerCase()));
            }
            List<ItemStack> stacks = table.generate(lootTableArguments);
            for (ItemStack item : stacks) {
                Position spawnPosition = new Position((float) (position.getX() + 0.2f + Math.random() * 0.6f), (float) (position.getY() + 0.5f), (float) (position.getZ() + 0.2f + Math.random() * 0.6f));
                ItemEntity itemEntity = new ItemEntity(item, spawnPosition);

                itemEntity.getVelocity().setX((float) (Math.random() * 2f - 1f));
                itemEntity.getVelocity().setY((float) (Math.random() * 2f));
                itemEntity.getVelocity().setZ((float) (Math.random() * 2f - 1f));

                itemEntity.setPickupDelay(500, TimeUnit.MILLISECOND);
                itemEntity.setInstance(instance);
            }
        } catch (FileNotFoundException e) {
            // ignore missing table
        }
    }
}
