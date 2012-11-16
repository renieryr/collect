/**
 * 
 */
package org.openforis.collect.persistence.xml.internal.unmarshal;

import static org.openforis.collect.metamodel.ui.UIOptionsConstants.NAME;
import static org.openforis.collect.metamodel.ui.UIOptionsConstants.TAB_SET;

import java.io.IOException;
import java.util.List;

import org.openforis.collect.metamodel.ui.UIOptions;
import org.openforis.collect.metamodel.ui.UITabSet;
import org.openforis.collect.persistence.xml.UIOptionsBinder;
import org.openforis.idm.metamodel.xml.XmlParseException;
import org.openforis.idm.metamodel.xml.internal.unmarshal.XmlPullReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * @author S. Ricci
 *
 */
public class UITabSetPR extends UITabSetPRBase {

	public UITabSetPR(UIOptionsBinder binder) {
		super(TAB_SET, binder);
		
		this.binder = binder;
		
		addChildPullReaders(
			new UITabPR(binder)
		);
	}
	
	@Override
	public synchronized void parse(XmlPullParser parser)
			throws XmlParseException, IOException {
		super.parse(parser);
	}
	
	@Override
	protected void onStartTag() throws XmlParseException,
			XmlPullParserException, IOException {
		UIOptions uiOptions = getUIOptions();
		tabSet = uiOptions.createTabSet();
		tabSet.setName(getAttribute(NAME, true));
		setParentSetInChildren(tabSet);
	}
	
	private void setParentSetInChildren(UITabSet tabSet) {
		List<XmlPullReader> childprs = getChildPullReaders();
		for (XmlPullReader pr : childprs) {
			if ( pr instanceof UITabSetPRBase ) {
				((UITabSetPRBase) pr).parentTabSet = tabSet;
			}
		}
	}
	
	

}
