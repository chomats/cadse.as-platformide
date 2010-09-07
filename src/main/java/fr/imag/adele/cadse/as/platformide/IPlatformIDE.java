/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Copyright (C) 2006-2010 Adele Team/LIG/Grenoble University, France
 */
package fr.imag.adele.cadse.as.platformide;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.osgi.framework.Bundle;

import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.CadseRuntime;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.content.ContentItem;

/**

*/
public interface IPlatformIDE {

	void addListener(IPlatformListener l);

	void removeListener(IPlatformListener l);

	boolean isResourceStarted();

	boolean isUIStarted();

	File getLocation(boolean wait);

	Bundle findBundle(String symbolicName);

	List<Bundle> findBundlePrefix(String prefix);

	void waitUI();

	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	public File getLocation();

	/**
	 * Notifie changed content.
	 * 
	 * @param item
	 *            the item
	 */
	public void notifieChangedContent(Item item);

	/**
	 * Refresh.
	 * 
	 * @param item
	 *            the item
	 */
	public void refresh(Item item);

	/**
	 * Sets the read only.
	 * 
	 * @param item
	 *            the item
	 * @param readonly
	 *            the readonly
	 */
	public void setReadOnly(Item item, boolean readonly);

	/**
	 * Log.
	 * 
	 * @param type
	 *            the type
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public void log(String type, String message, Throwable e);

	/**
	 * Log.
	 * 
	 * @param type
	 *            the type
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public void log(String type, String message, Throwable e, Item item);

	/**
	 * Begin rule.
	 * 
	 * @param rule
	 *            the rule
	 */
	public void beginRule(Object rule);

	/**
	 * End rule.
	 * 
	 * @param rule
	 *            the rule
	 */
	public void endRule(Object rule);

	/**
	 * Sets the item persistence id.
	 * 
	 * @param projectName
	 *            the project name
	 * @param item
	 *            the item
	 * 
	 * @throws CadseException
	 *             the melusine exception
	 */
	public void setItemPersistenceID(String projectName, Item item)
			throws CadseException;

	/**
	 * Copy resource.
	 * 
	 * @param item
	 *            the item
	 * @param path
	 *            the path
	 * @param data
	 *            the data
	 * 
	 * @throws CadseException
	 */
	public void copyResource(Item item, String path, URL data)
			throws CadseException;

	public boolean inDevelopmentMode();

	public CadseRuntime[] openDialog(boolean askToErase);

	public void activateIDE();

	/**
	 * Returns name of main resource related to specified content item. Returns
	 * null if it does not represents a physical resource.
	 * 
	 * @param contentItem
	 *            an item which represents a content
	 * @return name of main resource related to specified content item.
	 */
	public String getRessourceName(ContentItem contentItem);

}
