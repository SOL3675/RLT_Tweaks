package sol3675.rlttweaks.common.blocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import sol3675.rlttweaks.common.registry.RLTRegistry;

public class ItemBlockBase extends ItemBlock
{
    public ItemBlockBase(BlockBase block)
    {
        super(block);
        if(block.getUnlocalizedName() != null)
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
