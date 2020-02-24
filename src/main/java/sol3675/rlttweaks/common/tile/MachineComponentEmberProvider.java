package main.java.sol3675.rlttweaks.common.tile;

import hellfirepvp.modularmachinery.common.crafting.ComponentType;
import hellfirepvp.modularmachinery.common.lib.RegistriesMM;
import hellfirepvp.modularmachinery.common.machine.IOType;
import hellfirepvp.modularmachinery.common.machine.MachineComponent;
import main.java.sol3675.rlttweaks.common.crafting.component.RLTTweaksComponents;

public class MachineComponentEmberProvider extends MachineComponent<TileEmberProvider>
{
    private TileEmberProvider provider;

    public MachineComponentEmberProvider(TileEmberProvider provider, IOType ioType)
    {
        super(ioType);
        this.provider = provider;
    }

    @Override
    public ComponentType getComponentType()
    {
        return RegistriesMM.COMPONENT_TYPE_REGISTRY.getValue(RLTTweaksComponents.KEY_COMPONENT_EMBER);
    }

    @Override
    public TileEmberProvider getContainerProvider() {
        return provider;
    }
}
