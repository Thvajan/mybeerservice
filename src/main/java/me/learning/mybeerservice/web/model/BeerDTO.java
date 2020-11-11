package me.learning.mybeerservice.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerDTO {

	private UUID id;
	private int version;
	private OffsetDateTime createDate;
	private OffsetDateTime lastModifiedDate;
	private String beerName;
	private BeerStyle beerStyle;
	private Long upc;
	private BigDecimal price;
	private int quantityInHand;

}
