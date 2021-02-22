package indi.taicw.pattern.creational.abstractFactory.service;

import java.io.IOException;
import java.nio.file.Path;

public interface WordDocument {

	void save(Path path) throws IOException;

}
