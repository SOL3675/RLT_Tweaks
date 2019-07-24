package sol3675.rlttweaks.common.blocks.simpleblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sol3675.rlttweaks.RLTTweaks;
import sol3675.rlttweaks.references.ModInfo;

public class AethiumAlloy extends Block
{
    public AethiumAlloy()
    {
        super(Material.IRON);
        setRegistryName(ModInfo.MODID, "aethium_alloy");
        setUnlocalizedName("aethium_alloy");
        setCreativeTab(RLTTweaks.creativeTabs);
        setHardness(60F);
        setHarvestLevel("pickaxe", 10);
        setResistance(6000000F);
    }

    @Override
    public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity)
    {
        return !(entity instanceof EntityWither);
    }

    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion)
    {
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosionIn) {
        return false;
    }
}
