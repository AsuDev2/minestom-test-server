package com.example.server.blocks;

import org.jglrxavpok.hephaistos.nbt.NBT;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;

import net.minestom.server.data.Data;
import net.minestom.server.data.DataImpl;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;
import net.minestom.server.utils.BlockPosition;

public class VanillaBlockEntity extends VanillaBlock {
	
	public VanillaBlockEntity(Block block) {
		super(block);
	}
	
	@Override
	public Data readBlockEntity(NBTCompound nbt, Instance instance, BlockPosition position, Data originalData) {
		
		if (nbt == null)
			return Data.EMPTY;
		
		originalData = new DataImpl();
		
		originalData.set("nbt", nbt);
		
        return originalData;
    }
	
	@Override
	public void writeBlockEntity(BlockPosition position, Data blockData, NBTCompound nbt) {
		
		if (blockData == null)
			return;
		
		if (!blockData.hasKey("nbt"))
			return;
		
		NBTCompound compound = blockData.get("nbt");
		
		compound.iterator().forEachRemaining((pair) -> {
			String key = pair.getFirst();
			
			NBT value = pair.getSecond();
			
			nbt.set(key, value);
		});
    }
}