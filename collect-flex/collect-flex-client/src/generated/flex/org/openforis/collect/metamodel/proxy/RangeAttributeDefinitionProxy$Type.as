/**
 * Generated by Gas3 v2.3.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR.
 */

package org.openforis.collect.metamodel.proxy {

    import org.granite.util.Enum;

    [Bindable]
    [RemoteClass(alias="org.openforis.collect.metamodel.proxy.RangeAttributeDefinitionProxy$Type")]
    public class RangeAttributeDefinitionProxy$Type extends Enum {

        public static const INTEGER:RangeAttributeDefinitionProxy$Type = new RangeAttributeDefinitionProxy$Type("INTEGER", _);
        public static const REAL:RangeAttributeDefinitionProxy$Type = new RangeAttributeDefinitionProxy$Type("REAL", _);

        function RangeAttributeDefinitionProxy$Type(value:String = null, restrictor:* = null) {
            super((value || INTEGER.name), restrictor);
        }

        protected override function getConstants():Array {
            return constants;
        }

        public static function get constants():Array {
            return [INTEGER, REAL];
        }

        public static function valueOf(name:String):RangeAttributeDefinitionProxy$Type {
            return RangeAttributeDefinitionProxy$Type(INTEGER.constantOf(name));
        }
    }
}