package sol3675.rlttweaks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import sol3675.rlttweaks.proxy.CommonProxy;
import sol3675.rlttweaks.references.ModInfo;

@Mod(modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION)
public class RLTTweaks
{
    @Mod.Metadata(ModInfo.MODID)
    public static ModMetadata meta;

    @Mod.Instance(ModInfo.MODID)
    public static RLTTweaks instance = new RLTTweaks();

    @SidedProxy(clientSide = "sol3675.rlttweaks.proxy.ClientProxy", serverSide = "sol3675.rlttweaks.proxy.ServerProxy")
    public static CommonProxy proxy;


    public static CreativeTabs creativeTabs = new CreativeTabs(ModInfo.MODID)
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Items.COMMAND_BLOCK_MINECART);
        }
    };


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModInfo.loadInfo(meta);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
