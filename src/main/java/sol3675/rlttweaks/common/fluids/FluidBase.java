package sol3675.rlttweaks.common.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import sol3675.rlttweaks.references.ModInfo;

public class FluidBase extends Fluid
{
    public FluidBase(String name, int density, int viscosity, int luminosity, int temperature)
    {
        super(name, new ResourceLocation(ModInfo.MODID + ":blocks/fluid/" + name + "_still"), new ResourceLocation(ModInfo.MODID + ":blocks/fluid/" + name + "_flow"));
        this.setDensity(density);
        this.setViscosity(viscosity);
        this.setLuminosity(luminosity);
        this.setTemperature(temperature);
        FluidRegistry.registerFluid(this);
        FluidRegistry.addBucketForFluid(this);
    }
}
