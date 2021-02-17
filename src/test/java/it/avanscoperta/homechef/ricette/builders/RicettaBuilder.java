package it.avanscoperta.homechef.ricette.builders;

import it.avanscoperta.homechef.ricette.domain.Ricetta;
import it.avanscoperta.homechef.ricette.domain.RicettaId;

public class RicettaBuilder {
	public Ricetta build(String title) {
		return new Ricetta(RicettaId.generate(), title);
	}
}
