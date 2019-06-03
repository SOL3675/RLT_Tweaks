package sol3675.rlttweaks.common.registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sol3675.rlttweaks.common.fluids.BlockFluidBase;
import sol3675.rlttweaks.common.items.ItemBase;
import sol3675.rlttweaks.references.ModInfo;
import sol3675.rlttweaks.references.Reference;

import java.util.ArrayList;

import static net.minecraftforge.fluids.BlockFluidBase.LEVEL;

@Mod.EventBusSubscriber
public class RLTRegistry
{
    public static ArrayList<Item> registerdItem = new ArrayList<Item>();

    public static Block blockFluidPlasma;

    public static ItemBase canisterEmpty;
    public static ItemBase canisterFilled;
    public static ItemBase canisterMolten;

    public static Fluid fluidFuelPlasma;

    static
    {
        fluidFuelPlasma = new Fluid("fuel_plasma", new ResourceLocation(ModInfo.MODID + "blocks/fluid/fuel_plasma_still"), new ResourceLocation(ModInfo.MODID + "blocks/fluid/fuel_plasma_flow"))
        .setDensity(3000).setViscosity(10).setLuminosity(15).setTemperature(10000);

        canisterEmpty = new ItemBase("canister_empty", 64, "clay");
        canisterFilled = new ItemBase("canister_filled", 64, Reference.lowTiersMetal);
        canisterMolten = new ItemBase("canister_molten", 64, Reference.lowTiersMetal);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        FluidRegistry.addBucketForFluid(fluidFuelPlasma);
        blockFluidPlasma = new BlockFluidBase("fuel_plasma",fluidFuelPlasma, Material.WATER);
        event.getRegistry().register(blockFluidPlasma.setRegistryName(new ResourceLocation(ModInfo.MODID, blockFluidPlasma.getUnlocalizedName().substring(5))));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        for(Item item : registerdItem)
        {
            event.getRegistry().register(item.setRegistryName(new ResourceLocation(ModInfo.MODID, item.getUnlocalizedName().substring(5))));
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event)
    {
        ModelLoader.setCustomStateMapper(blockFluidPlasma, new StateMapperBase()
	{
		@Override
		protected ModelResourceLocation getModelResourceLocation(IBlockState state)
		{
			return new ModelResourceLocation(blockFluidPlasma.getRegistryName().toString());
		}
	});

        for(Item item : registerdItem)
        {
            ItemBase.registerItemRender((ItemBase) item);
        }
    }
}
