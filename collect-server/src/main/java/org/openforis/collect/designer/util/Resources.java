package org.openforis.collect.designer.util;

/**
 * 
 * @author S. Ricci
 *
 */
public class Resources {
	
	public static final String PAGES_BASE_PATH = "/";
	public static final String COMPONENTS_BASE_PATH = "/WEB-INF/view/zul/designer/";
	public static final String PREVIEW_PATH = "index.htm";
	
	public enum Page {
	
		MAIN("designer.htm"),
		SURVEY_EDIT("editSurvey.htm");

		private String location;
	
		private Page(String location) {
			this.location = PAGES_BASE_PATH + location;
		}
	
		public String getLocation() {
			return location;
		}
	}
	
	public enum Component {
		
		SELECT_LANGUAGE_POP_UP("survey_edit/select_language_popup.zul"),
		TABSGROUP("survey_edit/schema_layout/tabsgroup.zul"),
		TAB_LABEL_POPUP("survey_edit/schema_layout/tab_label_popup.zul"),
		TABSGROUP_LIST_OF_NODES("survey_edit/schema_layout/editablenodeslist.zul"),
		SRS_MANAGER_POP_UP("survey_edit/srs_popup.zul"),
		VERSIONING_POPUP("survey_edit/versioning_popup.zul"),
		CODE_LIST_ITEM_EDIT_POP_UP("survey_edit/code_list_item_popup.zul"),
		CODE_LISTS_POPUP("survey_edit/code_lists_popup.zul"), 
		UNITS_MANAGER_POP_UP("survey_edit/units_popup.zul"), 
		NODE("survey_edit/schema/node.zul"), 
		ENTITY("survey_edit/schema/entity.zul"),
		ATTRIBUTE("survey_edit/schema/attribute_{0}.zul"),
		ATTRIBUTE_POPUP("survey_edit/schema/attribute_popup.zul"), 
		CHECK_POPUP("survey_edit/schema/check/popup.zul"),;
		
		private String location;
		
		private Component(String location) {
			this.location = COMPONENTS_BASE_PATH + location;
		}
	
		public String getLocation() {
			return location;
		}
		
	}
}
