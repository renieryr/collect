package org.openforis.collect.designer.form;

import org.openforis.idm.metamodel.ModelVersion;
import org.openforis.idm.metamodel.NodeDefinition;
import org.openforis.idm.metamodel.NodeLabel.Type;
import org.openforis.idm.metamodel.Prompt;

/**
 * 
 * @author S. Ricci
 *
 */
public abstract class NodeDefinitionFormObject<T extends NodeDefinition> extends FormObject<T> {

	private String name;
	private String headingLabel;
	private String instanceLabel;
	private String numberLabel;
	private String interviewPromptLabel;
	private String paperPromptLabel;
	private String handheldPromptLabel;
	private String pcPromptLabel;
	private String description;
	private boolean multiple;
	private boolean required;
	private String requiredExpression;
	private String relevantExpression;
	private ModelVersion sinceVersion;
	private ModelVersion deprecatedVersion;
	private Integer minCount;
	private Integer maxCount;
	
	public void setValues(T source, String languageCode) {
		name = source.getName();
		headingLabel = source.getLabel(Type.HEADING, languageCode);
		instanceLabel = source.getLabel(Type.INSTANCE, languageCode);
		numberLabel = source.getLabel(Type.NUMBER, languageCode);
		interviewPromptLabel = source.getPrompt(Prompt.Type.INTERVIEW, languageCode);
		paperPromptLabel = source.getPrompt(Prompt.Type.PAPER, languageCode);
		handheldPromptLabel = source.getPrompt(Prompt.Type.HANDHELD, languageCode);
		pcPromptLabel = source.getPrompt(Prompt.Type.PC, languageCode);
		description = source.getDescription(languageCode);
		multiple = source.isMultiple();
		Integer nodeMinCount = source.getMinCount();
		required = nodeMinCount != null && nodeMinCount.intValue() == 1;
		requiredExpression = source.getRequiredExpression();
		relevantExpression = source.getRelevantExpression();
		minCount = nodeMinCount;
		maxCount = source.getMaxCount();
		sinceVersion = source.getSinceVersion();
		deprecatedVersion = source.getDeprecatedVersion();
	}
	
	public void copyValues(T dest, String languageCode) {
		dest.setName(name);
		dest.setLabel(Type.HEADING, languageCode, headingLabel);
		dest.setLabel(Type.INSTANCE, languageCode, instanceLabel);
		dest.setLabel(Type.NUMBER, languageCode, numberLabel);
		dest.setPrompt(Prompt.Type.HANDHELD, languageCode, handheldPromptLabel);
		dest.setPrompt(Prompt.Type.INTERVIEW, languageCode, interviewPromptLabel);
		dest.setPrompt(Prompt.Type.PAPER, languageCode, paperPromptLabel);
		dest.setPrompt(Prompt.Type.PC, languageCode, pcPromptLabel);
		dest.setDescription(languageCode, description);
		dest.setMultiple(multiple);
		if ( multiple ) {
			dest.setMinCount(minCount);
			dest.setMaxCount(maxCount);
			dest.setRequired(null);
			dest.setRequiredExpression(null);
		} else {
			dest.setMinCount(null);
			dest.setMaxCount(null);
			dest.setRequired(required);
			dest.setRequiredExpression(requiredExpression);
		}
		if ( sinceVersion != null && sinceVersion != VERSION_EMPTY_SELECTION ) {
			dest.setSinceVersion(sinceVersion);
		} else {
			dest.setSinceVersion(null);
		}
		if ( deprecatedVersion != null && deprecatedVersion != VERSION_EMPTY_SELECTION ) {
			dest.setDeprecatedVersion(deprecatedVersion);
		} else {
			dest.setDeprecatedVersion(null);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHeadingLabel() {
		return headingLabel;
	}
	
	public void setHeadingLabel(String headingLabel) {
		this.headingLabel = headingLabel;
	}
	
	public String getInstanceLabel() {
		return instanceLabel;
	}
	
	public void setInstanceLabel(String instanceLabel) {
		this.instanceLabel = instanceLabel;
	}
	
	public String getNumberLabel() {
		return numberLabel;
	}
	
	public void setNumberLabel(String numberLabel) {
		this.numberLabel = numberLabel;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isMultiple() {
		return multiple;
	}
	
	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}
	
	public ModelVersion getSinceVersion() {
		return sinceVersion;
	}
	
	public void setSinceVersion(ModelVersion sinceVersion) {
		this.sinceVersion = sinceVersion;
	}
	
	public ModelVersion getDeprecatedVersion() {
		return deprecatedVersion;
	}
	
	public void setDeprecatedVersion(ModelVersion deprecatedVersion) {
		this.deprecatedVersion = deprecatedVersion;
	}

	public String getInterviewPromptLabel() {
		return interviewPromptLabel;
	}

	public void setInterviewPromptLabel(String interviewPromptLabel) {
		this.interviewPromptLabel = interviewPromptLabel;
	}

	public String getPaperPromptLabel() {
		return paperPromptLabel;
	}

	public void setPaperPromptLabel(String paperPromptLabel) {
		this.paperPromptLabel = paperPromptLabel;
	}

	public String getHandheldPromptLabel() {
		return handheldPromptLabel;
	}

	public void setHandheldPromptLabel(String handheldPromptLabel) {
		this.handheldPromptLabel = handheldPromptLabel;
	}

	public String getPcPromptLabel() {
		return pcPromptLabel;
	}

	public void setPcPromptLabel(String pcPromptLabel) {
		this.pcPromptLabel = pcPromptLabel;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required =  required;
	}

	public String getRequiredExpression() {
		return requiredExpression;
	}

	public void setRequiredExpression(String requiredExpression) {
		this.requiredExpression = requiredExpression;
	}

	public String getRelevantExpression() {
		return relevantExpression;
	}

	public void setRelevantExpression(String relevantExpression) {
		this.relevantExpression = relevantExpression;
	}

	public Integer getMinCount() {
		return minCount;
	}

	public void setMinCount(Integer minCount) {
		this.minCount = minCount;
	}

	public Integer getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}

}