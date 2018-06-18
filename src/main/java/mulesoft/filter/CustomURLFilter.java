package mulesoft.filter;

import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.routing.filter.Filter;
import org.mule.api.security.CryptoFailureException;
import org.mule.api.security.EncryptionStrategyNotFoundException;
import org.mule.api.security.SecurityException;
import org.mule.api.security.SecurityFilter;
import org.mule.api.security.SecurityManager;
import org.mule.api.security.SecurityProviderNotFoundException;
import org.mule.api.security.UnknownAuthenticationTypeException;

import mulesoft.dao.service.UserService;

public class CustomURLFilter implements SecurityFilter {

	@Override
	public void initialise() throws InitialisationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSecurityManager(SecurityManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public SecurityManager getSecurityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSecurityProviders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSecurityProviders(String providers) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(MuleEvent event)
			throws SecurityException, UnknownAuthenticationTypeException, CryptoFailureException,
			SecurityProviderNotFoundException, EncryptionStrategyNotFoundException, InitialisationException {
	}

}
