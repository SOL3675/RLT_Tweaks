package sol3675.rlttweaks.proxy;

import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.TinkerRegistry;
import sol3675.rlttweaks.common.registry.RLTRegistry;

public class CommonProxy
{
    public void preInit()
    {

    }

    public void init()
    {
        TinkerRegistry.registerSmelteryFuel(new FluidStack(RLTRegistry.fluidFuelPlasma, 50), 100);
    }

    public void postInit()
    {

    }
}
