package fr.papillonlut.radio.item;

import fr.papillonlut.radio.Radio;
import fr.papillonlut.radio.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RADIO_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Radio.MOD_ID, "radio"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.radio"))
                    .icon(() -> new ItemStack(ModItems.RADIO)).entries(((displayContext, entries) -> {
                        entries.add(ModItems.RADIO);
                        entries.add(ModItems.RUBY);

                        entries.add(ModBlocks.RECEIVER_BLOCK);
                    })).build());

    public static void registerItemGroups() {
        Radio.LOGGER.info("Registering Item Groups for " + Radio.MOD_ID);
    }
}
