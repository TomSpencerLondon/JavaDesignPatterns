package org.example.creational.abstractfactory.end.gcp;

import org.example.creational.abstractfactory.end.Instance;
import org.example.creational.abstractfactory.end.ResourceFactory;
import org.example.creational.abstractfactory.end.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Instance.Capacity capacity) {
		return new GoogleComputeEngineInstance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new GoogleCloudStorage(capMib);
	}
	

}
