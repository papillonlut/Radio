package fr.papillonlut.radio.block;

import fr.papillonlut.radio.Radio;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MUSIC_BLOCK = registerBlock("music_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.WOOD).strength(0.8F).burnable()));
    public static final Block MUSICAL_BLOCK = registerBlock("musical_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).sounds(BlockSoundGroup.WOOD).strength(0.8F).burnable()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Radio.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Radio.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Radio.LOGGER.info("Registering ModBlocks for " + Radio.MOD_ID);
    }
}
