package main.java.sol3675.rlttweaks.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import main.java.sol3675.rlttweaks.references.ModInfo;

import java.io.File;

public class Config
{

    private static String[] researches;

    public static void lordConfig()
    {
        File cfgFile = new File(Loader.instance().getConfigDir(), ModInfo.MODID + ".cfg");
        lordConfig(cfgFile);
    }

    public static void lordConfig(File cfgFile)
    {
        Configuration config = new Configuration(cfgFile);

        try
        {
            config.load();
            researches = config.getStringList("Researches", "general", new String[]{"sample"}, "Added researches data");
        }
        catch (Exception e)
        {
            e.printStackTrace();;
        }
        finally
        {
            config.save();
        }
    }

    public static String[] getResearches()
    {
        return researches;
    }
}
