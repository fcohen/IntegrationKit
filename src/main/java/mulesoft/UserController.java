package mulesoft;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import mulesoft.utils.Utils;

public class UserController extends AbstractMessageTransformer {

	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		//eventContext.getMessage().setProperty("surname", "Martinez", PropertyScope.SESSION);
		Map<String, String> queryParams = message.getInboundProperty("http.uri.params");
		String pageName=queryParams.get("pageName");
		if(pageName != null){
			Properties props = new Properties();
			props.put("message", "You said Hello, Welcome to the World of mulesoft");

			File template;
			try {
				template = new File(this.getClass()
				.getResource("/template/" + pageName + ".html").toURI());
				return new StringBuffer(Utils.substitute(
						new String(Utils.readFile(template)), props));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}
			return null;
		} else {
			return null;
		}
	}
}