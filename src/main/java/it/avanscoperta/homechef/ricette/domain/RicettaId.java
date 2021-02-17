package it.avanscoperta.homechef.ricette.domain;

import java.util.UUID;

public class RicettaId {
	
	 private final String id;

	    public RicettaId(String id) {
	        this.id = id;
	    }

	 public static RicettaId generate() {
	        return new RicettaId(UUID.randomUUID().toString());
	    }
}
