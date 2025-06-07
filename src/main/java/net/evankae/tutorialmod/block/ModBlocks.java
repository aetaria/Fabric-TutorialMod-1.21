package net.evankae.tutorialmod.block;

import net.evankae.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(Block.Settings.create().
                    strength(4.0f).
                    requiresTool().
                    sounds(BlockSoundGroup.AMETHYST_BLOCK)
            ));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(Block.Settings.create().
                    strength(4.0f).
                    requiresTool().
                    sounds(BlockSoundGroup.AMETHYST_BLOCK)
            ));


    public static void registerModBlocks() {
        // This method will be used to register blocks
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        // adds block to building blocks tab in creative
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });
    }

    public static void registerBlockItem(String name, Block block) {
        // This method will be used to register individual blocks with item representation
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static Block registerBlock(String name, Block block) {
        // This method will be used to register individual blocks
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }
}
