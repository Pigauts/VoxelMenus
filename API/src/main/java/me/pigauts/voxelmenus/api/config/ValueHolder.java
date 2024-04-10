package me.pigauts.voxelmenus.api.config;

import java.util.List;

public interface ValueHolder {

    boolean isBoolean();
    
    boolean isString();
    
    boolean isInt();
    
    boolean isDouble();
    
    boolean isFloat();

    <T> boolean isListOf(Class<T> elementType);

    boolean getBoolean();
    
    String getString();
    
    int getInt();
    
    double getDouble();
    
    float getFloat();
    
    List<String> getStringList();
    
    List<Integer> getIntegerList();

    List<Boolean> getBooleanList();

    List<Double> getDoubleList();

    List<Float> getFloatList();

    List<Long> getLongList();

    List<Byte> getByteList();

    List<Character> getCharacterList();
    
    List<Short> getShortList();

}
