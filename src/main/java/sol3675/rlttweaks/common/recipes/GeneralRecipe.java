package sol3675.rlttweaks.common.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import sol3675.rlttweaks.common.registry.RLTRegistry;
import sol3675.rlttweaks.references.Reference;

public class GeneralRecipe
{
    public static void addGeneralRecipes()
    {
        for(int i = 0; i < Reference.lowTiersMetal.length; ++i)
        {
            GameRegistry.addSmelting(new ItemStack(RLTRegistry.canisterFilled, 1, i), new ItemStack(RLTRegistry.canisterMolten, 1, i), 0F);
        }

    }
}
