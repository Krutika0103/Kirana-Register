package com.kirana.transactions.model;

import java.math.BigDecimal;

public class FinancialReport {

	 private BigDecimal totalCredits;
	    private BigDecimal totalDebits;
	    
		public BigDecimal getTotalCredits() {
			return totalCredits;
		}
		public void setTotalCredits(BigDecimal totalCredits) {
			this.totalCredits = totalCredits;
		}
		public BigDecimal getTotalDebits() {
			return totalDebits;
		}
		public void setTotalDebits(BigDecimal totalDebits) {
			this.totalDebits = totalDebits;
		}
		
		@Override
		public String toString() {
			return "FinancialReport [totalCredits=" + totalCredits + ", totalDebits=" + totalDebits + "]";
		}
	    
}
