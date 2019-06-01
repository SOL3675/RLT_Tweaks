package sol3675.rlttweaks.common.items;

import net.minecraft.item.Item;
import sol3675.rlttweaks.RLTTweaks;
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
    }

    public String[] getSubNames()
    {
        return subNames;
    }

}
