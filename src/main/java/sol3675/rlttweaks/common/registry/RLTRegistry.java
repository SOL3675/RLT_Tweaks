package sol3675.rlttweaks.common.registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sol3675.rlttweaks.common.fluids.BlockFluidBase;
import sol3675.rlttweaks.common.fluids.FluidBase;
import sol3675.rlttweaks.common.items.ItemBase;
import sol3675.rlttweaks.references.ModInfo;
import sol3675.rlttweaks.references.Reference;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class RLTRegistry
{
    public static ArrayList<Block> registerdBlock = new ArrayList<Block>();
    public static ArrayList<Item> registerdItem = new ArrayList<Item>();

    public static BlockFluidBase blockFluidPlasma;

    public static ItemBase canisterEmpty;
    public static ItemBase canisterFilled;
    public static ItemBase canisterMolten;

    public static FluidBase fluidFuelPlasma;

    static
    {
        fluidFuelPlasma = new FluidBase("fuel_plasma", 3000, 10, 15, 10000);

        blockFluidPlasma = new BlockFluidBase("fuel_plasma", fluidFuelPlasma, Material.WATER);

        canisterEmpty = new ItemBase("canister_empty", 64, "clay");
        canisterFilled = new ItemBase("canister_filled", 64, Reference.lowTiersMetal);
        canisterMolten = new ItemBase("canister_molten", 64, Reference.lowTiersMetal);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        for(Block block : registerdBlock)
        {
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        for(Item item : registerdItem)
        {
            event.getRegistry().register(item);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event)
    {
        for(Block block : registerdBlock)
        {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(ModInfo.MODID + ":" + block.getUnlocalizedName().substring(15), "inventory"));
        }

        for(Item item : registerdItem)
        {
            ItemBase.registerItemRender((ItemBase) item);
        }
    }
}
