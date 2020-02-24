package main.java.sol3675.rlttweaks.common.crafting.component;

import hellfirepvp.modularmachinery.common.crafting.ComponentType;
import main.java.sol3675.rlttweaks.references.ModInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;

public class RLTTweaksComponents
{
    public static ArrayList<ComponentType> COMPONENTS = new ArrayList<>();

    public static final ResourceLocation KEY_COMPONENT_EMBER = new ResourceLocation(ModInfo.MODID, "ember");

    public static void initComponents()
    {
        if(Loader.isModLoaded("embers"))
        {
            registerComponent(new ComponentEmber(), KEY_COMPONENT_EMBER);
        }
    }

    public static void registerComponent(ComponentType component, ResourceLocation name)
    {
        component.setRegistryName(name);
        COMPONENTS.add(component);
    }
}
