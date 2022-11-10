package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Language2 message = getLanguage("Stepover Toehold With Facelock");
		if (message != null) {
			System.out.println("positive : "+message.documents[0].confidenceScores.positive);
			System.out.println("neutral : "+message.documents[0].confidenceScores.neutral);
			System.out.println("negative : "+message.documents[0].confidenceScores.negative);
		}
	}

	static Language2 getLanguage(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3b200434-text.cognitiveservices.azure.com/" + "text/analytics/v3.0/sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "bf32b21aa1a345c09db53fa95371c36b");

		Docs2 doc = new Docs2();
		doc.id = "1";
		doc.text = s;

		Source2 src = new Source2();
		src.documents = new Docs2[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);

		//InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		//JsonReader reader = WebApiConnector.postJsonReader(url, proxy, map, jsonData);
		JsonReader reader = WebApiConnector.postJsonReader(url, map, jsonData);
		Language2 message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Language2.class);
			reader.close();
		}
		return message;
	}

}

class Language2 {
	Documents2[] documents;
	String[] errors;
	String modelVersion;
}

class Documents2 {
	ConfidenceScores confidenceScores;
	String id;
	String wornings;
}

class ConfidenceScores{
	double positive;
	double neutral;
	double negative;
}

class Source2 {
	Docs2[] documents;
}

class Docs2 {
	String id;
	String text;
}
