package sol3675.rlttweaks.common.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sol3675.rlttweaks.RLTTweaks;
import sol3675.rlttweaks.common.registry.RLTRegistry;
import sol3675.rlttweaks.references.ModInfo;

public class ItemBase extends Item
{
    public String name;
    protected String[] subNames;

    public ItemBase(String name, int stackSize, String... subNames)
    {
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setHasSubtypes(subNames != null && subNames.length > 0);
        this.setCreativeTab(RLTTweaks.creativeTabs);
        this.setMaxStackSize(stackSize);
        this.name = name;
        this.subNames = subNames;
        RLTRegistry.registerdItem.add(this);
    }

    public String[] getSubNames()
    {
        return subNames;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        if(getSubNames() != null)
        {
            String subName = stack.getItemDamage()<getSubNames().length ? getSubNames()[stack.getItemDamage()] : "";
            return this.getUnlocalizedName() + "_" + subName;
        }
        return this.getUnlocalizedName();
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        if(this.isInCreativeTab(tab))
        {
            if(getSubNames() != null)
            {
                for(int i = 0; i < getSubNames().length; ++i)
                {
                    list.add(new ItemStack(this, 1, i));
                }
            }
            else
            {
                list.add(new ItemStack(this));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemRender(ItemBase item)
    {
        if(item == null || item == Items.AIR)return;
        if(item.getSubNames() != null)
        {
            for(int i = 0; i < item.getSubNames().length; ++i)
            {
                ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(ModInfo.MODID + ":" + item.getUnlocalizedName().substring(15), "inventory"));
            }
        }
        else
        {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(ModInfo.MODID + ":" + item.getUnlocalizedName().substring(15), "inventory"));
        }
    }

}
