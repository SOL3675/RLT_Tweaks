package main.java.sol3675.rlttweaks.common.fluids;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import main.java.sol3675.rlttweaks.RLTTweaks;

public class BlockFluidBase extends BlockFluidClassic
{
    public BlockFluidBase(String name, Fluid fluid, Material material)
    {
        super(fluid, material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(RLTTweaks.creativeTabs);
    }
}
