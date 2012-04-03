/**
 * Generated by Gas3 v2.2.0 (Granite Data Services).
 *
 * NOTE: this file is only generated if it does not exist. You may safely put
 * your custom code here.
 */

package org.openforis.collect.model.proxy {
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	import mx.messaging.management.Attribute;
	
	import org.granite.collections.IMap;
	import org.openforis.collect.metamodel.proxy.AttributeDefinitionProxy;
	import org.openforis.collect.metamodel.proxy.EntityDefinitionProxy;
	import org.openforis.collect.metamodel.proxy.NumberAttributeDefinitionProxy;
	import org.openforis.collect.metamodel.proxy.NumberAttributeDefinitionProxy$Type;
	import org.openforis.collect.util.ObjectUtil;
	import org.openforis.collect.util.StringUtil;
	import org.openforis.collect.util.UIUtil;

	/**
	 * @author S. Ricci
	 */
    [Bindable]
    [RemoteClass(alias="org.openforis.collect.model.proxy.EntityProxy")]
    public class EntityProxy extends EntityProxyBase {
		
		private static const KEY_LABEL_SEPARATOR:String = "-";
		private static const FULL_KEY_LABEL_SEPARATOR:String = " ";
		
		private var _keyText:String;
		private var _fullKeyText:String;
		private var _compactKeyText:String;
		private var _definition:EntityDefinitionProxy;
		private var _enumeratedEntitiesCodeWidths:Array;
		
		override public function init():void {
			super.init();
			updateEnumeratedCodeWidths();
			updateKeyText();
		}
		
		protected function updateEnumeratedCodeWidths():void {
			_enumeratedEntitiesCodeWidths = new Array();
			var entities:IList = getChildEntities();
			for each (var e:EntityProxy in entities) {
				if(e.enumerated) {
					var name:String = e.name;
					var maxWidth:Number = _enumeratedEntitiesCodeWidths[name];
					var keyAttribute:CodeAttributeProxy = e.getKeyAttribute();
					if(keyAttribute != null && keyAttribute.codeListItem != null) {
						var label:String = keyAttribute.codeListItem.getLabelText();
						//var width:Number = label.length * 7;
						var width:Number = UIUtil.measureFixedCodeWidth(label);
						if(keyAttribute.codeListItem.qualifiable) {
							width += 104; //space for qualifier text input
						}
						if(!isNaN(maxWidth)) {
							maxWidth = Math.max(maxWidth, width);
						} else {
							maxWidth = width;
						}
					}
					_enumeratedEntitiesCodeWidths[name] = maxWidth;
				}
			}
		}
		
		protected function getKeyAttribute():CodeAttributeProxy {
			var children:IList = getChildren();
			for each (var child:NodeProxy in children) {
				if(child is CodeAttributeProxy) {
					var codeAttribute:CodeAttributeProxy = CodeAttributeProxy(child);
					if(codeAttribute.enumerator) {
						return codeAttribute;
					}
				}
			}
			return null;
		}
		
		/**
		 * Traverse each child and pass it to the argument function
		 * */
		public function traverse(funct:Function):void {
			var children:IList = getChildren();
			for each (var child:NodeProxy in children) {
				funct(child);
				if(child is EntityProxy) {
					EntityProxy(child).traverse(funct);
				}
			}
		}
		
		public function getSingleAttribute(attributeName:String):AttributeProxy {
			var attributes:IList = childrenByName.get(attributeName);
			if(attributes != null) {
				if(attributes.length == 1) {
					var attribute:AttributeProxy = attributes.getItemAt(0) as AttributeProxy;
					return attribute;
				} else if (attributes.length > 1) {
					throw new Error("Single attribute expected");
				}
			}
			return null;
		}
		
		public function getChildren(nodeName:String = null):IList {
			if(nodeName != null) {
				return childrenByName.get(nodeName);
			} else {
				var result:ArrayCollection = new ArrayCollection();
				var listsOfChildren:ArrayCollection = childrenByName.values;
				for each (var list:IList in listsOfChildren) {
					result.addAll(list);
				}
				return result;
			}
		}

		public function getChild(nodeName:String, index:int):NodeProxy {
			var children:IList = getChildren(nodeName);
			if(children != null && children.length > index) {
				return children.getItemAt(index) as NodeProxy;
			} else {
				return null;
			}
		}
		
		public function getChildEntities():IList {
			var entities:IList = new ArrayCollection();
			var values:IList = childrenByName.values;
			for each (var childList:IList in values) {
				for each (var child:NodeProxy in childList) {
					if(child is EntityProxy) {
						entities.addItem(child);
					}
				}
			}
			return entities;
		}
		
		public function addChild(node:NodeProxy):void {
			var name:String = node.name;
			var children:ArrayCollection = childrenByName.get(name);
			if(children == null) {
				children = new ArrayCollection();
				childrenByName.put(name, children);
			}
			children.addItem(node);
			node.parent = this;
			node.init();
			showErrorsOnChild(name);
		}
		
		public function removeChild(node:NodeProxy):void {
			var name:String = node.name;
			var children:IList = childrenByName.get(name);
			var index:int = children.getItemIndex(node);
			if(index >= 0) {
				children.removeItemAt(index);
			}
			showErrorsOnChild(name);
		}
		
		public function replaceChild(oldNode:NodeProxy, newNode:NodeProxy):void {
			var name:String = oldNode.name;
			var children:ArrayCollection = childrenByName.get(name);
			var index:int = children.getItemIndex(oldNode);
			children.setItemAt(newNode, index);
		}
		
		public function updateKeyText():void {
			if(_definition != null) {
				var keyDefs:IList = _definition.keyAttributeDefinitions;
				if(keyDefs.length > 0) {
					var shortKeyParts:Array = new Array();
					var fullKeyParts:Array = new Array();
					for each (var def:AttributeDefinitionProxy in keyDefs) {
						var key:AttributeProxy = getSingleAttribute(def.name);
						if(key != null) {
							var keyPart:String = getKeyLabelPart(def, key);
							if(StringUtil.isNotBlank(keyPart)) {
								shortKeyParts.push(keyPart);
								var label:String = def.getLabelText();
								var fullKeyPart:String = label + " " + keyPart;
								fullKeyParts.push(fullKeyPart);
							}
						}
					}
					keyText = StringUtil.concat(KEY_LABEL_SEPARATOR, shortKeyParts);
					fullKeyText = StringUtil.concat(FULL_KEY_LABEL_SEPARATOR, fullKeyParts);
				} else if(parent != null) {
					var siblings:IList = parent.getChildren(name);
					var itemIndex:int = siblings.getItemIndex(this);
					keyText = String(itemIndex + 1);
					fullKeyText = keyText;
				}
			} else {
				keyText = "";
				fullKeyText = "";
			}
		}
		
		private function getKeyLabelPart(attributeDefn:AttributeDefinitionProxy, attribute:AttributeProxy):String {
			var result:String = null;
			var f:FieldProxy = attribute.getField(0);
			var value:Object = f.value;
			if(ObjectUtil.isNotNull(value)) {
				if(attributeDefn is NumberAttributeDefinitionProxy) {
					var numberDefn:NumberAttributeDefinitionProxy = NumberAttributeDefinitionProxy(attributeDefn);
					switch(numberDefn.type) {
						case NumberAttributeDefinitionProxy$Type.INTEGER:
							result = int(value).toString();
							break;
						case NumberAttributeDefinitionProxy$Type.REAL:
						default:
							result = Number(value).toString();
					}
				} else {
					result = value.toString();
				}
			}
			return result;
		}
		
		public function updateChildrenMinCountValiditationMap(map:IMap):void {
			updateMap(childrenMinCountValidationMap, map);
		}
		
		public function updateChildrenMaxCountValiditationMap(map:IMap):void {
			updateMap(childrenMaxCountValidationMap, map);
		}

		public function updateChildrenRelevanceMap(map:IMap):void {
			updateMap(childrenRelevanceMap, map);
		}

		public function updateChildrenRequiredMap(map:IMap):void {
			updateMap(childrenRequiredMap, map);
		}
		
		public function showErrorsOnChild(name:String):void {
			showChildrenErrorsMap.put(name, true);
		}
		
		public function isErrorOnChildVisible(name:String):Boolean {
			var result:Boolean = showChildrenErrorsMap.get(name);
			return result;
		}
		
		public function isRequired(childName:String):Boolean {
			var required:Boolean = childrenRequiredMap.get(childName);
			return required == true;
		}
		
		public function showErrorsOnDescendants():void {
			var childNodeNames:ArrayCollection = showChildrenErrorsMap.keySet;
			for each (var name:String in childNodeNames) {
				showChildrenErrorsMap.put(name, true);
				var children:IList = getChildren(name);
				for each (var child:NodeProxy in children) {
					if(child is EntityProxy) {
						EntityProxy(child).showErrorsOnDescendants();
					}
				}
			}
		}
		
		override public function hasErrors():Boolean {
			var children:IList = getChildren();
			for each(var child:NodeProxy in children){
				if( child.hasErrors() ) {
					return true;
				}
			}
			return false;
		}
		
		public function childContainsErrors(childName:String):Boolean {
			var children:IList = getChildren(childName);
			for each(var child:NodeProxy in children){
				if( child.hasErrors() ) {
					return true;
				}
			}
			return false;
		}
		
		public function hasConfirmedError(childName:String):Boolean {
			var children:IList = getChildren(childName);
			for each(var child:NodeProxy in children){
				if(child is AttributeProxy){
					var attr:AttributeProxy = child as AttributeProxy;
					if( !attr.errorConfirmed ){
						return false;
					}
				} else {
					return false;
				}
			}
			return true;
		}
		
		public function getEnumeratedCodeWidth(entityName:String):Number {
			var result:Number = _enumeratedEntitiesCodeWidths[entityName];
			return result;
		}
		
		public function getCount(childName:String):int {
			var children:IList = getChildren(childName);
			return children.length;
		}
		
		public function get keyText():String {
			return _keyText;
		}
		
		public function set keyText(value:String):void {
			_keyText = value;
		}
		
		public function get fullKeyText():String {
			return _fullKeyText;
		}
		
		public function set fullKeyText(value:String):void {
			_fullKeyText = value;
		}
		
		public function get definition():EntityDefinitionProxy {
			return _definition;
		}
		
		public function set definition(value:EntityDefinitionProxy):void {
			_definition = value;
		}

		public function get enumeratedEntitiesCodeWidths():Array {
			return _enumeratedEntitiesCodeWidths;
		}

		public function set enumeratedEntitiesCodeWidths(value:Array):void {
			_enumeratedEntitiesCodeWidths = value;
		}

		protected function updateMap(map:IMap, newMap:IMap):void {
			if(map != null && newMap != null) {
				var newKeys:ArrayCollection = newMap.keySet;
				for each (var key:* in newKeys) {
					var value:* = newMap.get(key);
					if(value != null) {
						map.put(key, value);
					}
				}
			}
		}
		
		
	}
}