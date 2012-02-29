package org.openforis.collect.persistence;

import static org.openforis.collect.persistence.jooq.tables.OfcTaxonomy.OFC_TAXONOMY;
import static org.openforis.collect.persistence.jooq.Sequences.OFC_TAXONOMY_ID_SEQ;

import java.sql.Connection;

import org.jooq.Record;
import org.jooq.UpdatableRecord;
import org.openforis.collect.persistence.jooq.MappingJooqDaoSupport;
import org.openforis.collect.persistence.jooq.MappingJooqFactory;
import org.openforis.idm.model.species.Taxonomy;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author G. Miceli
 */
public class TaxonomyDAO extends MappingJooqDaoSupport<Taxonomy, TaxonomyDAO.JooqFactory> {

	public TaxonomyDAO() {
		super(TaxonomyDAO.JooqFactory.class);
	}
	
	@Transactional
	public Taxonomy load(String name) {
		JooqFactory jf = getMappingJooqFactory();
		Record r = jf.selectByFieldQuery(OFC_TAXONOMY.NAME, name).fetchOne();
		if ( r == null ) {
			return null;
		} else {
			return jf.fromRecord(r);
		}
	}
	
	protected static class JooqFactory extends MappingJooqFactory<Taxonomy> {

		private static final long serialVersionUID = 1L;

		public JooqFactory(Connection connection) {
			super(connection, OFC_TAXONOMY.ID, OFC_TAXONOMY_ID_SEQ, Taxonomy.class);
		}

		@Override
		public void fromRecord(Record r, Taxonomy t) {
			t.setId(r.getValue(OFC_TAXONOMY.ID));
			t.setName(r.getValue(OFC_TAXONOMY.NAME));
		}
		
		@Override
		public void toRecord(Taxonomy t, UpdatableRecord<?> r) {
			r.setValue(OFC_TAXONOMY.ID, t.getId());
			r.setValue(OFC_TAXONOMY.NAME, t.getName());
			r.setValue(OFC_TAXONOMY.METADATA, " ");
		}

		@Override
		protected void setId(Taxonomy taxonomy, int id) {
			taxonomy.setId(id);
		}

		@Override
		protected int getId(Taxonomy t) {
			return t.getId();
		}
	}
}
