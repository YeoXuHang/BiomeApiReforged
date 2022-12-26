package net.yeoxuhang.biomeapireforged.impl.biome;

public interface BiomeSourceAccess {
    boolean fabric_shouldModifyBiomeEntries();

    void fabric_setModifyBiomeEntries(boolean modifyBiomeEntries);
}
