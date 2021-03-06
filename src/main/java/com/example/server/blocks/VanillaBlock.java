package com.example.server.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jglrxavpok.hephaistos.nbt.NBTCompound;

import net.minestom.server.data.Data;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.block.BlockAlternative;
import net.minestom.server.instance.block.CustomBlock;
import net.minestom.server.utils.BlockPosition;
import net.minestom.server.utils.time.UpdateOption;

/**
 * Represents a vanilla block implementation.
 * Will handle creation of all VanillaCustomBlock necessary to represent this block
 */
public abstract class VanillaBlock extends CustomBlock {

    private final Block baseBlock;
    private final List<BlockAlternative> blockStates;
    private final BlockAlternative baseBlockState;

    public VanillaBlock(Block baseBlock) {
        super(baseBlock, "vanilla_"+baseBlock.name().toLowerCase());
        this.baseBlock = baseBlock;

        // get block states
        this.blockStates = baseBlock.getAlternatives();
        
        // Get all varients
        List<String[]> allVariants = new ArrayList<String[]>();
        
        for (BlockAlternative blockState : blockStates) {
        	allVariants.add(blockState.getProperties());
        }
        
        baseBlockState = baseBlock.getAlternative(baseBlock.getBlockId());
    }

    public BlockAlternative getBaseBlockState() {
        return baseBlockState;
    }

    public Block getBaseBlock() {
        return baseBlock;
    }

    /**
     * Create data for this block
     * @param blockPosition
     * @param data
     * @return
     */
    @Override
    public Data createData(Instance instance, BlockPosition blockPosition, Data data) {
        return data;
    }

    @Override
    public void onPlace(Instance instance, BlockPosition blockPosition, Data data) {

    }

    @Override
    public void onDestroy(Instance instance, BlockPosition blockPosition, Data data) {

    }

    @Override
    public void update(Instance instance, BlockPosition blockPosition, Data data) {

    }

    /**
     * Interact with this block, depending on properties
     */
    @Override
    public boolean onInteract(Player player, Player.Hand hand, BlockPosition blockPosition, Data data) {
        return false;
    }

    @Override
    public UpdateOption getUpdateOption() {
        return null;
    }

    public short getBaseBlockId() {
        return baseBlock.getBlockId();
    }

    @Override
    public short getCustomBlockId() {
        return baseBlock.getBlockId();
    }

    @Override
    public int getBreakDelay(Player player, BlockPosition position, byte stage, Set<Player> breakers) {
        return -1;
    }

    public short getVisualBlockForPlacement(Player player, Player.Hand hand, BlockPosition blockPosition) {
        return getBaseBlockId();
    }

    /**
     * Loads the BlockEntity information from the given NBT, during world loading from the Anvil format.
     * Should be stored in the Data object returned by this function.
     * It is allowed (and encouraged) to modify 'originalData' and returning it.
     *
     * Your method {@link #createData(Instance, BlockPosition, Data)} should return a non-null data object if you want to use this method easily
     * @param nbt the nbt data to read from
     * @param instance instance in which the tile entity is being loaded
     * @param position position at which this block is. DON'T CACHE IT
     * @param originalData data present at the current position
     * @return a Data object with the loaded information. Can be originalData, a new object, or even null if you don't use the TE info
     */
    public Data readBlockEntity(NBTCompound nbt, Instance instance, BlockPosition position, Data originalData) {
        return originalData;
    }

    public List<BlockAlternative> getBlockStates() {
        return blockStates;
    }
}
