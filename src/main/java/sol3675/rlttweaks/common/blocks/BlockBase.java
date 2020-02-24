package main.java.sol3675.rlttweaks.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import main.java.sol3675.rlttweaks.RLTTweaks;
import main.java.sol3675.rlttweaks.common.registry.RLTRegistry;
import main.java.sol3675.rlttweaks.references.ModInfo;

public class BlockBase extends Block
{
    public String name;
    protected String[] subNames;

    public BlockBase(String name, Material material, Class<? extends ItemBlockBase> itemBlock, String... subNames)
    {
        super(material);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setCreativeTab(RLTTweaks.creativeTabs);
        RLTRegistry.registeredBlock.add(this);
    }

    public String[] getSubNames()
    {
        return subNames;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        int meta = this.getMetaFromState(state);
        if(meta >= 0)
        {
            super.getDrops(drops, world, pos, state, fortune);
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerBlockRender(BlockBase block)
    {
        if(block.getSubNames() != null)
        {
            for (int i = 0; i < block.getSubNames().length; ++i)
            {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), i, new ModelResourceLocation(ModInfo.MODID + ":" + block.getUnlocalizedName().substring(5) + "_" + block.getSubNames()[i], "inventory"));
            }
        }
        else
        {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(ModInfo.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
        }
    }
}
