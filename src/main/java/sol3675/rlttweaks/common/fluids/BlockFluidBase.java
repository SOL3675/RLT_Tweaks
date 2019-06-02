package sol3675.rlttweaks.common.fluids;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import sol3675.rlttweaks.RLTTweaks;
import sol3675.rlttweaks.common.registry.RLTRegistry;
import sol3675.rlttweaks.references.ModInfo;

public class BlockFluidBase extends BlockFluidClassic
{
    public BlockFluidBase(String name, Fluid fluid, Material material)
    {
        super(fluid, material);
        this.setRegistryName(ModInfo.MODID, name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setCreativeTab(RLTTweaks.creativeTabs);

        RLTRegistry.registerdBlock.add(this);
    }
}
