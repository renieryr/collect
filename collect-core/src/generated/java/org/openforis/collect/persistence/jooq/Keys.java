/**
 * This class is generated by jOOQ
 */
package org.openforis.collect.persistence.jooq;

/**
 * This class is generated by jOOQ.
 *
 * A class modelling foreign key relationships between tables of the collect schema
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.1"},
                            comments = "This class is generated by jOOQ")
@SuppressWarnings({"unchecked"})
public class Keys extends org.jooq.impl.AbstractKeys {

	// IDENTITY definitions

	// UNIQUE and PRIMARY KEY definitions
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.DataRecord> data_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.Data.DATA, org.openforis.collect.persistence.jooq.tables.Data.DATA.ID);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.LogoRecord> logo_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.Logo.LOGO, org.openforis.collect.persistence.jooq.tables.Logo.LOGO.POS);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.RecordRecord> record_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.Record.RECORD, org.openforis.collect.persistence.jooq.tables.Record.RECORD.ID);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.SamplingDesignRecord> sampling_design_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.SamplingDesign.SAMPLING_DESIGN, org.openforis.collect.persistence.jooq.tables.SamplingDesign.SAMPLING_DESIGN.ID);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.SchemaDefinitionRecord> schema_definition_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.SchemaDefinition.SCHEMA_DEFINITION, org.openforis.collect.persistence.jooq.tables.SchemaDefinition.SCHEMA_DEFINITION.ID);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.SurveyRecord> survey_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.Survey.SURVEY, org.openforis.collect.persistence.jooq.tables.Survey.SURVEY.ID);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.SurveyRecord> UK_survey_name = createUniqueKey(org.openforis.collect.persistence.jooq.tables.Survey.SURVEY, org.openforis.collect.persistence.jooq.tables.Survey.SURVEY.NAME);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.SurveyRecord> UK_survey_uri = createUniqueKey(org.openforis.collect.persistence.jooq.tables.Survey.SURVEY, org.openforis.collect.persistence.jooq.tables.Survey.SURVEY.URI);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.TaxonRecord> taxon_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.Taxon.TAXON, org.openforis.collect.persistence.jooq.tables.Taxon.TAXON.ID);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.TaxonomyRecord> taxonomy_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.Taxonomy.TAXONOMY, org.openforis.collect.persistence.jooq.tables.Taxonomy.TAXONOMY.ID);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.TaxonomyRecord> UK_taxonomy_name = createUniqueKey(org.openforis.collect.persistence.jooq.tables.Taxonomy.TAXONOMY, org.openforis.collect.persistence.jooq.tables.Taxonomy.TAXONOMY.NAME);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.TaxonVernacularNameRecord> taxon_vernacular_name_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.TaxonVernacularName.TAXON_VERNACULAR_NAME, org.openforis.collect.persistence.jooq.tables.TaxonVernacularName.TAXON_VERNACULAR_NAME.ID);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.UserAccountRecord> user_account_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.UserAccount.USER_ACCOUNT, org.openforis.collect.persistence.jooq.tables.UserAccount.USER_ACCOUNT.ID);
	public static final org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.UserRoleRecord> user_role_pkey = createUniqueKey(org.openforis.collect.persistence.jooq.tables.UserRole.USER_ROLE, org.openforis.collect.persistence.jooq.tables.UserRole.USER_ROLE.ID);

	// FOREIGN KEY definitions
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.DataRecord, org.openforis.collect.persistence.jooq.tables.records.RecordRecord> data__FK_data_record = createForeignKey(record_pkey, org.openforis.collect.persistence.jooq.tables.Data.DATA, org.openforis.collect.persistence.jooq.tables.Data.DATA.RECORD_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.DataRecord, org.openforis.collect.persistence.jooq.tables.records.SchemaDefinitionRecord> data__FK_data_schema_definition = createForeignKey(schema_definition_pkey, org.openforis.collect.persistence.jooq.tables.Data.DATA, org.openforis.collect.persistence.jooq.tables.Data.DATA.DEFINITION_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.DataRecord, org.openforis.collect.persistence.jooq.tables.records.TaxonRecord> data__FK_data_taxon = createForeignKey(taxon_pkey, org.openforis.collect.persistence.jooq.tables.Data.DATA, org.openforis.collect.persistence.jooq.tables.Data.DATA.TAXON_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.DataRecord, org.openforis.collect.persistence.jooq.tables.records.DataRecord> data__FK_data_parent = createForeignKey(data_pkey, org.openforis.collect.persistence.jooq.tables.Data.DATA, org.openforis.collect.persistence.jooq.tables.Data.DATA.PARENT_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.RecordRecord, org.openforis.collect.persistence.jooq.tables.records.SchemaDefinitionRecord> record__FK_record_root_entity = createForeignKey(schema_definition_pkey, org.openforis.collect.persistence.jooq.tables.Record.RECORD, org.openforis.collect.persistence.jooq.tables.Record.RECORD.ROOT_ENTITY_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.RecordRecord, org.openforis.collect.persistence.jooq.tables.records.UserAccountRecord> record__FK_record_created_by_user = createForeignKey(user_account_pkey, org.openforis.collect.persistence.jooq.tables.Record.RECORD, org.openforis.collect.persistence.jooq.tables.Record.RECORD.CREATED_BY_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.RecordRecord, org.openforis.collect.persistence.jooq.tables.records.UserAccountRecord> record__FK_record_modified_by_user = createForeignKey(user_account_pkey, org.openforis.collect.persistence.jooq.tables.Record.RECORD, org.openforis.collect.persistence.jooq.tables.Record.RECORD.MODIFIED_BY_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.RecordRecord, org.openforis.collect.persistence.jooq.tables.records.UserAccountRecord> record__FK_record_locked_by_user = createForeignKey(user_account_pkey, org.openforis.collect.persistence.jooq.tables.Record.RECORD, org.openforis.collect.persistence.jooq.tables.Record.RECORD.LOCKED_BY_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.SchemaDefinitionRecord, org.openforis.collect.persistence.jooq.tables.records.SurveyRecord> schema_definition__FK_schema_definition_survey = createForeignKey(survey_pkey, org.openforis.collect.persistence.jooq.tables.SchemaDefinition.SCHEMA_DEFINITION, org.openforis.collect.persistence.jooq.tables.SchemaDefinition.SCHEMA_DEFINITION.SURVEY_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.TaxonRecord, org.openforis.collect.persistence.jooq.tables.records.TaxonomyRecord> taxon__FK_taxon_taxonomy = createForeignKey(taxonomy_pkey, org.openforis.collect.persistence.jooq.tables.Taxon.TAXON, org.openforis.collect.persistence.jooq.tables.Taxon.TAXON.TAXONOMY_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.TaxonRecord, org.openforis.collect.persistence.jooq.tables.records.TaxonRecord> taxon__FK_taxon_parent = createForeignKey(taxon_pkey, org.openforis.collect.persistence.jooq.tables.Taxon.TAXON, org.openforis.collect.persistence.jooq.tables.Taxon.TAXON.PARENT_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.TaxonVernacularNameRecord, org.openforis.collect.persistence.jooq.tables.records.TaxonRecord> taxon_vernacular_name__FK_taxon_vernacular_name_taxon = createForeignKey(taxon_pkey, org.openforis.collect.persistence.jooq.tables.TaxonVernacularName.TAXON_VERNACULAR_NAME, org.openforis.collect.persistence.jooq.tables.TaxonVernacularName.TAXON_VERNACULAR_NAME.TAXON_ID);
	public static final org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.UserRoleRecord, org.openforis.collect.persistence.jooq.tables.records.UserAccountRecord> user_role__FK_user_user_role = createForeignKey(user_account_pkey, org.openforis.collect.persistence.jooq.tables.UserRole.USER_ROLE, org.openforis.collect.persistence.jooq.tables.UserRole.USER_ROLE.USER_ID);

	/**
	 * No instances
	 */
	private Keys() {}
}
