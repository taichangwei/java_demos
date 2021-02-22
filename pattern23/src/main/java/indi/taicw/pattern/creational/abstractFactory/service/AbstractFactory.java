package indi.taicw.pattern.creational.abstractFactory.service;

public interface AbstractFactory {

	HtmlDocument createHtml(String md);

	WordDocument createWord(String md);

}
