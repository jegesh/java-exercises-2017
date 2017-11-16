package electric.college.test.server;

import java.util.HashMap;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("reverse")
public class ReverseWordService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> reverseString(
			@QueryParam("word") String word
			) {
		HashMap<String, String> map = new HashMap<>();
		map.put("original", word);
		map.put("reversed", new StringBuilder(word).reverse().toString());
		return map;
	}
}
