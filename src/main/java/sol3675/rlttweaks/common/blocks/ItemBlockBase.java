package sol3675.rlttweaks.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemBlockBase extends ItemBlock
{
    public ItemBlockBase(Block block)
    {
        super(block);
        if(((BlockBase)block).subNames.length > 1)
        {
            setHasSubtypes(true);
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if(((BlockBase)block).subNames != null && ((BlockBase)block).subNames.length > 0)
        {
            return getUnlocalizedName() + "." + ((BlockBase)block).subNames[Math.min(((BlockBase)block).subNames.length -1, stack.getItemDamage())];
        }
        return super.getUnlocalizedName(stack);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(this.isInCreativeTab(tab))
        {
            this.block.getSubBlocks(tab, items);
        }
    }
}
