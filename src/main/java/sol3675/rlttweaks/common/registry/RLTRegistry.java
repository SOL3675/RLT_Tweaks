package main.java.sol3675.rlttweaks.common.registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import main.java.sol3675.rlttweaks.common.blocks.simpleblocks.AethiumAlloy;
import main.java.sol3675.rlttweaks.common.fluids.BlockFluidBase;
import main.java.sol3675.rlttweaks.common.items.ItemBase;
import main.java.sol3675.rlttweaks.common.items.ItemCastFilled;
import main.java.sol3675.rlttweaks.common.items.ItemResearchData;
import main.java.sol3675.rlttweaks.common.recipes.GeneralRecipe;
import main.java.sol3675.rlttweaks.references.ModInfo;
import main.java.sol3675.rlttweaks.references.Reference;

import java.util.ArrayList;

public class RLTRegistry
{
    public static ArrayList<Block> registeredBlock = new ArrayList<Block>();
    public static ArrayList<Item> registeredItem = new ArrayList<Item>();

    public static Block aethiumAlloy;
    public static Item itemAethiumAlloy;

    public static Block blockFluidPlasma;

    public static Item dataResearch;
    public static Item canisterEmpty;
    public static Item canisterFilled;
    public static Item canisterMolten;
    public static Item cast;
    public static Item castFilled;

    public static Fluid fluidFuelPlasma;

    public static final ResourceLocation FUEL_PLASMA_STILL = new ResourceLocation(ModInfo.MODID, "blocks/fluid/fuel_plasma_still");
    public static final ResourceLocation FUEL_PLASMA_FLOW = new ResourceLocation(ModInfo.MODID, "blocks/fluid/fuel_plasma_flow");

    static
    {
        fluidFuelPlasma = new Fluid("fuel_plasma", FUEL_PLASMA_STILL, FUEL_PLASMA_FLOW)
        .setDensity(3000).setViscosity(10).setLuminosity(15).setTemperature(10000);

        aethiumAlloy = new AethiumAlloy();
        itemAethiumAlloy = new ItemBlock(aethiumAlloy).setRegistryName("aethium_alloy");

        dataResearch = new ItemResearchData();
        canisterEmpty = new ItemBase("canister_empty", 64, "clay");
        canisterFilled = new ItemBase("canister_filled", 64, Reference.lowTiersMetal);
        canisterMolten = new ItemBase("canister_molten", 64, Reference.lowTiersMetal).setContainerItem(canisterEmpty);
        cast = new ItemBase("cast", 64, "ingot", "plate");
        castFilled = new ItemCastFilled();
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event)
    {
        System.out.println("Start register RLTTweaks Blocks");
        blockFluidPlasma = new BlockFluidBase("fuel_plasma", fluidFuelPlasma, Material.WATER);
        blockFluidPlasma.setRegistryName(blockFluidPlasma.getUnlocalizedName().substring(5));
        event.getRegistry().register(blockFluidPlasma);
        event.getRegistry().register(aethiumAlloy);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        System.out.println("Start register RLTTweaks Items");
        event.getRegistry().register(itemAethiumAlloy);
        for(Item item : registeredItem)
        {
            event.getRegistry().register(item.setRegistryName(new ResourceLocation(ModInfo.MODID, item.getUnlocalizedName().substring(5))));
        }
    }

    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        GeneralRecipe.addGeneralRecipes();
    }
/*
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event)
    {
        System.out.println("Start register RLTTweaks Models");
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
*/
}
