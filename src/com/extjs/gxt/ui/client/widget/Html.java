/*
 * Sencha GXT 2.3.1 - Sencha for GWT
 * Copyright(c) 2007-2013, Sencha, Inc.
 * licensing@sencha.com
 * 
 * http://www.sencha.com/products/gxt/license/
 */
 package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.util.SafeGxt;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * A component that contains arbitrary HTML text. The wrapping HTML tag can be
 * configured using {@link #setTagName(String)}.
 * 
 * <p />
 * Code snippet:
 * 
 * <pre>
 * &#064;code
 *    Html h = new Html(
 *      &quot;&lt;div class=text style='padding:5px'&gt;&quot;
 *      + &quot;&lt;h1&gt;Heading1&lt;/h1&gt;&quot;
 *      + &quot;&lt;i&gt;Some text&lt;/i&gt;&lt;/br&gt;&quot;
 *      + &quot;Some more text&lt;/br&gt;&quot;
 *      + &quot;  &lt;UL&gt; &lt;LI&gt;item 1 &lt;LI&gt;item 2 &lt;/UL&gt;&lt;/br&gt;&quot;
 *      + &quot;&lt;u&gt;Final text&lt;/u&gt;&lt;/div&gt;&quot;);
 *    RootPanel.get().add(h);
 * }
 * </pre>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>BoxComponent Move</dd>
 * <dd>BoxComponent Resize</dd>
 * <dd>Component Enable</dd>
 * <dd>Component Disable</dd>
 * <dd>Component BeforeHide</dd>
 * <dd>Component Hide</dd>
 * <dd>Component BeforeShow</dd>
 * <dd>Component Show</dd>
 * <dd>Component Attach</dd>
 * <dd>Component Detach</dd>
 * <dd>Component BeforeRender</dd>
 * <dd>Component Render</dd>
 * <dd>Component BrowserEvent</dd>
 * <dd>Component BeforeStateRestore</dd>
 * <dd>Component StateRestore</dd>
 * <dd>Component BeforeStateSave</dd>
 * <dd>Component SaveState</dd>
 * </dl>
 */
public class Html extends BoxComponent {

  private String tagName = "div";
  private SafeHtml html;

  /**
   * Creates a new instance.
   */
  public Html() {

  }

  /**
   * Creates a new instance with the given HTML.
   * 
   * @param html the html
   */
  public Html(SafeHtml html) {
    this.html = html;
  }

  public Html(String text) {
    this(SafeGxt.fromNullableString(text));
  }

  /**
   * Returns the component's HTML.
   * 
   * @return the html
   */
  public SafeHtml getHtml() {
    return html;
  }

  /**
   * @return the tagName
   */
  public String getTagName() {
    return tagName;
  }

  /**
   * Sets the components HTML.
   * 
   * @param html the html
   */
  public void setHtml(SafeHtml html) {
    this.html = html;
    if (rendered) {
      getElement().setInnerSafeHtml(html);
    }
  }

  public void setText(String text) {
    setHtml(SafeGxt.fromNullableString(text));
  }

  /**
   * The HTML tag name that will wrap the text (defaults to 'div'). For inline
   * behavior set the tag name to 'span'.
   * 
   * @param tagName the new tag name
   */
  public void setTagName(String tagName) {
    this.tagName = tagName;
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createElement(getTagName()), target, index);
    super.onRender(target, index);
    if (html != null) {
      setHtml(html);
    }
  }
}
