package domain;

public class KompetenceImpl implements Kompetence {

	private String kompetencenavn;
	
	public KompetenceImpl(String kompetencenavn) {
        this.setKompetencenavn(kompetencenavn);
	}

	/* (non-Javadoc)
	 * @see domain.Kompetence#getKompetencenavn()
	 */
	@Override
	public String getKompetencenavn() {
		return kompetencenavn;
	}

	/* (non-Javadoc)
	 * @see domain.Kompetence#setKompetencenavn(java.lang.String)
	 */
	@Override
	public void setKompetencenavn(String kompetencenavn) {
		this.kompetencenavn = kompetencenavn;
	}
	
}
