package sol3675.rlttweaks.common.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCastFilled extends ItemBase
{

    private short updateDuration = 0;
    private static final String TAGDURATION = "duration";
    private static final String TAGMATERIAL = "material";

    public ItemCastFilled()
    {
        super("cast_filled", 1, "ingot", "plate");
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        if(++updateDuration >= 19 && entityIn instanceof EntityPlayer && stack.hasTagCompound())
        {
            updateDuration = 0;
            Short remain = stack.getTagCompound().getShort(TAGDURATION);
            if(remain > 0)
            {
                stack.getTagCompound().setShort(TAGDURATION, --remain);
            }
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag)
    {
        if(stack.hasTagCompound())
        {
            String material = stack.getTagCompound().getString(TAGMATERIAL);
            Short duration = stack.getTagCompound().getShort(TAGDURATION);
            if(material != null)
            {
                String toolTipMaterial = ChatFormatting.BOLD + I18n.format("Material:") + ChatFormatting.RESET + ChatFormatting.YELLOW + I18n.format(material);
                list.add(toolTipMaterial);
            }
            if(duration != null)
            {
                String toolTipDuration;
                if(duration != 0)
                {
                    toolTipDuration = ChatFormatting.BOLD + I18n.format("Can Craft after ") + ChatFormatting.RESET + ChatFormatting.ITALIC + duration.toString() + I18n.format(" seconds");
                }
                else
                {
                    toolTipDuration = ChatFormatting.BOLD + I18n.format("Craftable");
                }

                list.add(toolTipDuration);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        if(this.isInCreativeTab(tab))
        {
            ItemStack stack = new ItemStack(this, 1, 0);
            if(!stack.hasTagCompound())
            {
                stack.setTagCompound(new NBTTagCompound());
            }
            stack.getTagCompound().setString(TAGMATERIAL, "copper");
            short remain = 10;
            stack.getTagCompound().setShort(TAGDURATION, remain);
            list.add(stack);
        }
    }
}
