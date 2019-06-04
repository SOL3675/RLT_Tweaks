package sol3675.rlttweaks.proxy;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import sol3675.rlttweaks.common.registry.RLTRegistry;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        FluidRegistry.addBucketForFluid(RLTRegistry.fluidFuelPlasma);
    }

    public void init(FMLInitializationEvent event)
    {
        TinkerRegistry.registerSmelteryFuel(new FluidStack(RLTRegistry.fluidFuelPlasma, 50), 100);
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
