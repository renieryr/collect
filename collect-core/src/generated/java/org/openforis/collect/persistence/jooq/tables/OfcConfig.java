/**
 * This class is generated by jOOQ
 */
package org.openforis.collect.persistence.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.1"},
                            comments = "This class is generated by jOOQ")
public class OfcConfig extends org.jooq.impl.UpdatableTableImpl<org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord> {

	private static final long serialVersionUID = 1446719774;

	/**
	 * The singleton instance of ofc_config
	 */
	public static final org.openforis.collect.persistence.jooq.tables.OfcConfig OFC_CONFIG = new org.openforis.collect.persistence.jooq.tables.OfcConfig();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord> __RECORD_TYPE = org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord, java.lang.String> VALUE = createField("value", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * No further instances allowed
	 */
	private OfcConfig() {
		super("ofc_config", org.openforis.collect.persistence.jooq.Collect.COLLECT);
	}

	/**
	 * No further instances allowed
	 */
	private OfcConfig(java.lang.String alias) {
		super(alias, org.openforis.collect.persistence.jooq.Collect.COLLECT, org.openforis.collect.persistence.jooq.tables.OfcConfig.OFC_CONFIG);
	}

	@Override
	public org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord> getMainKey() {
		return org.openforis.collect.persistence.jooq.Keys.ofc_config_pkey;
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.openforis.collect.persistence.jooq.tables.records.OfcConfigRecord>>asList(org.openforis.collect.persistence.jooq.Keys.ofc_config_pkey);
	}

	@Override
	public org.openforis.collect.persistence.jooq.tables.OfcConfig as(java.lang.String alias) {
		return new org.openforis.collect.persistence.jooq.tables.OfcConfig(alias);
	}
}