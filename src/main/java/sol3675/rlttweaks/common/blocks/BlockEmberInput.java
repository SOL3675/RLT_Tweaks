package main.java.sol3675.rlttweaks.common.blocks;

import hellfirepvp.modularmachinery.common.block.BlockMachineComponent;
import main.java.sol3675.rlttweaks.RLTTweaks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockEmberInput extends BlockMachineComponent
{
    public BlockEmberInput()
    {
        super(Material.IRON);
        setHardness(2F);
        setResistance(10F);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 1);
        setCreativeTab(RLTTweaks.creativeTabs);
    }
}
