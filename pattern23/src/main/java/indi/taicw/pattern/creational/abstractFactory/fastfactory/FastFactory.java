package indi.taicw.pattern.creational.abstractFactory.fastfactory;

import indi.taicw.pattern.creational.abstractFactory.service.AbstractFactory;
import indi.taicw.pattern.creational.abstractFactory.service.HtmlDocument;
import indi.taicw.pattern.creational.abstractFactory.service.WordDocument;

public class FastFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new FastHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new FastWordDocument(md);
	}
}
