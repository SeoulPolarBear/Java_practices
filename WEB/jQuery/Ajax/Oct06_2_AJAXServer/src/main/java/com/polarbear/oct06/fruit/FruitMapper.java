package com.polarbear.oct06.fruit;

import java.util.List;

public interface FruitMapper {
	public abstract List<Fruit> getAllFruit();
	public abstract List<Fruit> getPriceFruit(Fruit f);
}
