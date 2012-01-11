/**
 * 
 */
package org.openforis.collect.metamodel.proxy;

import java.util.List;

import org.granite.messaging.amf.io.util.externalizer.annotation.ExternalizedProperty;
import org.openforis.idm.metamodel.Schema;

/**
 * @author M. Togna
 * 
 */
public class SchemaProxy implements ProxyBase {

	private transient Schema schema;

	public SchemaProxy(Schema schema) {
		super();
		this.schema = schema;
	}

	@ExternalizedProperty
	public List<EntityDefinitionProxy> getRootEntityDefinitions() {
		return EntityDefinitionProxy.fromList(schema.getRootEntityDefinitions());
	}

}