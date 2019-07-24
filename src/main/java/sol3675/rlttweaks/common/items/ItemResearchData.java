package sol3675.rlttweaks.common.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sol3675.rlttweaks.config.Config;

import javax.annotation.Nullable;
import java.util.List;

public class ItemResearchData extends ItemBase
{
    public ItemResearchData()
    {
        super("researchData", 1, "scan", "composition", "dna");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag)
    {
        if(stack.hasTagCompound())
        {
            String key = stack.getTagCompound().getString("research");
            if(key != null)
            {
                String toolTip = ChatFormatting.BOLD + I18n.format("research.tooltip") + ChatFormatting.RESET + ChatFormatting.RED + I18n.format(key);
                list.add(toolTip);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        if(this.isInCreativeTab(tab) && Config.getResearches() != null)
        {
            for(int i = 0; i < getSubNames().length; ++i)
            {
                for(String key : Config.getResearches())
                {
                    ItemStack stack = new ItemStack(this, 1, i);
                    if(!stack.hasTagCompound())
                    {
                        stack.setTagCompound(new NBTTagCompound());
                    }
                    stack.getTagCompound().setString("research", key);
                    list.add(stack);
                }
            }
        }
    }
}
