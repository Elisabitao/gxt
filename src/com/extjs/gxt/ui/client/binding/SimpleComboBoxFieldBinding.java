/*
 * Sencha GXT 2.3.1 - Sencha for GWT
 * Copyright(c) 2007-2013, Sencha, Inc.
 * licensing@sencha.com
 * 
 * http://www.sencha.com/products/gxt/license/
 */
 package com.extjs.gxt.ui.client.binding;

import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;

/**
 * A specialized binding that automatically handles data conversion when using a
 * <code>SimpleComboBox</code>.
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class SimpleComboBoxFieldBinding extends FieldBinding {

  protected SimpleComboBox simpleComboBox;

  /**
   * Creates a new simplecombobox field binding instance.
   * 
   * @param field the simple combo box
   * @param property the property name
   */
  public SimpleComboBoxFieldBinding(SimpleComboBox field, String property) {
    super(field, property);
    this.simpleComboBox = field;
  }

  @Override
  protected Object onConvertFieldValue(Object value) {
    return simpleComboBox.getSimpleValue();
  }

  @Override
  protected Object onConvertModelValue(Object value) {
    return simpleComboBox.findModel(value);
  }

}
