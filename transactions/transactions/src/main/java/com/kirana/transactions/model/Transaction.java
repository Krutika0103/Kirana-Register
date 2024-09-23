package com.kirana.transactions.model;
	
	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;

	import java.math.BigDecimal;
	import java.time.LocalDateTime;

	@Document(collection = "transactions")
	public class Transaction {
	    @Id
	    private String id;
	    private BigDecimal amount;
	    private String type; // credit or debit
	    private String currency;
	    private LocalDateTime timestamp;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public BigDecimal getAmount() {
			return amount;
		}
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
		@Override
		public String toString() {
			return "Transaction [id=" + id + ", amount=" + amount + ", type=" + type + ", currency=" + currency
					+ ", timestamp=" + timestamp + "]";
		}
		
	}


