package mulesoft.api;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import mulesoft.dao.service.LoginDaoService;
import mulesoft.model.Login;
import mulesoft.utils.Utils;

public class RestController extends AbstractMessageTransformer {

	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		//eventContext.getMessage().setProperty("surname", "Martinez", PropertyScope.SESSION);
		Map<String, String> queryParams = message.getInboundProperty("http.query.params");
		String userId=queryParams.get("userId");
		//LoginDaoService dao = new LoginDaoService();
		//Login user = dao.findByUserId(userId);
		//return user.getFirstName();
		return "its an api call : " + userId;
	}
}