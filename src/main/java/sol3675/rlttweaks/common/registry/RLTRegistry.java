package sol3675.rlttweaks.common.registry;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sol3675.rlttweaks.common.items.ItemBase;
import sol3675.rlttweaks.references.Reference;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class RLTRegistry
{
    public static ArrayList<Item> registerdItem = new ArrayList<Item>();

    public static ItemBase canisterEmpty;
    public static ItemBase canisterFilled;
    public static ItemBase canisterMolten;

    static
    {
        canisterEmpty = new ItemBase("canister_empty", 64);
        canisterFilled = new ItemBase("canister_filled", 64, Reference.lowTiersOre);
        canisterFilled = new ItemBase("canister_molten", 64, Reference.lowTiersOre);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        for(Item item : registerdItem)
        {
            event.getRegistry().register(item.setRegistryName(null/*TODO*/));
        }
    }
}
