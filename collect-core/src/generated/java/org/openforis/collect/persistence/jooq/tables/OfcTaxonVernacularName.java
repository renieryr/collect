/**
 * This class is generated by jOOQ
 */
package org.openforis.collect.persistence.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.1"},
                            comments = "This class is generated by jOOQ")
public class OfcTaxonVernacularName extends org.jooq.impl.UpdatableTableImpl<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord> {

	private static final long serialVersionUID = -422778319;

	/**
	 * The singleton instance of ofc_taxon_vernacular_name
	 */
	public static final org.openforis.collect.persistence.jooq.tables.OfcTaxonVernacularName OFC_TAXON_VERNACULAR_NAME = new org.openforis.collect.persistence.jooq.tables.OfcTaxonVernacularName();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord> __RECORD_TYPE = org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord, java.lang.String> VERNACULAR_NAME = createField("vernacular_name", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord, java.lang.String> LANGUAGE_CODE = createField("language_code", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord, java.lang.String> LANGUAGE_VARIETY = createField("language_variety", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [collect.ofc_taxon_vernacular_name.taxon_id]
	 * REFERENCES ofc_taxon [collect.ofc_taxon.id]
	 * </pre></code>
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord, java.lang.Integer> TAXON_ID = createField("taxon_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord, java.lang.Integer> STEP = createField("step", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * No further instances allowed
	 */
	private OfcTaxonVernacularName() {
		super("ofc_taxon_vernacular_name", org.openforis.collect.persistence.jooq.Collect.COLLECT);
	}

	/**
	 * No further instances allowed
	 */
	private OfcTaxonVernacularName(java.lang.String alias) {
		super(alias, org.openforis.collect.persistence.jooq.Collect.COLLECT, org.openforis.collect.persistence.jooq.tables.OfcTaxonVernacularName.OFC_TAXON_VERNACULAR_NAME);
	}

	@Override
	public org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord> getMainKey() {
		return org.openforis.collect.persistence.jooq.Keys.ofc_taxon_vernacular_name_pkey;
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord>>asList(org.openforis.collect.persistence.jooq.Keys.ofc_taxon_vernacular_name_pkey);
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.openforis.collect.persistence.jooq.tables.records.OfcTaxonVernacularNameRecord, ?>>asList(org.openforis.collect.persistence.jooq.Keys.ofc_taxon_vernacular_name__ofc_taxon_vernacular_name_taxon_fkey);
	}

	@Override
	public org.openforis.collect.persistence.jooq.tables.OfcTaxonVernacularName as(java.lang.String alias) {
		return new org.openforis.collect.persistence.jooq.tables.OfcTaxonVernacularName(alias);
	}
}
