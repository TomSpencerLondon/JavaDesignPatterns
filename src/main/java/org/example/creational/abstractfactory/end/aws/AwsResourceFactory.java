package org.example.creational.abstractfactory.end.aws;

import org.example.creational.abstractfactory.end.Instance;
import org.example.creational.abstractfactory.end.ResourceFactory;
import org.example.creational.abstractfactory.end.ResourceFactory;
import org.example.creational.abstractfactory.end.Storage;

public class AwsResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Instance.Capacity capacity) {
		return new Ec2Instance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new S3Storage(capMib);
	}


}
