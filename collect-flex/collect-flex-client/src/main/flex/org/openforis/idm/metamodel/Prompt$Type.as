/**
 * Generated by Gas3 v2.2.0 (Granite Data Services).
 *
 * WARNING: DO NOT CHANGE THIS FILE. IT MAY BE OVERWRITTEN EACH TIME YOU USE
 * THE GENERATOR.
 */

package org.openforis.idm.metamodel {

    import org.granite.util.Enum;

    [Bindable]
    [RemoteClass(alias="org.openforis.idm.metamodel.Prompt$Type")]
    public class Prompt$Type extends Enum {

        public static const INTERVIEW:Prompt$Type = new Prompt$Type("INTERVIEW", _);
        public static const PAPER:Prompt$Type = new Prompt$Type("PAPER", _);
        public static const HANDHELD:Prompt$Type = new Prompt$Type("HANDHELD", _);
        public static const PC:Prompt$Type = new Prompt$Type("PC", _);

        function Prompt$Type(value:String = null, restrictor:* = null) {
            super((value || INTERVIEW.name), restrictor);
        }

        override protected function getConstants():Array {
            return constants;
        }

        public static function get constants():Array {
            return [INTERVIEW, PAPER, HANDHELD, PC];
        }

        public static function valueOf(name:String):Prompt$Type {
            return Prompt$Type(INTERVIEW.constantOf(name));
        }
    }
}