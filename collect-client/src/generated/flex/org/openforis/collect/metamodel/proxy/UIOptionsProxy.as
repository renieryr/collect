/**
 * Generated by Gas3 v2.3.0 (Granite Data Services).
 *
 * NOTE: this file is only generated if it does not exist. You may safely put
 * your custom code here.
 */

package org.openforis.collect.metamodel.proxy {

    [Bindable]
    [RemoteClass(alias="org.openforis.collect.metamodel.proxy.UIOptionsProxy")]
    public class UIOptionsProxy extends UIOptionsProxyBase {
		
		public function getTabSet(name:String):UITabSetProxy {
			for each (var tabSet:UITabSetProxy in tabSets) {
				if(tabSet.name == name) {
					return tabSet;
				}
			}
			return null;
		}

    }
}