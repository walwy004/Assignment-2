package unisa.dse.a2.students;

/**
 * Exception thrown when a company does not exist in the exchange.
 */
public class UntradedCompanyException extends Exception
{
	public UntradedCompanyException(String companyCode)
	{
		super(companyCode + " is not a listed company on this exchange");
	}
}
