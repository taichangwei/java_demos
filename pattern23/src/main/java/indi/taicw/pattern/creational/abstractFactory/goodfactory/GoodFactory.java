package indi.taicw.pattern.creational.abstractFactory.goodfactory;


import indi.taicw.pattern.creational.abstractFactory.service.AbstractFactory;
import indi.taicw.pattern.creational.abstractFactory.service.HtmlDocument;
import indi.taicw.pattern.creational.abstractFactory.service.WordDocument;

public class GoodFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new GoodHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new GoodWordDocument(md);
	}
}
