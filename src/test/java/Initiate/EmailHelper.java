package Initiate;

import java.time.Instant;
import java.util.UUID;

public class EmailHelper {

	private static String uniqueEmail;

	/**
	 * lazily generates once and returns the same email thereafter
	 */
	public  String getUniqueEmail() {
		if (uniqueEmail == null) {
			String ts = String.valueOf(Instant.now().toEpochMilli());
			String rand = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
			uniqueEmail = String.format("user_%s_%s@example.com", ts, rand);
		}
		return uniqueEmail;
	}

}
