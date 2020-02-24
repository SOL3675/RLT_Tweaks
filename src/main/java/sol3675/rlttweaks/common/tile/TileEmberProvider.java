package main.java.sol3675.rlttweaks.common.tile;

import hellfirepvp.modularmachinery.common.machine.IOType;
import hellfirepvp.modularmachinery.common.machine.MachineComponent;
import hellfirepvp.modularmachinery.common.tiles.base.MachineComponentTile;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;

public class TileEmberProvider extends TileEntity implements MachineComponentTile
{
    @Nullable
    @Override
    public MachineComponent provideComponent()
    {
        return null;
    }

    public static class Input extends TileEmberProvider
    {
        @Nullable
        @Override
        public MachineComponent provideComponent() {
            return new MachineComponentEmberProvider(this, IOType.INPUT);
        }
    }

    public static class Output extends TileEmberProvider
    {
        @Nullable
        @Override
        public MachineComponent provideComponent() {
            return new MachineComponentEmberProvider(this, IOType.OUTPUT);
        }
    }
}
