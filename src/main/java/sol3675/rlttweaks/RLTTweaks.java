package sol3675.rlttweaks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sol3675.rlttweaks.common.items.ItemBase;
import sol3675.rlttweaks.common.registry.RLTRegistry;
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
            return new ItemStack(RLTRegistry.dataResearch);
        }
    };


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModInfo.loadInfo(meta);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new RLTRegistry());
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event)
    {
        System.out.println("Start register RLTTweaks Models");
        ModelLoader.setCustomStateMapper(RLTRegistry.blockFluidPlasma, new StateMapperBase()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return new ModelResourceLocation(RLTRegistry.blockFluidPlasma.getRegistryName().toString());
            }
        });

        ModelLoader.setCustomModelResourceLocation(RLTRegistry.itemAethiumAlloy, 0, new ModelResourceLocation(RLTRegistry.aethiumAlloy.getRegistryName().toString()));

        for(Item item : RLTRegistry.registeredItem)
        {
            ItemBase.registerItemRender((ItemBase) item);
        }
    }
}
