package org.springframwrok.samples.api.gateway.dto;

import java.util.List;

import lombok.NoArgsConstructor;
import lombok.Value;


@Value
@NoArgsConstructor
public class Visits {

    public List<VisitDetails> getItems() {
		return items;
	}

	/*
	 * public void setItems(List<VisitDetails> items) { this.items = items; }
	 */

	private List<VisitDetails> items = null;

}
