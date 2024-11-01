package org.example.creational.abstractfactory.end;

//Abstract factory with methods defined for each object type.
public interface ResourceFactory {

	Instance createInstance(Instance.Capacity capacity);
	
	Storage createStorage(int capMib);
}
