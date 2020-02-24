package main.java.sol3675.rlttweaks.common.blocks;

import net.minecraft.block.material.Material;
import main.java.sol3675.rlttweaks.references.Reference;

public class BlockMisc0 extends BlockBase
{
    public BlockMisc0()
    {
        super("block_misc_0", Material.IRON, ItemBlockBase.class, Reference.blockMisc0);
        setHardness(60F);
        setHarvestLevel("pickaxe", 10);
        setResistance(6000000F);
    }
}
